import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leitura {

    private final String arquivo;
    private Digrafo digrafo;

    public Leitura (String arquivo) {
        this.arquivo = arquivo;
        try (BufferedReader br = new BufferedReader(new FileReader(this.arquivo))) {
            digrafo = new Digrafo(Integer.parseInt(br.readLine()));

            AtomicInteger id = new AtomicInteger(0);
            List<Caixa> caixas = br.lines()
                    .map(linhas -> new Caixa(id.getAndIncrement(), Arrays.stream(linhas.split(" ")).mapToInt(Integer::parseInt).sorted().toArray()))
                    .collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());

            IntStream.range(0, caixas.size()).boxed()
                .flatMap(i -> IntStream.range(i + 1, caixas.size())
                .filter(j -> caixas.get(i).cabeDentro(caixas.get(j)))
                .mapToObj(j -> new int[]{i, j}))
                .forEach(pair -> digrafo.adicionarAresta(caixas.get(pair[0]).getId(), caixas.get(pair[1]).getId()));
        } catch(Exception _) {}
    }

    @Override
    public String toString() {
        return String.format("Caminho mais longo para %s caixas: %d", NumberFormat.getNumberInstance(Locale.of("pt", "BR")).
        format(Integer.parseInt(arquivo.split("_")[1].split(Pattern.quote("."))[0])), new BuscaEmProfundidade(digrafo).encontrarCaminhoMaisLongo());
    }
}
