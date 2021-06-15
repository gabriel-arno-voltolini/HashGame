package BusinessLogicLayer;

public class PC {
    private char Letra;
    private Mapa Mapa;

    public PC(Mapa mapa) {
        Letra = 'O';
        Mapa = mapa;
    }

    public boolean Jogar(){
        int linhaSorteada = Mapa.Sortear(0, 2);
        int colunaSorteada = Mapa.Sortear(0, 2);
        
        Mapa.Jogar(linhaSorteada, colunaSorteada, Letra);
        return Mapa.VerificarGanhador(Letra);
    }
}
