package classes;

public class TipoSujeira {
    public static final TipoSujeira POEIRA = new TipoSujeira("🟫", "poeira");
    public static final TipoSujeira SUJEIRA_PESADA = new TipoSujeira("⬛", "sujeira pesada");
    public static final TipoSujeira LIQUIDO = new TipoSujeira("🟦", "líquido");

    private final String simbolo;
    private final String descricao;

    private TipoSujeira(String simbolo, String descricao) {
        this.simbolo = simbolo;
        this.descricao = descricao;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoSujeira[] values() {
        return new TipoSujeira[] { POEIRA, SUJEIRA_PESADA, LIQUIDO };
    }
}
