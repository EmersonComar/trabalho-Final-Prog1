import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tabuleiro {
    private List<List<Carta>> linhas;

    public Tabuleiro(Baralho baralho, int qtdLinhas) {
        this.linhas = new ArrayList<>();
        inicializarLinhas(baralho, qtdLinhas);
    }

    public void exibirTabuleiro() {
        System.out.println("\t\t---------------Tabuleiro----------------");
        for(int i=0; i<this.linhas.size(); i++){
            System.out.printf("Linha %d\t\t|", i+1);
            for(int j=0; j<this.linhas.get(i).size(); j++){
                System.out.printf("%d\t", this.linhas.get(i).get(j).getNumero());
            }
            System.out.println();
        }
        System.out.printf("\t\t---------------------------------------\n");
    }

    public void atualizaTabuleiro(List<Jogador> jogadores){
        List<Carta> ultimasCartasDoTabuleiro = new ArrayList<>();

        for (List<Carta> linha : this.linhas) {
            if (!linha.isEmpty()) {
                ultimasCartasDoTabuleiro.add(linha.get(linha.size() - 1));
            }
        }
        ultimasCartasDoTabuleiro.sort(Collections.reverseOrder());

        

    }

    // Métodos auxiliares

    private void inicializarLinhas(Baralho baralho, int qtdLinhas) {
        for(int i=0; i<qtdLinhas; i++){
            List<Carta> trilha = new ArrayList<>();
            trilha.add(baralho.distribuirUmaCarta());
            linhas.add(trilha);
        }
    }
}
