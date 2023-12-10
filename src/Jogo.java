import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * A classe Jogo representa um jogo de cartas com jogadores, um baralho e um tabuleiro.
 */
public class Jogo {

    /** A lista de jogadores participando do jogo. */
    private List<Jogador> jogadores;

    /** O baralho utilizado no jogo. */
    private Baralho baralho;

    /** O tabuleiro do jogo. */
    private Tabuleiro tabuleiro;

    /**
     * Inicializa o jogo, criando o baralho, o tabuleiro e configurando o número de jogadores.
     * @return true se o jogo foi inicializado com sucesso, false se houve algum erro.
     */
    public boolean iniciarJogo() {
        // Inicializa o baralho e tabuleiro
        baralho = new Baralho();
        tabuleiro = new Tabuleiro(baralho, 5);

        // Solicitar os números de jogadores e verificar se está dentro da faixa permitida
        int numeroDeJogadores = solicitarNumeroJogadores();
        if (numeroDeJogadores < 3 || numeroDeJogadores > 6) {
            System.out.println("Número de jogadores inválido. O jogo suporta de 3 a 6 jogadores.");
            return false;
        }

        // Cria e inicializa os jogadores
        jogadores = new ArrayList<>();
        for (int i = 1; i <= numeroDeJogadores; i++) {
            String nomeJogador = solicitarNomeJogador(i);
            Jogador jogador = new Jogador(nomeJogador, baralho.distribuirCartas(12));
            jogadores.add(jogador);
        }

        return true;
    }

    /**
     * Executa uma rodada do jogo, exibindo o tabuleiro, as mãos dos jogadores, solicitando jogadas,
     * ordenando os jogadores e atualizando o tabuleiro.
     */
    public void rodada(){
        tabuleiro.exibirTabuleiro();
        for(Jogador jogador: jogadores){
            jogador.exibirMao();
            Carta jogada = solicitarJogada(jogador);
            jogador.setJogada(jogada);
            jogador.removerCartaDaMao(jogada);
            System.out.println("---");
        }

        ordenarJogadores("numero");
        exibeOrdem(jogadores);
        tabuleiro.atualizaTabuleiro(jogadores);        
    }

    /**
     * Exibe os vencedores do jogo, ordenando os jogadores pelo valor dos pontos.
     */
    public void exibirVencedores(){
        ordenarJogadores("valor");
        System.out.printf("\n\n\t\t\t------ Jogo finalizado ------\n\n");
        tabuleiro.exibirTabuleiro();
        System.out.println("Vencedores: ");
        int posicao = 1;
        int posicaoAnterior = 0;

        for (int i = 0; i < jogadores.size(); i++) {
            Jogador jogador = jogadores.get(i);

            if (i > 0 && jogador.getPontos() != jogadores.get(i - 1).getPontos()) {
                posicao = posicaoAnterior + 1;
            }
            System.out.printf("%dº %s - %d ponto(s)\n", posicao, jogador.getNome(), jogador.getPontos());
            posicaoAnterior = posicao;
        }
    }

    // Métodos auxiliares

    /**
     * Ordena os jogadores com base no número da carta jogada ou no valor dos pontos.
     * @param metodo O método de ordenação ("numero" ou "valor").
     */
    private void ordenarJogadores(String  metodo){
        if (metodo.equals("numero")){
            Collections.sort(jogadores, Comparator.comparingInt(jogador -> jogador.getJogada().getNumero()));
        } else if (metodo.equals("valor")){
            Collections.sort(jogadores, Comparator.comparingInt(jogador -> jogador.getPontos()));
        }
    }

    /**
     * Exibe a ordem de jogada dos jogadores com base no número da carta jogada.
     * @param jogadores A lista de jogadores.
     */
    private void exibeOrdem(List<Jogador> jogadores){
        System.out.println("Ordem de jogada: ");
        for(Jogador jogador: jogadores){
            System.out.printf("%d ", jogador.getJogada().getNumero());
        }
        System.out.println();
    }

    /**
     * Solicita ao jogador a escolha do número de uma carta da sua mão.
     * @param jogador O jogador que está fazendo a jogada.
     * @return A carta escolhida pelo jogador.
     */
    private Carta solicitarJogada(Jogador jogador) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Escolha o número da carta: ");

        while (true) {
            try {
                int escolha = scan.nextInt();

                if (validarEntrada(escolha, jogador)) {
                    return new Carta(escolha);
                } else {
                    System.out.println("---");
                    System.out.println("Valor incorreto. Escolha uma das cartas disponíveis: ");
                    System.out.println("---");
                    jogador.exibirMao();
                    System.out.print("Escolha o número da carta: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Digite novamente: ");
                scan.next();
            }
        }
    }

    /**
     * Valida se a escolha do jogador é uma das cartas disponíveis na sua mão.
     * @param escolha A escolha do jogador.
     * @param jogador O jogador que está fazendo a jogada.
     * @return true se a escolha for válida, false caso contrário.
     */
    private boolean validarEntrada(int escolha, Jogador jogador) {
        for (Carta carta : jogador.getMao()) {
            if (carta.compareTo(new Carta(escolha)) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Solicita ao jogador o número desejado de participantes no jogo.
     * @return O número de jogadores escolhido.
     */
    private int solicitarNumeroJogadores() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o número de jogadores (entre 3 e 6): ");
        while (!scan.hasNextInt()) {
            System.out.print("Entrada inválida.\nDigite novamente o número de jogadores (entre 3 e 6): ");
            scan.next(); 
        }

        return scan.nextInt();
    }

    /**
     * Solicita ao jogador o nome para identificar o jogador no jogo.
     * @param numeroJogador O número do jogador.
     * @return O nome do jogador.
     */
    private String solicitarNomeJogador(int numeroJogador) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome do Jogador " + numeroJogador + ": ");
        return scan.nextLine();
    }

}
