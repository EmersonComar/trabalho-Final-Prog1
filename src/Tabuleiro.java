import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private List<List<Carta>> linhas;

    public Tabuleiro(Baralho baralho, int qtdLinhas) {
        this.linhas = new ArrayList<>();
        inicializarLinhas(baralho, qtdLinhas);
    }

    private void inicializarLinhas(Baralho baralho, int qtdLinhas) {
        for(int i=0; i<qtdLinhas; i++){
            List<Carta> trilha = new ArrayList<>();
            trilha.add(baralho.distribuirUmaCarta());
            linhas.add(trilha);
        }
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

}
