public class App {

    public static void main(String[] args) {
        String dir = "./arquivos/";
        System.out.println(new Leitura(dir + "tamanho_10.txt"));
        System.out.println(new Leitura(dir + "tamanho_50.txt"));
        System.out.println(new Leitura(dir + "tamanho_100.txt"));
        System.out.println(new Leitura(dir + "tamanho_798.txt"));
        System.out.println(new Leitura(dir + "tamanho_1000.txt"));
        System.out.println(new Leitura(dir + "tamanho_5000.txt"));
        System.out.println(new Leitura(dir + "tamanho_10000.txt"));
    }
}
