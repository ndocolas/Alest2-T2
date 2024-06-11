import java.util.Arrays;
import java.util.stream.IntStream;

public class BuscaEmProfundidade {

    private final Grafo grafo;

    public BuscaEmProfundidade(Grafo grafo) {this.grafo = grafo;}

    public int encontrarCaminhoMaisLongo() {
        int[] lista = new int[grafo.getNumVertices()];
        Arrays.fill(lista, -1);

        return IntStream.range(0, grafo.getNumVertices())
                        .map(i -> buscaEmProfundidade(this.grafo, i, lista))
                        .max()
                        .orElse(0);
    }

    private int buscaEmProfundidade(Grafo grafo, int v, int[] lista) {
        if (lista[v] != -1) return lista[v];

        int comprimentoMax;
        comprimentoMax = 1 + grafo.adjacentes(v).stream()
                                  .mapToInt(vizinho -> buscaEmProfundidade(grafo, vizinho, lista))
                                  .max()
                                  .orElse(0);

        lista[v] = comprimentoMax;
        return comprimentoMax;
    }
    
}
