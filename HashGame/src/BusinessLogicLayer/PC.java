package BusinessLogicLayer;

public class PC {
    private char Letra;
    private Mapa mapa;

    public PC(Mapa mapa) {
        Letra = 'O';
        this.mapa = mapa;
    }

    public boolean jogar(){
        int linhaSorteada = mapa.sortear(0, 2);
        int colunaSorteada = mapa.sortear(0, 2);
        
        mapa.jogar(linhaSorteada, colunaSorteada, Letra);
        return mapa.verificarGanhador(Letra);
    }
}
