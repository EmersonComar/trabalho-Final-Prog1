package jogador;
import java.util.List;

import cartas.Carta;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A classe Jogador representa um jogador em um jogo de cartas, contendo informações sobre seu nome, mão, jogada e pontos.
 */
public class Jogador{

    /** O nome do jogador. */
    private String nome;

    /** A lista de cartas na mão do jogador. */
    private List<Carta> mao = new ArrayList<>();

    /** A carta jogada pelo jogador. */
    private Carta jogada;

    /** Os pontos acumulados pelo jogador. */
    private int pontos;

    /**
     * Construtor que inicializa um jogador com um nome e um conjunto inicial de cartas.
     * @param nome O nome do jogador.
     * @param cartas A lista de cartas inicial na mão do jogador.
     */
    public Jogador(String nome, List<Carta> cartas) {
        this.nome = nome;
        this.mao = cartas;
        this.pontos = 0;
    }

    /**
     * Obtém a carta jogada pelo jogador.
     * @return A carta jogada pelo jogador.
     */
    public Carta getJogada() {
        return jogada;
    }

    /**
     * Define a carta jogada pelo jogador.
     * @param jogada A carta a ser definida como jogada.
     */
    public void setJogada(Carta jogada) {
        this.jogada = jogada;
    }

    /**
     * Obtém o nome do jogador.
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a lista de cartas na mão do jogador.
     * @return A lista de cartas na mão do jogador.
     */
    public List<Carta> getMao() {
        return mao;
    }

    /**
     * Obtém os pontos acumulados pelo jogador.
     * @return Os pontos acumulados pelo jogador.
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Define os pontos acumulados pelo jogador.
     * @param pontos Os pontos a serem definidos.
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    /**
     * Remove uma carta específica da mão do jogador.
     * @param carta A carta a ser removida da mão do jogador.
     */
    public void removerCartaDaMao(Carta carta){
        for(int i=0; i<this.mao.size(); i++){
            Carta cartaDaMao = this.mao.get(i);
            if(carta.compareTo(cartaDaMao) == 0){
                this.mao.remove(i);
                break; // Uma vez que a carta é removida, podemos sair do loop.
            }
        }
    }

    /**
     * Exibe as informações sobre a mão do jogador, incluindo nome, pontos e cartas disponíveis.
     */
    public void exibirMao(){
        Collections.sort(this.mao);
        System.out.printf("Nome: %s\n", this.nome);
        System.out.printf("Pontos: %d\n", this.pontos);
        System.out.println("Cartas disponíveis:");
        for(int i=0; i<this.mao.size(); i++){
            System.out.printf("%d ", this.mao.get(i).getNumero());
        }
        System.out.println();
    }
}
