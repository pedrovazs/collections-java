package sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExemploSet {

    public static void main(String[] args) {

        // Inicializando o set.
        Set<Double> notas = new HashSet<>();

        // Outra forma de inicializar um set (Essas não são as únicas formas de se inicializar).
        // HashSet<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));

        /* Método add adiciona elementos ao set.
         Lembrando que o set não permite elementos repetidos dentro dela, ignorando o segundo '7d'.*/
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
//        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);

        // Os ‘sets’ não têm indices e também não é ordenada, ou seja, a ordem de inserção dos elementos não é
        // respeitada.
        System.out.println(notas);


    }
}
