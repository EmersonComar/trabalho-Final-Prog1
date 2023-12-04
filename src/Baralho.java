import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();
        criarBaralho();
    }

    private void criarBaralho() {
        for (int i = 1; i <= 109; i++) {
            cartas.add(new Carta(i));
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public List<Carta> distribuirCartas(int quantidade) {
        if (quantidade > cartas.size()) {
            throw new IllegalArgumentException("Quantidade de cartas a serem distribuídas maior que o número de cartas no baralho.");
        }

        List<Carta> cartasDistribuidas = new ArrayList<>(cartas.subList(0, quantidade));
        cartas.subList(0, quantidade).clear();

        return cartasDistribuidas;
    }
}
