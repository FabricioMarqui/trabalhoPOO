
package modelo;

public class Cauteloso extends Jogador {
    public Cauteloso() {
        super("Cauteloso");
    }

    @Override
    public boolean desejaComprar(Propriedade propriedade) {
        return getSaldo() - propriedade.getPrecoVenda() >= 80;
    }
}
