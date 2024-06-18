public class App {

    public static void main(String[] args) {
        String dir = "./arquivos/";
        String[] ler = {
            dir + "caixas_5" + ".txt",
            dir + "caixas_11" + ".txt",
            dir + "caixas_12" + ".txt",
            dir + "caixas_15" + ".txt",
            dir + "tamanho_10" + ".txt",
            dir + "tamanho_20" + ".txt",
            dir + "tamanho_50" + ".txt",
            dir + "tamanho_100" + ".txt",
            dir + "tamanho_200" + ".txt",
            dir + "tamanho_300" + ".txt",
            dir + "tamanho_1000" + ".txt",
            dir + "caixas_1005" + ".txt",
            dir + "tamanho_2000" + ".txt",
            dir + "tamanho_10000" + ".txt"
        };

        for (String str : ler) {
            System.out.println(new Leitura(str));
        }
    }
    
}
