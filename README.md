# Bankrup — Simulador de Estratégias

Este projeto implementa um simulador do jogo **Bankrup**, inspirado no Banco Imobiliário, com o objetivo de comparar diferentes estratégias de jogadores por meio de múltiplas simulações.

O programa executa **300 partidas** e apresenta estatísticas sobre duração das partidas, quantidade de timeouts e taxa de vitórias de cada estratégia.

---

## Objetivo

- Simular o jogo Bankrup conforme o enunciado
- Comparar quatro comportamentos de jogadores
- Identificar qual estratégia vence com maior frequência
- Analisar o tempo médio de duração das partidas

---

## Estratégias dos Jogadores

- **Impulsivo**: compra qualquer propriedade
- **Exigente**: compra apenas propriedades com aluguel maior que 50
- **Cauteloso**: compra somente se restarem pelo menos 80 coins após a compra
- **Aleatório**: compra com probabilidade de 50%

---

## Regras do Jogo

- Cada jogador inicia com 300 coins
- O tabuleiro possui 20 propriedades
- Ao completar uma volta no tabuleiro, o jogador recebe 100 coins
- Ao cair em uma propriedade:
  - Sem dono: o jogador pode comprar
  - Com dono: o jogador paga aluguel
- Um jogador é eliminado ao ficar com saldo negativo
- O jogo termina quando:
  - Resta apenas um jogador ativo
  - Ou atinge 1000 rodadas (timeout)

Em caso de timeout, vence o jogador com mais coins.

---

## Estrutura do Projeto

```

Bankrup/
│
├── Main.java
├── game/
│   ├── Jogador.java
│   ├── Propriedade.java
│   ├── Tabuleiro.java
│   ├── Comportamento.java
│   ├── Impulsivo.java
│   ├── Exigente.java
│   ├── Cauteloso.java
│   ├── Aleatorio.java
│   ├── Partida.java
│   ├── Dado.java
│   └── LeitorConfig.java
│
├── simulacao/
│   └── Simulador.java
│
├── util/
│   └── RandomUtil.java
│
└── gameConfig.txt

```

---

## Arquivo de Configuração

O arquivo `gameConfig.txt` define as propriedades do tabuleiro.

Formato de cada linha:

```

preco aluguel

````

Cada linha representa uma propriedade, na ordem do tabuleiro.

---

## Compilação e Execução

Na pasta do projeto:

### Compilar
```bash
javac -d bin game/*.java simulacao/*.java util/*.java Main.java
````

### Executar

```bash
java -cp bin Main
```

---

## Exemplo de Saída

```
Partidas encerradas por timeout: 169
Média de rodadas por partida: 631.57

IMPULSIVO: 34.67%
CAUTELOSO: 25.67%
EXIGENTE: 21.67%
ALEATORIO: 18.00%

Comportamento com mais vitórias: IMPULSIVO
```

---

## Observações

* Os resultados variam a cada execução devido ao uso de aleatoriedade
* É esperado um número elevado de partidas finalizadas por timeout
* O comportamento impulsivo tende a vencer mais por adquirir propriedades no início do jogo

---

## Tecnologias

* Java
* Nenhuma biblioteca externa

---

## Licença

Projeto desenvolvido para fins educacionais.

```
