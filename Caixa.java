import java.util.Arrays;
import java.util.stream.IntStream;

public class Caixa implements Comparable<Caixa> {
    
    private final int id;
    private final int[] dimensoes;

    public Caixa(int id, int[] dimensoes) {
        this.id = id;
        this.dimensoes = dimensoes;
    }

    @Override
    public int compareTo(Caixa outra) {return Arrays.compare(this.dimensoes, outra.dimensoes);}
    public boolean cabeDentro(Caixa outra) {return IntStream.range(0, 3).allMatch(i -> this.dimensoes[i] < outra.dimensoes[i]);}
    public int getId() {return id;}
}