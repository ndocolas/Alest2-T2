public record Caixa (int id, int[] dimensoes) implements Comparable<Caixa> {
    @Override public int compareTo(Caixa outra) {return java.util.Arrays.compare(this.dimensoes, outra.dimensoes());}
    public boolean cabeDentro(Caixa outra) {return java.util.stream.IntStream.range(0, 3).allMatch(i -> this.dimensoes[i] < outra.dimensoes[i]);}
}