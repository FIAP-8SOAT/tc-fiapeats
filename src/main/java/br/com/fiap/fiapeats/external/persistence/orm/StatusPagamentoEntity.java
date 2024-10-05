package br.com.fiap.fiapeats.external.persistence.orm;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "StatusPagamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StatusPagamentoEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_STATUS", nullable = false)
  private Long idStatus;

  @Column(name = "DESCRICAO", nullable = false)
  private String descricao;
}
