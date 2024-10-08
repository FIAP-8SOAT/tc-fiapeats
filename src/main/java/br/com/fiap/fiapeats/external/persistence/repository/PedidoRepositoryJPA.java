package br.com.fiap.fiapeats.external.persistence.repository;

import br.com.fiap.fiapeats.external.persistence.orm.PedidoEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositoryJPA extends JpaRepository<PedidoEntity, UUID> {
    List<PedidoEntity> findByIdPagamento(Long idPagamento);
    @Override
    Optional<PedidoEntity> findById(UUID id);

}
