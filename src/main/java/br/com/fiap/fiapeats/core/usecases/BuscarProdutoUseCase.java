package br.com.fiap.fiapeats.core.usecases;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.in.BuscarProdutosUseCasePort;
import br.com.fiap.fiapeats.core.ports.in.ProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarProdutoUseCase implements BuscarProdutosUseCasePort {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> consultarProdutoPorCategoria(String categoria){
        var produtosEntity = produtoRepository.GetProdutosByCategoria(categoria);
        List<Produto> produtos = new ArrayList<>();
        produtosEntity.forEach(produtoEntity -> {
            Produto  produto = new Produto(
                    produtoEntity.getId(),
                    produtoEntity.getNome(),
                    produtoEntity.getDescricao(),
                    produtoEntity.getValor(),
                    produtoEntity.getCategoria(),
                    produtoEntity.getFoto());
            produtos.add(produto);
        });
        return produtos;

    }

    public List<Produto> listarProdutos(){
        List<Produto> produtos = new ArrayList<>();
        var produtosEntity = produtoRepository.GetProdutos();

        produtosEntity.forEach(produtoEntity -> {
            Produto  produto = new Produto(
                    produtoEntity.getId(),
                    produtoEntity.getNome(),
                    produtoEntity.getDescricao(),
                    produtoEntity.getValor(),
                    produtoEntity.getCategoria(),
                    produtoEntity.getFoto());
            produtos.add(produto);
        });

        return produtos;
    }
}
