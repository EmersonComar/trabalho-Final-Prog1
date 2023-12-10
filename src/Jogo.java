import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private List<Jogador> jogadores;
    private Baralho baralho;
    private Tabuleiro tabuleiro;

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

    private void ordenarJogadores(String  metodo){
        if (metodo == "numero"){
            Collections.sort(jogadores, Comparator.comparingInt(jogador -> jogador.getJogada().getNumero()));
        }else if (metodo == "valor"){
            Collections.sort(jogadores, Comparator.comparingInt(jogador -> jogador.getPontos()));
        }
    }

    private void exibeOrdem(List<Jogador> jogadores){
        System.out.println("Ordem de jogada: ");
        for(Jogador jogador: jogadores){
            System.out.printf("%d ", jogador.getJogada().getNumero());
        }
        System.out.println();
    }

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

    private boolean validarEntrada(int escolha, Jogador jogador) {
        for (Carta carta : jogador.getMao()) {
            if (carta.compareTo(new Carta(escolha)) == 0) {
                return true;
            }
        }
        return false;
    }

    private int solicitarNumeroJogadores() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o número de jogadores (entre 3 e 6): ");
        while (!scan.hasNextInt()) {
            System.out.print("Entrada inválida.\nDigite novamente o número de jogadores (entre 3 e 6): ");
            scan.next(); 
        }

        return scan.nextInt();
    }

    private String solicitarNomeJogador(int numeroJogador) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome do Jogador " + numeroJogador + ": ");
        return scan.nextLine();
    }

}
