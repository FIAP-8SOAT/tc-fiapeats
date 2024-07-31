package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.ProdutoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ProdutoResponse;
import br.com.fiap.fiapeats.adapter.in.utils.ImageUtils;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.in.BuscarProdutosUseCasePort;
import br.com.fiap.fiapeats.core.ports.in.ProdutoUseCasePort;
//import io.swagger.v3.oas.annotations.Parameter;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    private ProdutoUseCasePort useCase;

    @Autowired
    private BuscarProdutosUseCasePort buscarProdutosUseCasePort;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> cadastrarProduto(@RequestParam(required = true) String nome,
                                                   @RequestParam(required = true) String descricao,
                                                   @RequestParam(required = true) BigDecimal valor,
                                                   @RequestParam(required = true) String categoria,
                                                   @RequestParam(required = true) MultipartFile foto) throws IOException {
        logger.info("Requisição para criar produto recebida");

        Produto produto = new Produto(nome, descricao, valor, categoria, ImageUtils.compressImage(foto.getBytes()));

        useCase.criar(produto);

        logger.info("Produto criado com sucesso");

        return ResponseEntity.status(201).body("Produto cadastrado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> consultarProduto(@PathParam("id") Long id) throws Exception {
        logger.info("Requisição para consultar produto de ID ="+ id +  " recebida");

        var produto = useCase.consultar(id);

        if (produto.getId() == null) {
            return ResponseEntity.status(404).body("Produto não encontrado");
        }

        logger.info("Produto encontrado com sucesso");

        ProdutoResponse response = new ProdutoResponse(produto.getNome(),
                produto.getDescricao(), produto.getCategoria(), produto.getValor(),
                ImageUtils.decompressImage(produto.getFoto()));

        return ResponseEntity.status(200)
                .contentType(MediaType.valueOf(IMAGE_PNG_VALUE))
                .body(response);
    }

    @GetMapping
    public ResponseEntity<Object> listarTodosProdutos() throws Exception {
        logger.info("Requisição para listar todos produtos recebida");

        var produtos = buscarProdutosUseCasePort.listarProdutos();

        if ((long) produtos.size() == 0) {
            return ResponseEntity.status(404).body("Não tem produtos cadastrados");
        }

        logger.info("Produtos encontrado com sucesso");

        List<ProdutoResponse> response = new ArrayList<>();

        produtos.forEach( produto -> {
            ProdutoResponse produtoResponse = new ProdutoResponse(
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getCategoria(),
                    produto.getValor(),
                    produto.getFoto()
            );
            response.add(produtoResponse);
        });


        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<Object> consultarProdutoPorCategoria(@PathVariable("categoria") String categoria) throws Exception {
        logger.info("Requisição para consultar produto por categoria recebida");

        var produtos = buscarProdutosUseCasePort.consultarProdutoPorCategoria(categoria);

        if ((long) produtos.size() == 0) {
            return ResponseEntity.status(404).body("Não tem produtos dessa categoria");
        }

        logger.info("Produtos encontrado com sucesso");

        List<ProdutoResponse> response = new ArrayList<>();

        produtos.forEach( produto -> {
                    ProdutoResponse produtoResponse = new ProdutoResponse(
                            produto.getNome(),
                            produto.getDescricao(),
                            produto.getCategoria(),
                            produto.getValor(),
                            produto.getFoto()
                    );
                    response.add(produtoResponse);
                });


        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
