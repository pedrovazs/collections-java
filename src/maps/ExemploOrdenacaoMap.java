package maps;

import java.util.*;

public class ExemploOrdenacaoMap {

    public static void main(String[] args) {

        System.out.println("--\tOrdem Aleatória\t--");

        // O HashMap já faz uma ordem aleatória dos elementos
        Map<String, Livro>  meusLivros = new HashMap<>() {{
           put("Hawkings, Stephen", new Livro("Uma Breve História do Tempo", 256));
           put("Duhigg, Charles", new Livro("O Poder Do Hábito", 408));
           put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros.entrySet()){
            System.out.println(livro.getKey() +  " - " + livro.getValue().getNome());
        }

        System.out.println("==\tOrdem de Inserção\t--");

        // Para mantermos a ordem de inserção usamos o LinkedHashMap
        Map<String, Livro>  meusLivros2 = new LinkedHashMap<>() {{
            put("Hawkings, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder Do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros2.entrySet()){
            System.out.println(livro.getKey() +  " - " + livro.getValue().getNome());
        }

        System.out.println("--\tOrdem Alfabética dos Autores");

        // O TreeMap já nos dará a ordem alfabética pela chave
        Map<String, Livro>  meusLivros3 = new TreeMap<>(meusLivros2);
        for(Map.Entry<String, Livro> livro : meusLivros3.entrySet()){
            System.out.println(livro.getKey() +  " - " + livro.getValue().getNome());
        }

        System.out.println("--\tOrdem Alfabética dos Livros\t--");

        // Para fazer isso precisamos de um comparator feito em baixo.
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros4){
            System.out.println(livro.getKey() +  " - " + livro.getValue().getNome());
        }

        System.out.println("--\tOrdem por páginas");

        //Assim como na ordem alfabética dos livros, para ordenar por páginas precisaremos de um comparator, logo abaixo
        Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorPaginas());
        meusLivros5.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros5){
            System.out.println(livro.getKey() +  " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
        }
    }
}

class Livro {

    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareTo(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return o1.getValue().getPaginas().compareTo(o2.getValue().getPaginas());
    }
}