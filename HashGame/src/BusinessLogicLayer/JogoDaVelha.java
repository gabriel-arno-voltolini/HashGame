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
        boolean jogadaPcExecutada = false;
        boolean jogadaJogadorExecutada = false;
        boolean jogadorGanhou = false;
        boolean pcGanhou = false;

        if (jogoMapa.sortear(-1, 2) == 1) {
            jogadas++;
            jogoPC.jogar();
        }

        do {
            jogoMapa.desenhar(jogadas);
            jogadas++;

            jogadaJogadorExecutada = jogoJogador.jogar(teclado);
            if (!jogadaJogadorExecutada) {
                System.out.println("posição inválida!");
                jogadas--;
                continue;
            }
            jogadaPcExecutada = jogoPC.jogar();
            if (!jogadaPcExecutada || (jogadorGanhou || pcGanhou) ^ jogadas >= 5) {
                System.out.println("\n... EMPATOU!");
                break;
            }
            jogadorGanhou = jogoMapa.verificarGanhador('X');
            pcGanhou = jogoMapa.verificarGanhador('O');

        } while (!(jogadorGanhou ^ pcGanhou));
        jogoMapa.desenhar(jogadas);
        jogoMapa.limpar();
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
