package classes;

import java.util.Random;

public class Sala {
    private static final String LIMPO = "⬜";
    private String[][] grid;
    private int linhas;
    private int colunas;
    private int sujeirasRestantes;

    public Sala(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.grid = new String[linhas][colunas];
        inicializar();
    }

    private void inicializar() {
        Random random = new Random();
        sujeirasRestantes = 0;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                grid[i][j] = LIMPO;
            }
        }

        int numSujeiras = (linhas * colunas) / 3;
        for (int i = 0; i < numSujeiras; i++) {
            int x = random.nextInt(linhas);
            int y = random.nextInt(colunas);
            if (grid[x][y].equals(LIMPO)) {
                TipoSujeira tipo = TipoSujeira.values()[random.nextInt(TipoSujeira.values().length)];
                grid[x][y] = tipo.getSimbolo();
                sujeirasRestantes++;
            }
        }
    }

    public String getConteudo(Posicao pos) {
        return grid[pos.getX()][pos.getY()];
    }

    public void limpar(Posicao pos) {
        if (!grid[pos.getX()][pos.getY()].equals(LIMPO)) {
            grid[pos.getX()][pos.getY()] = LIMPO;
            sujeirasRestantes--;
        }
    }

    public int getLinhas() { return linhas; }
    public int getColunas() { return colunas; }
    public int getSujeirasRestantes() { return sujeirasRestantes; }
    public boolean estaLimpa() { return sujeirasRestantes == 0; }
}
