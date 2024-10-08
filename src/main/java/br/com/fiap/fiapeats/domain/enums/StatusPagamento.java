package br.com.fiap.fiapeats.domain.enums;

public enum StatusPagamento {
    PENDENTE(1, "PENDENTE"),
    APROVADO(2, "APROVADO"),
    REJEITADO(3, "REJEITADO"),
    EM_ANALISE(4, "EM ANÁLISE"),
    ESTORNADO(5, "ESTORNADO"),
    CANCELADO(6, "CANCELADO"),
    DESCONHECIDO(0, "STATUS DESCONHECIDO");

    private final int codigo;
    private final String descricao;

    StatusPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static String obterDescricaoPorCodigo(Long codigoStatus) {
        if (codigoStatus == null) {
            return "Código de status inválido";
        }

        for (StatusPagamento status : StatusPagamento.values()) {
            if (status.getCodigo() == codigoStatus.intValue()) {
                return status.getDescricao();
            }
        }

        return DESCONHECIDO.getDescricao();
    }
}

