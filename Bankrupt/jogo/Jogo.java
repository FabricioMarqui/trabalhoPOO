
package jogo;

import modelo.*;

import java.util.*;

public class Jogo {
    private List<Jogador> jogadores;
    private List<Propriedade> propriedades;
    private int maxRodadas = 1000;
    private int rodadaAtual = 0;

    public Jogo(List<Jogador> jogadores, List<Propriedade> propriedades) {
        this.jogadores = new ArrayList<>(jogadores);
        this.propriedades = propriedades;
    }

    public ResultadoSimulacao simular() {
        Random dado = new Random();

        while (rodadaAtual < maxRodadas && jogadores.stream().filter(Jogador::estaAtivo).count() > 1) {
            for (Jogador jogador : jogadores) {
                if (!jogador.estaAtivo()) continue;

                int passos = dado.nextInt(6) + 1;
                jogador.movimentar(passos, propriedades.size());

                Propriedade prop = propriedades.get(jogador.getPosicao());

                if (prop.estaDisponivel() && jogador.getSaldo() >= prop.getPrecoVenda()) {
                    if (jogador.desejaComprar(prop)) {
                        jogador.pagar(prop.getPrecoVenda());
                        if (jogador.estaAtivo()) {
                            prop.setDono(jogador);
                        }
                    }
                } else if (!prop.estaDisponivel() && prop.getDono() != jogador) {
                    jogador.pagar(prop.getPrecoAluguel());
                    if (jogador.estaAtivo()) {
                        prop.getDono().receber(prop.getPrecoAluguel());
                    } else {
                        for (Propriedade p : propriedades) {
                            if (p.getDono() == jogador) {
                                p.setDono(null);
                            }
                        }
                    }
                }
            }
            rodadaAtual++;
        }

        Jogador vencedor = jogadores.stream()
            .filter(Jogador::estaAtivo)
            .max(Comparator.comparing(Jogador::getSaldo))
            .orElse(jogadores.get(0));

        return new ResultadoSimulacao(vencedor, rodadaAtual, rodadaAtual == maxRodadas);
    }
}
