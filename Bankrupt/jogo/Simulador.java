
package jogo;

import enums.Comportamento;
import modelo.*;

import java.io.*;
import java.util.*;

public class Simulador {
    public void rodarSimulacoes(int totalPartidas) {
        Map<Comportamento, Integer> vitorias = new EnumMap<>(Comportamento.class);
        int partidasTimeout = 0;
        int totalRodadas = 0;

        for (Comportamento c : Comportamento.values()) vitorias.put(c, 0);

        List<Propriedade> configuracao = carregarPropriedades("Bankrupt/gameConfig.txt");

        for (int i = 0; i < totalPartidas; i++) {
            List<Jogador> jogadores = criarJogadores();
            List<Propriedade> propriedades = copiarTabuleiro(configuracao);

            Jogo jogo = new Jogo(jogadores, propriedades);
            ResultadoSimulacao resultado = jogo.simular();

            Comportamento comp = resultado.getVencedor().getComportamento();
            vitorias.put(comp, vitorias.get(comp) + 1);
            totalRodadas += resultado.getRodadas();
            if (resultado.terminouPorTimeout()) partidasTimeout++;
        }

        System.out.println("Partidas encerradas por timeout: " + partidasTimeout);
        System.out.println("Média de rodadas por partida: " + (totalRodadas / totalPartidas));

        for (Comportamento c : vitorias.keySet()) {
            int v = vitorias.get(c);
            System.out.printf("Comportamento %s venceu %.2f%% das partidas (%d/%d)%n",
                    c, 100.0 * v / totalPartidas, v, totalPartidas);
        }

        Comportamento melhor = Collections.max(vitorias.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Comportamento com mais vitórias: " + melhor);
    }

    private List<Propriedade> carregarPropriedades(String arquivo) {
        List<Propriedade> propriedades = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;

                String[] partes = linha.split("\s+");
                if (partes.length >= 2) {
                    propriedades.add(new Propriedade(Integer.parseInt(partes[0]), Integer.parseInt(partes[1])));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return propriedades;
    }

    private List<Propriedade> copiarTabuleiro(List<Propriedade> original) {
        List<Propriedade> copia = new ArrayList<>();
        for (Propriedade p : original)
            copia.add(new Propriedade(p.getPrecoVenda(), p.getPrecoAluguel()));
        return copia;
    }

    private List<Jogador> criarJogadores() {
        return List.of(
            new Impulsivo(),
            new Exigente(),
            new Cauteloso(),
            new Aleatorio()
        );
    }
}
