package testes;

import service.ProdutoService;

public class EditarDescrição {
    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService();

        // Editar a descrição do produto com ID 1
        produtoService.editarDescricao(1, "Nova descrição para o produto");

        System.out.println("Descrição do produto editada com sucesso!");
    }
}
