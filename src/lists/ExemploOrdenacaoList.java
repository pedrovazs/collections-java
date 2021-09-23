package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {

    public static void main(String[] args) {

        Gato jon = new Gato("Jon", 18, "preto");
        Gato simba = new Gato("Simba", 6, "tigrado");
        Gato jon2 = new Gato("Jon", 12, "amarelo");

        List<Gato> listaGato = new ArrayList<>(){{
            add(jon);
            add(simba);
            add(jon2);
        }};

        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println(listaGato);

        System.out.println("--\tOrdem Aleatória\t--");

        // O método shuffle() da classe Collections bagunça a lista colocada como parâmetro.
        Collections.shuffle(listaGato);
        System.out.println(listaGato);

        System.out.println("--\tOrdem Nome\t--");
        // Para ordenar conforme o nome, primeiro a classe precisa implementar a interface Comparable feita logo a
        // baixo
        Collections.sort(listaGato);
        System.out.println(listaGato);

        System.out.println("--\tOrdem Idade\t--");
        // Para fazer a ordem pela idade a classe precisa implementar a interface Comparator feita logo a baixo
        //Collections.sort(listaGato, new ComparatorIdade());
        listaGato.sort(new ComparatorIdade());
        System.out.println(listaGato);

        System.out.println("--\tOrdem Cor\t--");
        // Da mesma forma que a ordenação por idade, a ordenação por cor precisa de uma classe que implementa
        // comparator, que está logo a baixo.
        listaGato.sort(new ComparatorCor());
        System.out.println(listaGato);

        System.out.println("--\tOrdem Nome/Idade/Cor\t--");
        listaGato.sort(new ComparatorNomeIdadeCor());
        System.out.println(listaGato);
    }
}

// Classe feita para demonstrar comparable
class Gato implements Comparable<Gato>{

    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {

        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

// Classe feita para demonstrar comparator
class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

// Classe feita para demonstrar comparator
class ComparatorCor implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

// Classe feita para demonstrar comparator
class ComparatorNomeIdadeCor implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {

        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) {
            return nome;
        }

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) {
            return cor;
        }

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}