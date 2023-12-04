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

    private void criarBaralho() {
        for (int i = 1; i <= 109; i++) {
            cartas.add(new Carta(i));
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public List<Carta> distribuirCartas(int quantidade) {
        
        List<Carta> cartasDistribuidas = new ArrayList<>(cartas.subList(0, quantidade));
        cartas.subList(0, quantidade).clear();

        return cartasDistribuidas;
    }

    public Carta distribuirUmaCarta(){
        Carta carta = new Carta(this.cartas.get(0).getNumero());
        this.cartas.remove(0);
        return carta;
    }
}
