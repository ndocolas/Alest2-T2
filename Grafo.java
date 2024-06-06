import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Grafo {
    private int nVertices;
    private ArrayList<Integer>[] listaAdjacencia;

    @SuppressWarnings("unchecked")
    public Grafo(int nVertices) {
        this.nVertices = nVertices;
        listaAdjacencia = new ArrayList[nVertices];
        IntStream.range(0, nVertices).forEach(i -> listaAdjacencia[i] = new ArrayList<>());
    }

    public void adicionarAresta(int v, int w) {listaAdjacencia[v].add(w);}
    public List<Integer> adjacentes(int v) {return listaAdjacencia[v];}
    public int getNumVertices() {return nVertices;}
}
