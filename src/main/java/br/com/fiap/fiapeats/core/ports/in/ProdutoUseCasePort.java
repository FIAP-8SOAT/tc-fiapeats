package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Produto;

import java.util.List;

public interface ProdutoUseCasePort {
    void criar(Produto produto);
    Produto consultar(Long id) throws Exception;
}
