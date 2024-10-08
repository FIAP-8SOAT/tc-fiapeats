package br.com.fiap.fiapeats.adapter.controller;

import br.com.fiap.fiapeats.adapter.presenters.PedidoPresenter;
import br.com.fiap.fiapeats.external.api.contracts.request.AlterarStatusPedidoRequest;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoDTO;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoResponse;
import br.com.fiap.fiapeats.usecases.dtos.ListarPedidosResponse;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.*;

import java.util.List;

public class PedidoController {

    private final CriarPedidoUseCase criarPedidoUseCase;

    private final ListarPedidosUseCase listarPedidosUseCase;

    private final ListarPedidosPorPagamentoUseCase listarPedidosPorPagamentoUseCase;

    private final ListarPedidoPorIdUseCase listarPedidosPorIdUseCase;

    private final AlterarStatusPedidoUseCase alterarStatusPedidoUseCase;

    public PedidoController(CriarPedidoUseCase criarPedidoUseCase, ListarPedidosUseCase listarPedidosUseCase, ListarPedidosPorPagamentoUseCase listarPedidosPorPagamentoUseCase, ListarPedidoPorIdUseCase listarPedidosPorIdUseCase, AlterarStatusPedidoUseCase alterarStatusPedidoUseCase) {
        this.criarPedidoUseCase = criarPedidoUseCase;
        this.listarPedidosUseCase = listarPedidosUseCase;
        this.listarPedidosPorPagamentoUseCase = listarPedidosPorPagamentoUseCase;
        this.listarPedidosPorIdUseCase = listarPedidosPorIdUseCase;
        this.alterarStatusPedidoUseCase = alterarStatusPedidoUseCase;
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

        return PedidoPresenter.toListarPedidoResponse(pedido);
    }

    public ListarPedidosResponse alterarStatusPedido(String id, AlterarStatusPedidoRequest status) {

        Pedido pedido = alterarStatusPedidoUseCase.alterarStatusPedido(id, status.getStatus());

        return PedidoPresenter.toListarPedidoResponse(pedido);
    }
}
