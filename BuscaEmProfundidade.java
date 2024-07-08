import java.util.Arrays;
import java.util.stream.IntStream;

public class BuscaEmProfundidade {

    private final Digrafo digrafo;

    public BuscaEmProfundidade(Digrafo digrafo) {this.digrafo = digrafo;}

    public int encontrarCaminhoMaisLongo() {
        int[] lista = new int[digrafo.getNumVertices()];
        Arrays.fill(lista, -1);

        return IntStream.range(0, digrafo.getNumVertices())
                        .map(i -> buscaEmProfundidade(this.digrafo, i, lista))
                        .max()
                        .orElse(0);
    }

    private int buscaEmProfundidade(Digrafo digrafo, int v, int[] lista) {
        if (lista[v] != -1) return lista[v];

        lista[v] = 1 + digrafo.adjacentes(v).stream()
                                  .mapToInt(vizinho -> buscaEmProfundidade(digrafo, vizinho, lista))
                                  .max()
                                  .orElse(0);
        return lista[v];
    }
}