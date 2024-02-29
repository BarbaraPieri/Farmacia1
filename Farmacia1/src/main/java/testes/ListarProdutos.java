package testes;

import modelo.Produto;
import service.ProdutoService;

import java.util.List;

public class ListarProdutos {
    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService();
        List<Produto> produtos = produtoService.listarTodos();

        // Exibir os produtos
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: " + produto.getPreco() +
                    ", Fabricante: " + produto.getFabricante().getNome());
        }
    }
}
