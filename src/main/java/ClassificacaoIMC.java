public enum ClassificacaoIMC {
    BAIXO_PESO_MUITO_GRAVE("Baixo peso muito grave"),
    BAIXO_PESO_GRAVE("Baixo peso grave"),
    BAIXO_PESO("Baixo peso"),
    PESO_NORMAL("Peso normal"),
    SOBREPESO("Sobrepeso"),
    OBESIDADE_GRAU_I("Obesidade grau I"),
    OBESIDADE_GRAU_II("Obesidade grau II"),
    OBESIDADE_GRAU_III("Obesidade grau III"),
    OBESIDADE("Obesidade");

    private final String descricao;

    ClassificacaoIMC(String descricao) {
        this.descricao = descricao;
    }

    public String descricao() {
        return descricao;
    }
}
