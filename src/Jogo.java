import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private List<Jogador> jogadores;
    private Baralho baralho;
    private Tabuleiro tabuleiro;

    public void iniciarJogo() {
        // Solicitar ao usuário o número de jogadores
        int numeroDeJogadores = solicitarNumeroJogadores();

        // Verificar se o número de jogadores está dentro da faixa permitida
        if (numeroDeJogadores < 3 || numeroDeJogadores > 6) {
            System.out.println("Número de jogadores inválido. O jogo suporta de 3 a 6 jogadores.");
            return;
        }

        // Criar e inicializar jogadores
        jogadores = new ArrayList<>();
        for (int i = 1; i <= numeroDeJogadores; i++) {
            String nomeJogador = solicitarNomeJogador(i);
            Jogador jogador = new Jogador(nomeJogador);
            jogadores.add(jogador);
        }

        // Inicializar baralho e tabuleiro
        baralho = new Baralho();
        tabuleiro = new Tabuleiro();

        // Outras inicializações do jogo
    }

    private int solicitarNumeroJogadores() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de jogadores (entre 3 e 6): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite novamente: ");
            scanner.next();  // Consumir entrada inválida
        }

        return scanner.nextInt();
    }

    private String solicitarNomeJogador(int numeroJogador) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do Jogador " + numeroJogador + ": ");
        return scanner.nextLine();
    }

    // Implementar métodos adicionais conforme necessário
}
