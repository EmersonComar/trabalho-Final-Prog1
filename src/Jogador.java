import java.util.List;
import java.util.ArrayList;

public class Jogador {
    private String nome;
    private List<Carta> mao = new ArrayList<>();
    private int pontos;

    public Jogador(String nome, List<Carta> cartas) {
        this.nome = nome;
        this.mao = cartas;
        this.pontos = 0;
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

    public void exibirMao(){
        System.out.printf("Nome: %s\n", this.nome);
        System.out.println("Cartas disponíveis:");
        for(int i=0; i<this.mao.size(); i++){
            System.out.printf("%d ", this.mao.get(i).getNumero());
        }
        System.out.println();
    }
}
