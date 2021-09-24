package sets;

import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("-- \tOrdem Aleatória\t --");
        Set<SeriesFavoritas> minhasSeries = new HashSet<>(){{
            add(new SeriesFavoritas("got", "fantasia", 60));
            add(new SeriesFavoritas("dark", "drama", 60));
            add(new SeriesFavoritas("that '70s show", "comédia", 25));
        }};
        for (SeriesFavoritas serie : minhasSeries) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("-- \tOrdem de Inserção\t --");
        Set<SeriesFavoritas> minhasSeries2 = new LinkedHashSet<>(){{
            add(new SeriesFavoritas("got", "fantasia", 60));
            add(new SeriesFavoritas("dark", "drama", 60));
            add(new SeriesFavoritas("that '70s show", "comédia", 25));
        }};
        for (SeriesFavoritas serie : minhasSeries2) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("-- \tOrdem natural (Tempo de Episódio)\t --");
        // Se o elemento que for comparado forem, iguais um será deletado, então no método compare terá que ter um
        // critério de desempate.
        Set<SeriesFavoritas> minhasSeries3 = new TreeSet<>(){{
            add(new SeriesFavoritas("got", "fantasia", 60));
            add(new SeriesFavoritas("dark", "drama", 60));
            add(new SeriesFavoritas("that '70s show", "comédia", 25));
        }};
        for (SeriesFavoritas serie : minhasSeries3) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("-- \tOrdem Nome/Gênero/Tempo de Episódio\t --");
        Set<SeriesFavoritas> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroTempo());
        minhasSeries4.addAll(minhasSeries);
        for (SeriesFavoritas serie : minhasSeries4) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
    }

}
class SeriesFavoritas implements Comparable<SeriesFavoritas>{

    private String nome;
    private String genero;
    private Integer tempoEpisodio;
    public SeriesFavoritas(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "SeriesFavoritas{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesFavoritas that = (SeriesFavoritas) o;
        return nome.equals(that.nome) && genero.equals(that.genero) && tempoEpisodio.equals(that.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(SeriesFavoritas series) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), series.getTempoEpisodio());
        if (tempoEpisodio != 0) return tempoEpisodio;
        return this.getGenero().compareTo(series.getGenero());
    }

}

class ComparatorNomeGeneroTempo implements Comparator<SeriesFavoritas> {

    @Override
    public int compare(SeriesFavoritas s1, SeriesFavoritas s2) {

        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return  Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}
