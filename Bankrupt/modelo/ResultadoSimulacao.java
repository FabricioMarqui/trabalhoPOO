
package modelo;

public class ResultadoSimulacao {
    private Jogador vencedor;
    private int rodadas;
    private boolean timeout;

    public ResultadoSimulacao(Jogador vencedor, int rodadas, boolean timeout) {
        this.vencedor = vencedor;
        this.rodadas = rodadas;
        this.timeout = timeout;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public int getRodadas() {
        return rodadas;
    }

    public boolean terminouPorTimeout() {
        return timeout;
    }
}
