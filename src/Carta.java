public class Carta implements Comparable<Carta> {
    private int numero;
    private int ponto = 1;

    public Carta(){
    }

    public Carta(int numero) {
        this.numero = numero;
        calculaPontuacao();
    }

    public int getNumero() {
        return numero;
    }

    public int getPonto() {
        return ponto;
    }

    @Override
    public int compareTo(Carta outraCarta) {
        return Integer.compare(this.numero, outraCarta.numero);
    }

    private void calculaPontuacao(){

        char unidade = String.valueOf(numero).charAt(String.valueOf(numero).length() - 1);
        if(unidade == '5'){
            this.ponto += 1;
        }else{
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
