public class Carta implements Comparable<Carta> {
    private int numero;

    public Carta(){
    }
    
    public Carta(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int compareTo(Carta outraCarta) {
        return Integer.compare(this.numero, outraCarta.numero);
    }
}
