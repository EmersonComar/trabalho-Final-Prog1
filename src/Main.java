public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        if (jogo.iniciarJogo()){
            for(int rodadas=1; rodadas<=12; rodadas++){
                System.out.printf("\t\t\t---- Rodada %d ----\n\n", rodadas);
                jogo.rodada();
            }
            jogo.exibirVencedores();
        }
    }
}
