import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Leitura {

    private String arquivo;
    private Grafo grafo;

    public Leitura (String arquivo) {this.arquivo = arquivo;}

    private void lerCaminhoMaximo() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha;
            int id = 0;

            List<Caixa> caixas = new ArrayList<>();

            grafo = new Grafo(Integer.parseInt(br.readLine()));

            while((linha = br.readLine()) != null) {
            caixas.add(new Caixa(id++, Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray()));
            }

            br.close();
            
            Collections.sort(caixas);

            IntStream.range(0, caixas.size()).forEach(i ->
            IntStream.range(i + 1, caixas.size()).forEach(j -> {
                if (caixas.get(i).cabeDentro(caixas.get(j))) 
                grafo.adicionarAresta(caixas.get(i).getId(), caixas.get(j).getId());}));
        } catch(Exception e) {}
    }

    public int getCaminhoMaximo() {lerCaminhoMaximo();return new BuscaEmProfundidade(grafo).encontrarCaminhoMaisLongo();}

    public long getTempo() {
        long startTime = System.currentTimeMillis();
        getCaminhoMaximo();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    @Override
    public String toString() {return "Caminho mais longo para " + arquivo.split("_")[1].split(Pattern.quote("."))[0] + " caixas: " +getCaminhoMaximo() + "\nTempo: " + getTempo() + " ms";}

}
