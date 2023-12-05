import java.util.ArrayList;
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

    public void atualizaTabuleiro(List<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            Carta jogada = jogador.getJogada();
            int index = 0;
            int diferenca = 110;


            for (int i = 0; i < this.linhas.size(); i++) {
                List<Carta> linha = this.linhas.get(i);
                Carta ultimaCartadaLinha = linha.get(linha.size() - 1);
        
                if((jogada.compareTo(ultimaCartadaLinha)) == 1){

                    if(linha.size() == 5){
                        jogador.setPontos(jogador.getPontos() + somarPontuacao(linha));
                        this.linhas.get(i).clear();
                        diferenca = 1;
                        index = 0;
                    }

                    if((jogada.getNumero() - ultimaCartadaLinha.getNumero()) < diferenca){
                        diferenca = (jogada.getNumero() - ultimaCartadaLinha.getNumero());
                        index = i;
                    }
                }
            }
            this.linhas.get(index).add(jogada);
        }
    }

    // Métodos auxiliares

    private void inicializarLinhas(Baralho baralho, int qtdLinhas) {
        for(int i=0; i<qtdLinhas; i++){
            List<Carta> trilha = new ArrayList<>();
            trilha.add(baralho.distribuirUmaCarta());
            linhas.add(trilha);
        }
    }

    private int somarPontuacao(List<Carta> linha){
        int pontos = 0;
        for(Carta carta: linha){
            pontos += carta.getPonto();
        }
        return pontos;
    }
}
