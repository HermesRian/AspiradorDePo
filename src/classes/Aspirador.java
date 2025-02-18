package classes;

public class Aspirador {
    private static final String SIMBOLO = "🤖";
    private Posicao posicao;
    private Sala sala;

    public Aspirador(Sala sala) {
        this.sala = sala;
        this.posicao = new Posicao(0, 0);
    }

    public void mover() {
        Posicao melhorDestino = encontrarSujeiraMaisProxima();
        if (melhorDestino != null) {
            if (posicao.getX() < melhorDestino.getX()) posicao.setX(posicao.getX() + 1);
            else if (posicao.getX() > melhorDestino.getX()) posicao.setX(posicao.getX() - 1);
            if (posicao.getY() < melhorDestino.getY()) posicao.setY(posicao.getY() + 1);
            else if (posicao.getY() > melhorDestino.getY()) posicao.setY(posicao.getY() - 1);
        }
    }

    private Posicao encontrarSujeiraMaisProxima() {
        int menorDistancia = Integer.MAX_VALUE;
        Posicao melhorDestino = null;

        for (int i = 0; i < sala.getLinhas(); i++) {
            for (int j = 0; j < sala.getColunas(); j++) {
                Posicao pos = new Posicao(i, j);
                if (!sala.getConteudo(pos).equals("⬜")) {
                    int distancia = posicao.calcularDistancia(pos);
                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        melhorDestino = pos;
                    }
                }
            }
        }
        return melhorDestino;
    }

    public Posicao getPosicao() { return posicao; }
    public String getSimbolo() { return SIMBOLO; }
}
