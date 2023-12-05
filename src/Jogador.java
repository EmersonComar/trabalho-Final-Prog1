import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Jogador{
    private String nome;
    private List<Carta> mao = new ArrayList<>();
    private Carta jogada;
    private int pontos;

    public Jogador(String nome, List<Carta> cartas) {
        this.nome = nome;
        this.mao = cartas;
        this.pontos = 0;
    }

    public Carta getJogada() {
        return jogada;
    }

    public void setJogada(Carta jogada) {
        this.jogada = jogada;
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void removerCartaDaMao(Carta carta){
        for(int i=0; i<this.mao.size(); i++){
            Carta cartaDaMao = this.mao.get(i);
            if(carta.compareTo(cartaDaMao) == 0){
                this.mao.remove(i);
                System.out.printf("Carta %d removida com sucesso", cartaDaMao.getNumero());
            }
        }
    }

    public void exibirMao(){
        Collections.sort(this.mao);
        System.out.printf("Nome: %s\n", this.nome);
        System.out.printf("Pontos: %d\n", this.pontos);
        System.out.println("Cartas disponíveis:");
        for(int i=0; i<this.mao.size(); i++){
            System.out.printf("%d ", this.mao.get(i).getNumero());
        }
        System.out.println();
    }
}
