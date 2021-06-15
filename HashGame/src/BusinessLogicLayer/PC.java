package BusinessLogicLayer;

public class PC {
    private char letra;
    private Mapa mapa;

    public PC(Mapa mapa) {
        letra = 'O';
        this.mapa = mapa;
    }

    public boolean jogar() {
        int linhaSorteada = mapa.sortear(0, 2);
        int colunaSorteada = mapa.sortear(0, 2);

        mapa.jogar(linhaSorteada, colunaSorteada, letra);
        return mapa.verificarGanhador(letra);
    }
}
