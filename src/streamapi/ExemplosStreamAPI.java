package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExemplosStreamAPI {
    public static void main(String[] args) {

        List<String> numerosAleatorios = Arrays.asList("1","0", "1", "4", "7", "6", "8", "2");

        System.out.println("Imprimir todos os elementos da lista: ");
        numerosAleatorios.stream()
                .forEach(System.out::println);

        System.out.println("Pegar os 5 primeiros números e colocar dentro de um set: ");
        Set<String> collectSet = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());
        System.out.println(collectSet);

        System.out.println("Transformar a lista em uma lista de inteiros: ");
        List<Integer> collectInt = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(collectInt);

        System.out.println("Pegar números pares e maiores que dois e colocar em uma lista: ");
        List<Integer> collectPares = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList());
        System.out.println(collectPares);

        System.out.println("Mostrar a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remover os números ímpares da lista: ");
        collectInt.removeIf(integer -> integer % 2 == 1);
        System.out.println(collectInt);
    }
}
