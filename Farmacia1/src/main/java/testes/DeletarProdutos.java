package testes;

import service.ProdutoService;

public class DeletarProdutos {
    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService();

        // Deletar o produto com ID 1
        produtoService.deletarProduto(1);

        System.out.println("Produto deletado com sucesso!");
    }
}
