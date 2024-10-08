package br.com.fiap.fiapeats.usecases.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ListarPedidosResponse {
    private String id;
    private String cliCpf;
    private String idStatus;
    private BigDecimal valor;
    private int tempoEspera;
    private LocalDateTime dataHoraCriacao;
    private String idPagamento;
    private List<ProdutoResponse> produtos;

    public ListarPedidosResponse(String id, String cliCpf, String idStatus, BigDecimal valor, int tempoEspera, LocalDateTime dataHoraCriacao,  String idPagamento, List<ProdutoResponse> produtos) {
        this.id = id;
        this.cliCpf = cliCpf;
        this.idStatus = idStatus;
        this.valor = valor;
        this.tempoEspera = tempoEspera;
        this.dataHoraCriacao = dataHoraCriacao;
        this.produtos = produtos;
        this.idPagamento = idPagamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public List<ProdutoResponse> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoResponse> produtos) {
        this.produtos = produtos;
    }

    public String getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }
}
