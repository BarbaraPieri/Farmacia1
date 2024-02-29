package testes;

import dao.ProdutoDao;
import dao.FabricanteDao;
import modelo.Produto;
import modelo.Fabricante;
import util.JPAUtil;

import javax.persistence.EntityManager;


public class CadrastroDeProdutos {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        // Criação de um fabricante
        Fabricante fabricante = new Fabricante();
        fabricante.setNome("Cosmed");

        // Verificar se o fabricante já existe no banco de dados
        FabricanteDao fabricanteDao = new FabricanteDao(em);
        Fabricante fabricanteExistente = fabricanteDao.buscarPorNome(fabricante.getNome());

        if (fabricanteExistente != null) {
            // Se o fabricante já existir, reutilizar o fabricante existente
            fabricante = fabricanteExistente;
        } else {
            // Se o fabricante não existir, cadastrar o novo fabricante no banco de dados
            em.getTransaction().begin();
            fabricanteDao.cadastrar(fabricante);
            em.getTransaction().commit();
        }

        // Criação de um produto
        Produto analgesico = new Produto();
        analgesico.setNome("Atroveran");
        analgesico.setPreco(25.50);
        analgesico.setDescricao("Analgésico");
        analgesico.setAtivo(true); // Definindo o produto como ativo
        analgesico.setFabricante(fabricante); // Associando o fabricante ao produto

        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(analgesico);
        em.getTransaction().commit();

        em.close();
    }
}
