package BusinessLogicLayer;

public class PC {
    private char letra;
    private Mapa mapa;

    public PC(Mapa mapa) {
        letra = 'O';
        this.mapa = mapa;
    }

    public boolean jogar() {
        int linhaSorteada;
        int colunaSorteada;
        boolean jogadaExecutada = false;
        do {
            linhaSorteada = mapa.sortear(-1, 3);
            colunaSorteada = mapa.sortear(-1, 3);
            jogadaExecutada = mapa.jogar(linhaSorteada, colunaSorteada, letra);
        } while (!jogadaExecutada);

        boolean ganhou = mapa.verificarGanhador(letra);
        if (ganhou) {
            System.out.println(" ... PC GANHOU!");
        }
        return ganhou;
    }
}
