package br.com.exemplo.eicon.enums;

public enum SimNaoEnum {

    SIM("S", "Sim"),
    NAO("N", "Não");

    private String chave;
    private String descricao;

    SimNaoEnum(String chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return chave;
    }

    public String getDescricao() {
        return descricao;
    }

}
