package lists;

import java.util.*;

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

        // Agora se quisermos buscar um elemento pelo seu indice, temos o método get(indice).
        System.out.println("A nota que está com o índice 3 é: " + notas.get(3));

        // Para sabermos o menor valor de uma lista ou o maior valor utilizamos o método max(lista) e min(lista)
        // da classe Collections.
        System.out.println("A menor nota é: " + Collections.min(notas));
        System.out.println("A maior nota é: " + Collections.max(notas));

        // Se quisermos somar os elementos de uma lista, vamos precisar do método iterator(), pois as listas não
        // tem um método nativo para somar os elementos.

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;

        while(iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }

        System.out.println("A soma é: " + soma);

        // Para mostrar o tamanho de uma lista usamos o método size().
        System.out.println("Tamanho da lista: " + notas.size());

        // Para remover algum elemento da lista temos o método remove(), pode-se usar tanto com o indice,
        // quanto com o próprio elemento.
        // Quando removemos utilizando como parâmetro o objeto o seu retorno será um boolean, dizendo se o elemento foi
        // removido(true) ou não(false).
        var removido = notas.remove(7d);
        System.out.println("Elemento foi removido? " + removido);
        System.out.println(notas);

        // Agora se removemos utilizando como parâmetro o índice, seu retorno será o elemento removido.
        var removido2 = notas.remove(5);
        System.out.println("Elemento removido: " + removido2);
        System.out.println(notas);

        // Para apagar todos os elementos da lista, usamos o método clear().
        notas.clear();

        // Agora se quisermos ver se determinada lista está vazia ou não, utilizamos o método isEmpty().
        System.out.println(notas.isEmpty());

    }
}
