import java.util.Arrays;
import java.util.stream.IntStream;

public class BuscaEmProfundidade {

    private Grafo grafo;

    public BuscaEmProfundidade(Grafo grafo) {this.grafo = grafo;}

    public int encontrarCaminhoMaisLongo() {
        int[] dp = new int[grafo.getNumVertices()];
        Arrays.fill(dp, -1);

        return IntStream.range(0, grafo.getNumVertices())
                        .map(i -> buscaEmProfundidade(this.grafo, i, dp))
                        .max()
                        .orElse(0);
    }

    private int buscaEmProfundidade(Grafo grafo, int v, int[] dp) {
        if (dp[v] != -1) return dp[v];

        int comprimentoMax = 1;
        comprimentoMax = 1 + grafo.adjacentes(v).stream()
                                  .mapToInt(vizinho -> buscaEmProfundidade(grafo, vizinho, dp))
                                  .max()
                                  .orElse(0);

        dp[v] = comprimentoMax;
        return comprimentoMax;
    }
    
}
