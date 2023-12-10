/**
 * A classe Main é a classe principal que contém o método main para iniciar o jogo.
 */
public class Main {

    /**
     * O método principal que inicia o jogo, executa as rodadas e exibe os vencedores.
     * @param args Os argumentos da linha de comando (não utilizados neste contexto).
     */
    public static void main(String[] args) {
        // Cria uma instância do jogo
        Jogo jogo = new Jogo();

        // Inicia o jogo e verifica se foi inicializado com sucesso
        if (jogo.iniciarJogo()){
            // Executa 12 rodadas do jogo
            for(int rodadas = 1; rodadas <= 12; rodadas++){
                System.out.printf("\t\t\t---- Rodada %d ----\n\n", rodadas);
                jogo.rodada();
            }

            // Exibe os vencedores após as 12 rodadas
            jogo.exibirVencedores();
        }
    }
}
