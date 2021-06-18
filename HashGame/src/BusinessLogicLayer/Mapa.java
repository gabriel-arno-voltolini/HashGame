package BusinessLogicLayer;

public class Mapa {

    private char[][] mapa;

    public Mapa() {
        mapa = new char[3][3];
        limpar();
    }

    public int sortear(int inicio, int fim) {
        return (int) ((Math.random() * fim) - inicio);
    }

    public void limpar() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                mapa[i][j] = ' ';
            }
        }
    }

    public void desenhar(int jogada) {
        System.out.print("\n------------- .. jogada: " + jogada + "\n");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + mapa[i][j] + " |");
            }
            if (i == 2) {
                System.out.print("\n--------------------------\n");
            } else {
                System.out.print("\n-------------\n");
            }
        }
    }

    public boolean jogar(int l, int c, char jogador) {
        l--;
        c--;

        boolean jogadaValida = false;
        if ((l <= 2 && l >= 0) && (c <= 2 && c >= 0)) {
            if (mapa[l][c] == ' ') {
                jogadaValida = true;
            }
        }

        if (jogadaValida) {
            mapa[l][c] = jogador;
            return true;
        }
        return false;
    }

    public boolean verificarGanhador(char jogador) {
        if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador // diagonal 0
                || mapa[0][2] == jogador && mapa[1][1] == jogador && mapa[2][0] == jogador // diagonal 2
                || mapa[0][0] == jogador && mapa[0][1] == jogador && mapa[0][2] == jogador // reta 1
                || mapa[1][0] == jogador && mapa[1][1] == jogador && mapa[1][2] == jogador // reta 2
                || mapa[2][0] == jogador && mapa[2][1] == jogador && mapa[2][2] == jogador // reta 3
                || mapa[0][0] == jogador && mapa[1][0] == jogador && mapa[2][0] == jogador // reta 4
                || mapa[0][1] == jogador && mapa[1][1] == jogador && mapa[2][1] == jogador // reta 5
                || mapa[0][2] == jogador && mapa[1][2] == jogador && mapa[2][2] == jogador // reta 6
        ) {
            return true;
        }
        return false;
    }
}
