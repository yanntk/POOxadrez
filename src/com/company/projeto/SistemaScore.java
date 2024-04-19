package com.company.projeto;

import java.util.HashMap;
import java.util.Map;

public class SistemaScore {
    private Map<String, Integer> pontuacoes;
    private Map<String, Integer> tabelaPontuacao;

    public SistemaScore() {
        pontuacoes = new HashMap<String, Integer>();
        tabelaPontuacao = new HashMap<String, Integer>();
    }

    public void adicionarPontuacao(String jogador, int pontos) {
        // Verifica se o jogador já existe na tabela de pontuações
        if (!tabelaPontuacao.containsKey(jogador)) {
            tabelaPontuacao.put(jogador, 0);
        }

        // Adiciona os pontos à pontuação do jogador
        int pontuacaoAtual = tabelaPontuacao.get(jogador);
        pontuacaoAtual += pontos;
        tabelaPontuacao.put(jogador, pontuacaoAtual);

        // Adiciona os pontos ao histórico de pontuações
        pontuacoes.put(jogador, pontos);

        System.out.println("Pontuação de " + jogador + " atualizada para " + pontuacaoAtual);
    }

    public int getPontuacao(String jogador) {
        // Retorna a pontuação atual do jogador
        if (tabelaPontuacao.containsKey(jogador)) {
            return tabelaPontuacao.get(jogador);
        } else {
            return 0;
        }
    }

    public int calcularPontuacao(Peca peca) {
        // Implementação do cálculo de pontuação para uma peça específica
        // Aqui você pode adicionar lógica para calcular a pontuação com base no tipo de peça
        return 0;
    }

    public static void main(String[] args) {
        SistemaScore sistemaScore = new SistemaScore();

        // Exemplo de uso
        sistemaScore.adicionarPontuacao("Jogador1", 50);
        sistemaScore.adicionarPontuacao("Jogador2", 30);
        sistemaScore.adicionarPontuacao("Jogador1", 20); // Atualiza a pontuação do Jogador1
        sistemaScore.adicionarPontuacao("Jogador3", 10);
        sistemaScore.adicionarPontuacao("Jogador2", 40); // Atualiza a pontuação do Jogador2
        System.out.println("Pontuação do Jogador1: " + sistemaScore.getPontuacao("Jogador1")); // Obtém a pontuação do Jogador1
        System.out.println("Pontuação do Jogador2: " + sistemaScore.getPontuacao("Jogador2")); // Obtém a pontuação do Jogador2
        System.out.println("Pontuação do Jogador3: " + sistemaScore.getPontuacao("Jogador3")); // Obtém a pontuação do Jogador3
    }
}
