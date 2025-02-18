package classes;

public class Simulador {
    private Sala sala;
    private Aspirador aspirador;

    public Simulador(int linhas, int colunas) {
        this.sala = new Sala(linhas, colunas);
        this.aspirador = new Aspirador(sala);
    }

    public void iniciar() {
        try {
            while (!sala.estaLimpa()) {
                exibirEstado();
                Thread.sleep(500);

                aspirador.mover();
                Posicao posAtual = aspirador.getPosicao();

                if (!sala.getConteudo(posAtual).equals("⬜")) {
                    for (TipoSujeira tipo : TipoSujeira.values()) {
                        if (sala.getConteudo(posAtual).equals(tipo.getSimbolo())) {
                            System.out.println("\nLimpando " + tipo.getDescricao() + "...");
                            sala.limpar(posAtual);
                            break;
                        }
                    }
                }

                // Limpa a tela
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

            exibirEstado();
            System.out.println("\n🎉 Limpeza concluída! A sala está totalmente limpa! 🎉");

        } catch (InterruptedException e) {
            System.out.println("Operação interrompida!");
        }
    }

    private void exibirEstado() {
        System.out.println("🏠 Simulação do Aspirador de Pó 🏠");
        System.out.println("Sujeiras restantes: " + sala.getSujeirasRestantes() + "\n");

        for (int i = 0; i < sala.getLinhas(); i++) {
            for (int j = 0; j < sala.getColunas(); j++) {
                if (i == aspirador.getPosicao().getX() && j == aspirador.getPosicao().getY()) {
                    System.out.print(aspirador.getSimbolo());
                } else {
                    System.out.print(sala.getConteudo(new Posicao(i, j)));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Simulador simulador = new Simulador(8, 8);
        simulador.iniciar();
    }
}
