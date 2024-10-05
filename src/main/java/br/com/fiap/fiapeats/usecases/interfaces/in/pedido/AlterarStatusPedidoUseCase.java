package br.com.fiap.fiapeats.usecases.interfaces.in.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.external.api.contracts.request.AlterarStatusPedidoRequest;

public interface AlterarStatusPedidoUseCase {

    Pedido alterarStatusPedido(String id, Long status);
}
