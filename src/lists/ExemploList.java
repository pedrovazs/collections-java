package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExemploList {

    public static void main(String[] args) {

        List<Double> notas = new ArrayList<>();

        // o método add(elemento) adiciona um elemento a lista.
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3d);

        System.out.println(notas);

        // Para sabermos o index de algum elemento usamos o método indexOf(elemento).
        var nota = notas.indexOf(9.3);
        System.out.println("O index é: " + nota);

        // Podemos substituir um elemento de uma lista também, para isso usamos o set(index, elemento).
        notas.set(4, 10d);
        System.out.println("Nota foi substituída: " + notas);

        // Para vermos se um determinado elemento está dentro de uma lista usamos o método contains(elemento).
        System.out.println("A nota 5.0 está dentro da lista? " + notas.contains(5d));

    }
}
