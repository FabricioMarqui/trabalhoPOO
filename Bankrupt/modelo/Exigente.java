
package modelo;

public class Exigente extends Jogador {
    public Exigente() {
        super("Exigente");
    }

    @Override
    public boolean desejaComprar(Propriedade propriedade) {
        return propriedade.getPrecoAluguel() > 50;
    }
}
