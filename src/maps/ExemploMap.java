package maps;

import java.util.*;

public class ExemploMap {

    public static void main(String[] args) {

        // Inicializando o Map.
        Map<String, Double> carrosPopulares = new HashMap<>();

        // Para adicionar os elementos dentro do Map, usamos o put(chave, valor). O valor da chave é único, ou seja, não
        // pode ter repetições.
        // A chave será o modelo do carro e o valor será seu consumo (km/l)
        carrosPopulares.put("gol", 14.4);
        carrosPopulares.put("uno", 15.6);
        carrosPopulares.put("mobi", 16.1);
        carrosPopulares.put("hb20", 14.5);
        carrosPopulares.put("kwid", 15.6);

        System.out.println(carrosPopulares);

        // O método put() também pode ser utilizado para substituir o valor de uma chave.
        carrosPopulares.put("gol", 15.2);

        // O toString() retorna uma String do objeto.
        System.out.println(carrosPopulares.toString());

        // Se quisermos saber se há uma determinada chave dentro do Map, utilizamos o método containsKey(). O retorno
        // será um boolean.
        System.out.println("Existe o modelo Tuscon no Map: " + carrosPopulares.containsKey("Tucson"));

        // O método get retorna o valor de uma chave.
        System.out.println("Consumo do Uno: " + carrosPopulares.get("uno"));

        // Assim como o método containsKey(), o containsValue() retorna um boolean nos mostrando se há um determinado
        // valor dentro do Map.
        System.out.println("Existe o consumo 14.5: " + carrosPopulares.containsValue(14.5));

        // O método values() nos retorna uma Collection com os valores do Map.
        System.out.println("Valores: " + carrosPopulares.values());

        // Para exibirmos todas as chaves de um Map, utilizamos o keySet(), seu retorno será um set com as chaves
        // do Map.
        System.out.println("Modelos: " + carrosPopulares.keySet());

        /*
        Já que o método value nos retorna um Collection, então para vermos a soma, a média, valor máximo e mínimo,
        faremos assim.
        */
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;

        while (iterator.hasNext()) {
            soma += iterator.next();
        }

        System.out.println("Valor máximo: " + Collections.max(carrosPopulares.values()));
        System.out.println("Valor mínimo: " + Collections.min(carrosPopulares.values()));
        System.out.println("Valor soma: " + soma);
        System.out.println("Valor média: " + soma / carrosPopulares.values().size());

        // O método entrySet retorna um set com os elementos do Map e o seu retorno é do tipo Entry
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();

        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry: entries) {
            if (entry.getValue().equals(Collections.max(carrosPopulares.values()))) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("O modelo mais eficiente é: " + modeloMaisEficiente);
            }
        }

        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";

        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("O modelo menos eficiente é: " + modeloMenosEficiente);
            }
        }

        // Para remover elementos usamos o remove();
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        // Ordenação por ordem de inserção.
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);

        // Exibir pela ordem de modelos
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        // Estará em ordem alfabética
        System.out.println(carrosPopulares2);


        // Usamos o método clear() quando queremos apagar o Map
        carrosPopulares.clear();

        // Para conferirmos se o Map está vazio usamos o método isEmpty()
        System.out.println(carrosPopulares.isEmpty());

    }
}
