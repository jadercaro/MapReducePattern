import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapReduceExample {

    public static void main(String[] args) {
        // base de datos de ejemplo
        List<String> data = new ArrayList<>();
        data.add("manzana");
        data.add("banano");
        data.add("manzana");
        data.add("fresa");
        data.add("banano");
        data.add("manzana");
        data.add("uva");
        data.add("fresa");
        data.add("Cereza");
        data.add("manzana");
        data.add("fresa");
        data.add("banano");
        data.add("manzana");
        data.add("uva");


        // proceso Map   ----> este proceso se puede hacer en distintas maquinas o cluster
        Map<String, Integer> mappedData = new HashMap<>(); //creamos el hashmap con clave valor
        for (String word : data) {                         //recorrer cada valor de la base de datos
            if (mappedData.containsKey(word)) {            // Si el dato ya existe en el hashmap...
                int count = mappedData.get(word);          //obtenga el valor de dicha clave y pongala en la variable count
                mappedData.put(word, count + 1);           //sumele 1 y asignele ese valor a la clave
            } else {                                       //si no entonces...
                mappedData.put(word, 1);                   //le agregamos el valor 1 a la clave
            }
        }

        // proceso Reduce
        Map<String, Integer> reducedData = new HashMap<>();                  //creamos un nuevo hashmap
        for (Map.Entry<String, Integer> entry : mappedData.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if (reducedData.containsKey(word)) {
                count += reducedData.get(word);
            }
            reducedData.put(word, count);
        }

        // Output result
        for (Map.Entry<String, Integer> entry : reducedData.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
