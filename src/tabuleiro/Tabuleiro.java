package tabuleiro;
import java.util.ArrayList;
import java.util.List;

import baralho.Baralho;
import cartas.Carta;
import jogador.Jogador;

/**
 * A classe Tabuleiro representa o tabuleiro de jogo com trilhas de cartas.
 */
public class Tabuleiro {

    /** As linhas do tabuleiro, cada uma representando uma trilha de cartas. */
    private List<List<Carta>> linhas;

    /**
     * Construtor que inicializa o tabuleiro com trilhas de cartas a partir de um baralho.
     * @param baralho O baralho a ser usado para inicializar as trilhas.
     * @param qtdLinhas A quantidade de trilhas no tabuleiro.
     */
    public Tabuleiro(Baralho baralho, int qtdLinhas) {
        this.linhas = new ArrayList<>();
        inicializarLinhas(baralho, qtdLinhas);
    }

    /**
     * Exibe o estado atual do tabuleiro, mostrando as cartas em cada trilha.
     */
    public void exibirTabuleiro() {
        System.out.println("\t\t-------------Tabuleiro--------------");
        for(int i = 0; i < this.linhas.size(); i++){
            System.out.printf("Linha %d\t\t|", i + 1);
            for(int j = 0; j < this.linhas.get(i).size(); j++){
                System.out.printf("%d\t", this.linhas.get(i).get(j).getNumero());
            }
            System.out.println();
        }
        System.out.printf("\t\t-----------------------------------\n");
    }

    /**
     * Atualiza o tabuleiro com base nas jogadas dos jogadores, movendo cartas para as trilhas apropriadas.
     * @param jogadores A lista de jogadores participando do jogo.
     */
    public void atualizaTabuleiro(List<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            Carta jogada = jogador.getJogada();
            Carta maiorCarta = new Carta(0);
            boolean cartaMenorEncontrada = false;
            int indexDaLinha = 0;
            int diferenca = 110;

            for (int i = 0; i < linhas.size(); i++){
                List<Carta> trilha = linhas.get(i);
                Carta ultimaCartaDaTrilha = trilha.get(trilha.size() - 1);

                if(jogada.compareTo(ultimaCartaDaTrilha) == 1){
                    int diferencaDasCartas = calculaDiferenca(jogada, ultimaCartaDaTrilha);
                    if(diferenca > diferencaDasCartas){
                        diferenca = diferencaDasCartas;
                        indexDaLinha = i;
                        cartaMenorEncontrada = true;
                    }
                }else{
                    if(!cartaMenorEncontrada && ultimaCartaDaTrilha.compareTo(maiorCarta) == 1){
                        maiorCarta = ultimaCartaDaTrilha;
                        indexDaLinha = i;
                    }
                }
            }

            if(cartaMenorEncontrada){
                List<Carta> trilha = linhas.get(indexDaLinha);
                if(trilha.size() == 5){
                    jogador.setPontos(jogador.getPontos() + somarPontuacao(trilha));
                    linhas.get(indexDaLinha).clear();
                    linhas.get(indexDaLinha).add(jogada);
                }else{
                    linhas.get(indexDaLinha).add(jogada);
                }
            }else{
                List<Carta> trilha = linhas.get(indexDaLinha);
                jogador.setPontos(jogador.getPontos() + somarPontuacao(trilha));
                linhas.get(indexDaLinha).clear();
                linhas.get(indexDaLinha).add(jogada);
            }
        }
    }

    // Métodos auxiliares

    /**
     * Calcula a diferença entre os números de duas cartas.
     * @param jogada A carta jogada pelo jogador.
     * @param ultimaCartaDaTrilha A última carta de uma trilha no tabuleiro.
     * @return A diferença entre os números das cartas.
     */
    private int calculaDiferenca(Carta jogada, Carta ultimaCartaDaTrilha){
        return jogada.getNumero() - ultimaCartaDaTrilha.getNumero();
    }

    /**
     * Inicializa as trilhas do tabuleiro, distribuindo uma carta de baralho para cada trilha.
     * @param baralho O baralho usado para inicializar as trilhas.
     * @param qtdLinhas A quantidade de trilhas no tabuleiro.
     */
    private void inicializarLinhas(Baralho baralho, int qtdLinhas) {
        for(int i = 0; i < qtdLinhas; i++){
            List<Carta> trilha = new ArrayList<>();
            trilha.add(baralho.distribuirUmaCarta());
            linhas.add(trilha);
        }
    }

    /**
     * Soma os pontos das cartas em uma trilha.
     * @param linha A trilha contendo as cartas.
     * @return A pontuação total das cartas na trilha.
     */
    private int somarPontuacao(List<Carta> linha){
        int pontos = 0;
        for(Carta carta: linha){
            pontos += carta.getPonto();
        }
        return pontos;
    }
}
