package BusinessLogicLayer;

import java.util.Scanner;

public class JogoDaVelha {
    Mapa jogoMapa;
    PC jogoPC;
    Jogador jogoJogador;

    private JogoDaVelha() {
        char jogarNovamente = 's';
        Scanner teclado = new Scanner(System.in);
        jogoMapa = new Mapa();
        jogoPC = new PC(jogoMapa);
        jogoJogador = new Jogador(jogoMapa);
        while (jogarNovamente == 's') {
            jogar(teclado);
            System.out.println("\nDeseja jogar novamente (s/n)?");
            jogarNovamente = teclado.next().charAt(0);
        }
        teclado.close();
    }

    private void jogar(Scanner teclado) {
        int jogadas = 0;
        boolean pcGanhou = false;
        boolean jogadorGanhou = false;

        if (jogoMapa.sortear(-1, 2) == 1) {
            jogadas++;
            jogoPC.jogar();
        }

        do {
            jogoMapa.desenhar(jogadas);
            jogadas++;
            jogadorGanhou = jogoJogador.jogar(teclado);
            pcGanhou = jogoPC.jogar();
            if ((jogadorGanhou && pcGanhou) ^ jogadas >= 5) {
                System.out.println("\nVelha");
                break;
            }
        } while (!(jogadorGanhou ^ pcGanhou));
        jogoMapa.desenhar(jogadas);
        jogoMapa.limpar();
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
