package BusinessLogicLayer;

public class Mapa {
    /*
     * mapa é definido pelo tipo primitivo char OK
     * 
     * implementa o método sortear disponível em Exemplos; OK
     * 
     * usar o carácter ' ' (espaço em branco) para limpar o mapa; Ok
     * 
     * a cada jogada testar quem venceu a partida (jogador ou PC); considerar o caso OK
     * de empate no final da partida;
     * 
     * testar no método jogar se a linha e coluna recebida representa uma célula OK
     * livre no mapa, e em caso positivo marcar nesta célula quem jogou (usar a
     * letra).
     */

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
            DesenharLinha(i);
        }
        System.out.print("\n--------------------------");
    }

    public void Jogar(int l, int c, char jogador) {
        l--;
        c--;
        if (VerificarJogada(l, c))
            _mapa[l][c] = jogador;
    }

    public boolean VerificarGanhador(char jogador) {
        if (_mapa[0][0] == jogador && _mapa[1][1] == jogador && _mapa[2][2] == jogador   // diagonal 0
        ^   _mapa[2][2] == jogador && _mapa[1][1] == jogador && _mapa[2][0] == jogador   // diagonal 2
        ^   _mapa[0][0] == jogador && _mapa[0][1] == jogador && _mapa[0][2] == jogador   // reta 1
        ^   _mapa[1][0] == jogador && _mapa[1][1] == jogador && _mapa[1][2] == jogador   // reta 2
        ^   _mapa[2][0] == jogador && _mapa[2][1] == jogador && _mapa[2][2] == jogador   // reta 3
        ^   _mapa[0][0] == jogador && _mapa[1][0] == jogador && _mapa[2][0] == jogador   // reta 4
        ^   _mapa[0][1] == jogador && _mapa[1][1] == jogador && _mapa[2][1] == jogador   // reta 5
        ^   _mapa[0][2] == jogador && _mapa[1][2] == jogador && _mapa[2][2] == jogador   // reta 6
        ){
            return true;
        }
        return false;
    }

    private void DesenharLinha(int linha) {
        System.out.print("\n-------------\n");
        System.out.print("|");
        for (int i = 0; i < 3; i++) {
            DesenharCelula(_mapa[linha][i]);
        }
    }

    private void DesenharCelula(char valor) {
        System.out.print(" " + valor + " |");
    }

    private boolean VerificarJogada(int l, int c) {
        boolean jogadaValida = false;
        if ((l <= 3 && l >= 0) && (c <= 3 && c >= 0)) {
            if (_mapa[l][c] == ' ') {
                jogadaValida = true;
            }
        }
        return jogadaValida;
    }
}
