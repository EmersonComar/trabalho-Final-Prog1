import java.util.List;
import java.util.ArrayList;

public class Jogador {
    private String nome;
    private List<Carta> mao;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
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

    // Implementar métodos adicionais conforme necessário
}
