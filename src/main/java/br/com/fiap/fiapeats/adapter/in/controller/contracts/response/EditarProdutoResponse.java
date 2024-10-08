package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EditarProdutoResponse {

  private UUID id;

  private String nome;

  private String descricao;

  private BigDecimal valor;

  private String categoria;

  private String imagemUrl;
}
