package br.com.fiap.fiapeats.usecases.interfaces.in.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.external.persistence.orm.PedidoEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ListarPedidoPorIdUseCase {

    Pedido listarPedidoPorId(String idPedido);
}
