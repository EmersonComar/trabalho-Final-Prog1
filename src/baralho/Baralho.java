package baralho;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartas.Carta;

/**
 * A classe Baralho representa um baralho de cartas, contendo métodos para criar, embaralhar e distribuir cartas.
 */
public class Baralho {

    /** A lista de cartas no baralho. */
    private List<Carta> cartas;

    /**
     * Construtor que inicializa o baralho, cria as cartas, e as embaralha.
     */
    public Baralho() {
        this.cartas = new ArrayList<>();
        criarBaralho();
        embaralhar();
    }

    /**
     * Distribui uma quantidade específica de cartas do baralho.
     * @param quantidade A quantidade de cartas a ser distribuída.
     * @return Uma lista contendo as cartas distribuídas.
     * @throws IllegalArgumentException Se a quantidade de cartas solicitadas for maior do que a disponível no baralho.
     */
    public List<Carta> distribuirCartas(int quantidade) {
        if(quantidade > cartas.size()){
            throw new IllegalArgumentException("Quantidade de cartas insuficientes");
        }
        
        List<Carta> cartasDistribuidas = new ArrayList<>(cartas.subList(0, quantidade));
        cartas.subList(0, quantidade).clear();

        return cartasDistribuidas;
    }

    /**
     * Distribui uma única carta do baralho.
     * @return A carta distribuída.
     * @throws IllegalArgumentException Se o baralho estiver vazio.
     */
    public Carta distribuirUmaCarta(){
        if (cartas.isEmpty()){
            throw new IllegalArgumentException("O baralho está vazio");
        }

        return cartas.remove(0);
    }

    // Métodos auxiliares

    /**
     * Cria as 109 cartas no baralho.
     */
    private void criarBaralho() {
        for (int i = 1; i <= 109; i++) {
            cartas.add(new Carta(i));
        }
    }

    /**
     * Embaralha as cartas no baralho.
     */
    private void embaralhar() {
        Collections.shuffle(cartas);
    }
}
