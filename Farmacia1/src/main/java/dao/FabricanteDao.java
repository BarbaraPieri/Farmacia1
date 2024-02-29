package dao;

import modelo.Fabricante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FabricanteDao {
    private EntityManager em;

    public FabricanteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Fabricante fabricante) {
        em.persist(fabricante);
    }
    public Fabricante buscarPorNome(String nome) {
        TypedQuery<Fabricante> query = em.createQuery("SELECT f FROM Fabricante f WHERE f.nome = :nome", Fabricante.class);
        query.setParameter("nome", nome);
        List<Fabricante> resultados = query.getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0); // Retorna o primeiro fabricante encontrado com o nome especificado
        }
        return null; // Retorna null se nenhum fabricante for encontrado
    }
}
