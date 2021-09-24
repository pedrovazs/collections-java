package sets;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploLinkedSet {

    public static void main(String[] args) {

        /*
        Diferente do HashSet, o LinkedHashSet guarda a ordem de inserção
        */
        Set<Double> notas = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);

        /*
        O TreeSet tem as implementações de uma árvore binária. Deixando as inserções na ordem crescente
        */
        Set<Double> notas2 = new TreeSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas2);

    }
}
