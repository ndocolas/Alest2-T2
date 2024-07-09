public class App {
    public static void main(String[] args) {
        java.util.Arrays.asList(
                "caixas_5",
                "caixas_11",
                "caixas_12",
                "caixas_15",
                "tamanho_10",
                "tamanho_20",
                "tamanho_50",
                "tamanho_100",
                "tamanho_200",
                "tamanho_300",
                "tamanho_1000",
                "caixas_1005",
                "tamanho_2000",
                "tamanho_10000")
		        .stream().map(str -> "./arquivos/" + str + ".txt")
                .forEach(arq -> System.out.println(new Leitura(arq)));
    }
}