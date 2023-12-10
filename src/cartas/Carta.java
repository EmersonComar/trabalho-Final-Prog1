package cartas;
/**
 * A classe Carta representa uma carta de um baralho, com um número associado e uma pontuação.
 * As cartas são comparáveis com base em seus números.
 */
public class Carta implements Comparable<Carta> {
    
    /** O número da carta. */
    private int numero;
    
    /** A pontuação associada à carta. */
    private int ponto = 1;

    /**
     * Construtor padrão que cria uma carta sem número definido.
     */
    public Carta(){
    }

    /**
     * Construtor que cria uma carta com um número específico e calcula automaticamente a pontuação.
     * @param numero O número associado à carta.
     */
    public Carta(int numero) {
        this.numero = numero;
        calculaPontuacao();
    }

    /**
     * Obtém o número da carta.
     * @return O número da carta.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Obtém a pontuação associada à carta.
     * @return A pontuação da carta.
     */
    public int getPonto() {
        return ponto;
    }

    /**
     * Compara esta carta com outra com base em seus números.
     * @param outraCarta A outra carta a ser comparada.
     * @return Um valor negativo, zero ou um valor positivo se esta carta for menor, igual ou maior que a outra.
     */
    @Override
    public int compareTo(Carta outraCarta) {
        return Integer.compare(this.numero, outraCarta.numero);
    }

    /**
     * Calcula a pontuação da carta com base em algumas regras específicas.
     * - Se o último dígito do número for '5', adiciona 1 à pontuação.
     * - Se o último dígito do número for '0', adiciona 2 à pontuação.
     * - Se o número for múltiplo de 11, adiciona 4 à pontuação.
     */
    private void calculaPontuacao(){

        char unidade = String.valueOf(numero).charAt(String.valueOf(numero).length() - 1);
        if(unidade == '5'){
            this.ponto += 1;
        } else {
            if(unidade == '0'){
                this.ponto += 2;
            }
        }

        for(int i=1; i<=9; i++){
            if(numero == (11*i)){
                this.ponto += 4;
                break;
            }
        }
    }
}
