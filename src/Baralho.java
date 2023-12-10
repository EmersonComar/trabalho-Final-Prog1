import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();
        criarBaralho();
        embaralhar();
    }

    public List<Carta> distribuirCartas(int quantidade) {
        if(quantidade > cartas.size()){
            throw new IllegalArgumentException("Quantidade de cartas insuficientes");
        }
        
        List<Carta> cartasDistribuidas = new ArrayList<>(cartas.subList(0, quantidade));
        cartas.subList(0, quantidade).clear();

        return cartasDistribuidas;
    }

    public Carta distribuirUmaCarta(){
        if (cartas.isEmpty()){
            throw new IllegalArgumentException("O baralho está vazio");
        }

        return cartas.remove(0);
    }

    // Métodos auxiliares

    private void criarBaralho() {
        for (int i = 1; i <= 109; i++) {
            cartas.add(new Carta(i));
        }
    }

    private void embaralhar() {
        Collections.shuffle(cartas);
    }
}
