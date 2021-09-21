package lists;

import java.util.LinkedList;

public class ExemploLinkedList {

    public static void main(String[] args) {

        // Instanciando uma LinkedList
        LinkedList<Double> notas = new LinkedList<>();

        /*
        O LinkedList implementa uma lista duplamente ligada, ou seja, sua diferença entre a List é na performace entre
        os métodos add(), remove(), get() e set().
         */

        // O método add(elemento) adiciona um elemento a lista.
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);

        // O método addFirst(elemento) adiciona um elemento no começo da lista, quando o addLast(elemento) adiciona um
        // elemento ao final da lista.
        notas.addFirst(7d);
        notas.addLast(3d);

        System.out.println(notas);

        // O método get(indice) retorna um elemento com o indice indicado no parâmetro.
        System.out.println("Elemento da posição 2: " + notas.get(2));

        // Estes dois métodos retorna o primeiro e o último elemento, respectivamente
        System.out.println("O primeiro elemento: " + notas.getFirst());
        System.out.println("O último elemento: " + notas.getLast());

        // Para mudar um determinado elemento usamos o método set() que recebe como parâmetro um índice e um elemento
        notas.set(5, 10d);

        // Para remover algum elemento da lista temos o método remove(), pode-se usar tanto com o indice,
        // quanto com o próprio elemento.
        // Quando removemos utilizando como parâmetro o objeto o seu retorno será um boolean, dizendo se o elemento foi
        // removido(true) ou não(false).
        boolean removido = notas.remove(7d);
        System.out.println("Elemento foi removido? " + removido);
        System.out.println(notas);

        // Agora se removemos utilizando como parâmetro o índice, seu retorno será o elemento removido.
        Double removido2 = notas.remove(5);
        System.out.println("Elemento removido: " + removido2);
        System.out.println(notas);

        // Com o LinkedList temos os métodos removeFirst() e removeLast(), que remove o primeiro e o último elemento da
        // lista, respectivamente. Este método também retorna o elemento removido.
        Double removePrimeiro = notas.removeFirst();
        Double removeUltimo = notas.removeLast();

        System.out.println(removePrimeiro);
        System.out.println(removeUltimo);

        System.out.println(notas);

        // Adicionar mais métodos
    }
}
