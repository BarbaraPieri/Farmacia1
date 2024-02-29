package modelo;

import javax.persistence.*;

@Entity
@Table(name="produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private double preco;
    private String descricao;

    private boolean ativo; // Adicionando o atributo "ativo"

    @ManyToOne(fetch = FetchType.LAZY)// Definindo o carregamento lazy para a associação com Fabricante
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
