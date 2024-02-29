package service;

import dao.ProdutoDao;
import modelo.Produto;
import util.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoService {
    private ProdutoDao produtoDao;

    public ProdutoService() {
        EntityManager em = JPAUtil.getEntityManager();
        this.produtoDao = new ProdutoDao(em);
    }

    public List<Produto> listarTodos() {
        return produtoDao.listarTodos();
    }

    public void editarDescricao(int id, String novaDescricao) {
        produtoDao.editarDescricao(id, novaDescricao);
    }

    public void deletarProduto(int id) {
        produtoDao.deletar(id);
    }
}
