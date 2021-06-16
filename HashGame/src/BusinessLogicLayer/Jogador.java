package BusinessLogicLayer;

import java.util.Scanner;

public class Jogador {
    private char letra;
    private Mapa mapa;

    public Jogador(Mapa mapa) {
        letra = 'X';
        this.mapa = mapa;
    }

    public boolean jogar(Scanner teclado) {
        System.out.print("\nJogador .." + "\n  linha: ");
        int l = teclado.nextInt();
        System.out.print("  coluna: ");
        int c = teclado.nextInt();
        mapa.jogar(l, c, letra);
        boolean ganhou = mapa.verificarGanhador(letra);

        if (ganhou) {
            System.out.println("... Jogador GANHOU!");
        }
        return ganhou;
    }
}
