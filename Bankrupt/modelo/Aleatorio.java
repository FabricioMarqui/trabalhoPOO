
package modelo;

import java.util.Random;

public class Aleatorio extends Jogador {
    private Random random = new Random();

    public Aleatorio() {
        super("Aleatório");
    }

    @Override
    public boolean desejaComprar(Propriedade propriedade) {
        return random.nextBoolean();
    }
}
