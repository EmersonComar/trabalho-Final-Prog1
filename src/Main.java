public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        // jogo.iniciarJogo();
        // for(int rodadas=1; rodadas<=1; rodadas++){
        //     System.out.printf("\t\t\t------ Rodada %d ------\n", rodadas);
        //     jogo.rodada();
        // }

        Carta carta1 = new Carta();
        Carta carta2 = new Carta(10);

        System.out.println(carta1.getPonto());

    }
}
