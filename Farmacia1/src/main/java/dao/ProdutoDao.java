package dao;

import modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Produto produto){
        em.persist(produto);
    }

    public List<Produto> listarTodos() {
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p JOIN FETCH p.fabricante", Produto.class);
        return query.getResultList();
    }

    public void editarDescricao(int id, String novaDescricao) {
        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                produto.setDescricao(novaDescricao);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void deletar(int id) {
        em.getTransaction().begin();
        Produto produto = em.find(Produto.class, id);
        if (produto != null) {
            em.remove(produto);
        }
        em.getTransaction().commit();
    }
}
