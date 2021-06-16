package BusinessLogicLayer;

import java.util.Scanner;

public class JogoDaVelha {
    Mapa jogoMapa;
    PC jogoPC;
    Jogador jogoJogador;

    private JogoDaVelha() {
        boolean jogarNovamente = true;
        Scanner teclado = new Scanner(System.in);
        jogoMapa = new Mapa();
        jogoPC = new PC(jogoMapa);
        jogoJogador = new Jogador(jogoMapa);
        while (jogarNovamente) {
            jogar(teclado);
            System.out.println("\nDeseja jogar novamente? \n[false] Não \n[true]  Sim\n");
            jogarNovamente = teclado.nextBoolean();
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
            jogoJogador.jogar(teclado);
            jogoPC.jogar();
            jogadorGanhou = jogoMapa.verificarGanhador('X');
            pcGanhou = jogoMapa.verificarGanhador('O');
            if (jogadorGanhou && pcGanhou) {
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
