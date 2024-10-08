package br.com.fiap.fiapeats.domain.enums;

public enum StatusPedido {
    PENDENTE(1, "PENDENTE"),
    RECEBIDO(2, "RECEBIDO"),
    EM_PREPARACAO(3, "EM PREPARAÇÃO"),
    PRONTO(4, "PRONTO"),
    FINALIZADO(5, "FINALIZADO"),
    CANCELADO(6, "CANCELADO"),
    DESCONHECIDO(0, "STATUS DESCONHECIDO");

    private final int codigo;
    private final String descricao;

    StatusPedido(int codigo, String descricao) {
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

        for (StatusPedido status : StatusPedido.values()) {
            if (status.getCodigo() == codigoStatus.intValue()) {
                return status.getDescricao();
            }
        }

        return DESCONHECIDO.getDescricao();
    }
}
