import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leitura {

    private final String arquivo;
    private Digrafo digrafo;
    private int caminhoMaximo;

    public Leitura (String arquivo) {this.arquivo = arquivo;}

    private void lerCaminhoMaximo() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            digrafo = new Digrafo(Integer.parseInt(br.readLine()));

            AtomicInteger id = new AtomicInteger(0);
            List<Caixa> caixas = br.lines()
                    .map(linhas -> new Caixa(id.getAndIncrement(), Arrays.stream(linhas.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray()))
                    .collect(Collectors.toList());

            br.close();
            
            Collections.sort(caixas);

            IntStream.range(0, caixas.size()).forEach(i ->
            IntStream.range(i + 1, caixas.size()).forEach(j -> {
                if (caixas.get(i).cabeDentro(caixas.get(j))) 
                digrafo.adicionarAresta(caixas.get(i).getId(), caixas.get(j).getId());}));

            caminhoMaximo = new BuscaEmProfundidade(digrafo).encontrarCaminhoMaisLongo();

        } catch(Exception e) {}
    }

    @Override
    public String toString() {
        lerCaminhoMaximo();
        return "Caminho mais longo para " + NumberFormat.getNumberInstance(Locale.of("pt", "BR")).
        format(Integer.parseInt(arquivo.split("_")[1].split(Pattern.quote("."))[0])) + " caixas: " + caminhoMaximo;
    }

}
