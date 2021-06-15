package BusinessLogicLayer;

public class Mapa {

    private char[][] _mapa;

    public Mapa() {
        _mapa = new char[3][3];
        Limpar();
    }

    public int Sortear(int inicio, int fim) {
        return (int) ((Math.random() * fim) - inicio);
    }

    public void Limpar() {
        for (int i = 0; i < _mapa.length; i++) {
            for (int j = 0; j < _mapa[0].length; j++) {
                _mapa[i][j] = ' ';
            }
        }
    }

    public void Desenhar(int jogada) {
        for (int i = 0; i < 3; i++) {
            System.out.print("\n-------------\n");
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + _mapa[i][j] + " |");
            }
        }
        System.out.print("\n--------------------------");
    }

    public void Jogar(int l, int c, char jogador) {
        l--;
        c--;

        boolean jogadaValida = false;
        if ((l <= 2 && l >= 0) && (c <= 2 && c >= 0)) {
            if (_mapa[l][c] == ' ') {
                jogadaValida = true;
            }
        }

        if (jogadaValida)
            _mapa[l][c] = jogador;
    }

    public boolean VerificarGanhador(char jogador) {
        if (_mapa[0][0] == jogador && _mapa[1][1] == jogador && _mapa[2][2] == jogador // diagonal 0
                || _mapa[0][2] == jogador && _mapa[1][1] == jogador && _mapa[2][0] == jogador // diagonal 2
                || _mapa[0][0] == jogador && _mapa[0][1] == jogador && _mapa[0][2] == jogador // reta 1
                || _mapa[1][0] == jogador && _mapa[1][1] == jogador && _mapa[1][2] == jogador // reta 2
                || _mapa[2][0] == jogador && _mapa[2][1] == jogador && _mapa[2][2] == jogador // reta 3
                || _mapa[0][0] == jogador && _mapa[1][0] == jogador && _mapa[2][0] == jogador // reta 4
                || _mapa[0][1] == jogador && _mapa[1][1] == jogador && _mapa[2][1] == jogador // reta 5
                || _mapa[0][2] == jogador && _mapa[1][2] == jogador && _mapa[2][2] == jogador // reta 6
        ) {
            return true;
        }
        return false;
    }
}
