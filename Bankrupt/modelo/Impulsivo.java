
package modelo;

public class Impulsivo extends Jogador {
    public Impulsivo() {
        super("Impulsivo");
    }

    @Override
    public boolean desejaComprar(Propriedade propriedade) {
        return true;
    }
}
