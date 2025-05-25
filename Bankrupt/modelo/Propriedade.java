
package modelo;

public class Propriedade {
    private int precoVenda;
    private int precoAluguel;
    private Jogador dono;

    public Propriedade(int precoVenda, int precoAluguel) {
        this.precoVenda = precoVenda;
        this.precoAluguel = precoAluguel;
        this.dono = null;
    }

    public int getPrecoVenda() {
        return precoVenda;
    }

    public int getPrecoAluguel() {
        return precoAluguel;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    public boolean estaDisponivel() {
        return dono == null;
    }
}
