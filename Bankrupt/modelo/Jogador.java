
package modelo;

import enums.Comportamento;

public abstract class Jogador {
    protected String nome;
    protected int posicao = 0;
    protected int saldo = 300;
    protected boolean ativo = true;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public abstract boolean desejaComprar(Propriedade propriedade);

    public void movimentar(int passos, int tamanhoTabuleiro) {
        int novaPosicao = posicao + passos;
        if (novaPosicao >= tamanhoTabuleiro) {
            saldo += 100;
        }
        posicao = novaPosicao % tamanhoTabuleiro;
    }

    public void pagar(int valor) {
        saldo -= valor;
        if (saldo < 0) {
            ativo = false;
        }
    }

    public void receber(int valor) {
        saldo += valor;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean estaAtivo() {
        return ativo;
    }

    public int getPosicao() {
        return posicao;
    }

    public String getNome() {
        return nome;
    }

    public Comportamento getComportamento() {
        if (this instanceof Impulsivo) return Comportamento.IMPULSIVO;
        if (this instanceof Exigente) return Comportamento.EXIGENTE;
        if (this instanceof Cauteloso) return Comportamento.CAUTELOSO;
        return Comportamento.ALEATORIO;
    }
}
