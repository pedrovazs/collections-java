package sets;

import java.util.*;

public class ExemploSet {

    public static void main(String[] args) {

        // Inicializando o set.
        // Set<Double> notas = new HashSet<>();

        // Outra forma de inicializar um set (Essas não são as únicas formas de se inicializar).
        // HashSet<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));

        /*
        Método add adiciona elementos ao set.
         Lembrando que o set não permite elementos repetidos dentro dela, ignorando o segundo '7d'.

        notas.add(7d);
        notas.add(8.5);
        */

        // Pode-se também adicionar elementos direto na inicialização do set.
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));

        /*
        Os ‘sets’ não têm indices e também não é ordenada, ou seja, a ordem de inserção dos elementos não é
        respeitada. Assim, os métodos indexOf(), set(), get() e outros que dependem de um indice não existem dentro
        do Set.
        */
        System.out.println(notas);

        // Para conferir se algum elemento existe em um determinado set, utilizamos o método contains(elemento).
        System.out.println("A nota 5 está no conjunto: " + notas.contains(5d));

        /*
        Para exibir o maior elemento ou o menor elemento, usamos o método da classe Collections, max(conjunto) e
        min(conjunto).
        */
        System.out.println("Maior nota: " + Collections.max(notas));
        System.out.println("Menor nota: " + Collections.min(notas));

        /*
        Se quisermos somar todos os valores dentro de um conjunto, podemos utilizar o iterator.
        */
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;

        while(iterator.hasNext()) {
            soma += iterator.next();
        }

        System.out.println("A soma é: " + soma);

        // Agora se quisermos a média podemos usar o método size(), que mostra o tamanho do conjunto.
        System.out.println("A média é: " + soma / notas.size());

        // Para removermos algum elemento dentro do conjunto usamos o remove(elemento).
        // Este método não pode ser utilizado para remover de acordo com o índice
        boolean remove = notas.remove(3.6);

        // Este método nos retorna um boolean nos dizendo se o elemento foi removido ou não.
        System.out.println("A nota foi removida: " + remove);
        System.out.println(notas);

        // Para remover todos os elementos do conjunto, temos o método clear().
        notas.clear();
        System.out.println(notas);
    }
}
