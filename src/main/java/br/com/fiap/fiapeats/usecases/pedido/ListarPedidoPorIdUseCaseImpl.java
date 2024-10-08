package br.com.fiap.fiapeats.usecases.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidoPorIdUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidosPorPagamentoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListarPedidoPorIdUseCaseImpl implements ListarPedidoPorIdUseCase {

    private final PedidoRepositoryGateway pedidoRepositoryGateway;

    public ListarPedidoPorIdUseCaseImpl(PedidoRepositoryGateway pedidoRepositoryGateway) {
        this.pedidoRepositoryGateway = pedidoRepositoryGateway;
    }

    @Override
    public Pedido listarPedidoPorId(String idPedido) {


        var pedido = pedidoRepositoryGateway.listarPedidoPorId(idPedido);
        if (pedido == null) {
            throw new NotFoundException("Pedido com o id \"" + idPedido + "\" não encontrado! ");
        }
        return pedido;
    }

}
