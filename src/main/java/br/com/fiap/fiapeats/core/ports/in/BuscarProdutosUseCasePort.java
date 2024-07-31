package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Produto;

import java.util.List;

public interface BuscarProdutosUseCasePort {
    List<Produto> consultarProdutoPorCategoria(String categoria);
    List<Produto> listarProdutos();
}
