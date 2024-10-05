package br.com.fiap.fiapeats.adapter.controller;

import br.com.fiap.fiapeats.adapter.presenters.PedidoPresenter;
import br.com.fiap.fiapeats.external.persistence.orm.PedidoEntity;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoDTO;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoResponse;
import br.com.fiap.fiapeats.usecases.dtos.ListarPedidosResponse;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.CriarPedidoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidoPorIdUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidosPorPagamentoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidosUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PedidoController {

    private final CriarPedidoUseCase criarPedidoUseCase;

    private final ListarPedidosUseCase listarPedidosUseCase;

    private final ListarPedidosPorPagamentoUseCase listarPedidosPorPagamentoUseCase;

    private final ListarPedidoPorIdUseCase listarPedidosPorIdUseCase;

    public PedidoController(CriarPedidoUseCase criarPedidoUseCase, ListarPedidosUseCase listarPedidosUseCase, ListarPedidosPorPagamentoUseCase listarPedidosPorPagamentoUseCase, ListarPedidoPorIdUseCase listarPedidosPorIdUseCase) {
        this.criarPedidoUseCase = criarPedidoUseCase;
        this.listarPedidosUseCase = listarPedidosUseCase;
        this.listarPedidosPorPagamentoUseCase = listarPedidosPorPagamentoUseCase;
        this.listarPedidosPorIdUseCase = listarPedidosPorIdUseCase;
    }

    public CriarPedidoResponse criarNovoPedido(CriarPedidoDTO criarPedidoDTO) {
        Pedido pedido = criarPedidoUseCase.criarPedido(criarPedidoDTO);

        return PedidoPresenter.toCriarPedidoResponse(pedido);
    }

    public List<ListarPedidosResponse> listarPedidos() {
        List<Pedido> pedidos = listarPedidosUseCase.listar();

        return PedidoPresenter.toListarPedidosResponse(pedidos);
    }

    public List<ListarPedidosResponse> listarPedidosPorPagamento(Long idPagamento) {
        List<Pedido> pedidos = listarPedidosPorPagamentoUseCase.listarPedidoPorPagamento(idPagamento);

        return PedidoPresenter.toListarPedidosResponse(pedidos);
    }

    public ListarPedidosResponse listarPedidosPorId(String idPedido) {

        Pedido pedido = listarPedidosPorIdUseCase.listarPedidoPorId(idPedido);

        return PedidoPresenter.toListarPedidosResponse(pedido);
    }

}
