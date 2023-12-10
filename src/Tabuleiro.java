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
            Carta maiorCarta = new Carta(0);
            boolean cartaMenorEncontrada = false;
            int indexDaLinha = 0;
            int diferenca = 110;

            for (int i=0; i<linhas.size(); i++){
                List<Carta> trilha = linhas.get(i);
                Carta ultimaCartaDaTrilha = trilha.get(trilha.size() - 1);

                if(jogada.compareTo(ultimaCartaDaTrilha) == 1){
                    int diferencaDasCartas = calculaDiferenca(jogada, ultimaCartaDaTrilha);
                    if(diferenca > diferencaDasCartas){
                        diferenca = diferencaDasCartas;
                        indexDaLinha = i;
                        cartaMenorEncontrada = true;
                    }
                }else{
                    if(!cartaMenorEncontrada && ultimaCartaDaTrilha.compareTo(maiorCarta) == 1){
                        maiorCarta = ultimaCartaDaTrilha;
                        indexDaLinha = i;
                    }
                }
            }

            if(cartaMenorEncontrada){
                List<Carta> trilha = linhas.get(indexDaLinha);
                if(trilha.size() == 5){
                    jogador.setPontos(jogador.getPontos() + somarPontuacao(trilha));
                    linhas.get(indexDaLinha).clear();
                    linhas.get(indexDaLinha).add(jogada);
                }else{
                    linhas.get(indexDaLinha).add(jogada);
                }
            }else{
                List<Carta> trilha = linhas.get(indexDaLinha);
                jogador.setPontos(jogador.getPontos() + somarPontuacao(trilha));
                linhas.get(indexDaLinha).clear();
                linhas.get(indexDaLinha).add(jogada);
            }
        }
    }

    // Métodos auxiliares

    private int calculaDiferenca(Carta jogada, Carta ultimaCartaDaTrilha){
        return jogada.getNumero() - ultimaCartaDaTrilha.getNumero();
    }

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
