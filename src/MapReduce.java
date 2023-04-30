import java.util.ArrayList;
import java.util.List;

public class MapReduce {

    public static double calculateAverage(List<Person> persons) {
        int numMappers = 4; // número de mappers
        int numReducers = 2; // número de reducers

        // Dividimos la lista de Person en sub-listas para cada mapper
        List<List<Person>> mapped = partition(persons, numMappers);

        // Creamos un array para almacenar los resultados de cada mapper
        double[] results = new double[numMappers];

        // Ejecutamos el mapeo en cada sub-lista utilizando el método map()
        for (int i = 0; i < numMappers; i++) {
            results[i] = map(mapped.get(i));
        }

        // Ejecutamos la fase de reducción utilizando el método reduce()
        return reduce(results, numReducers);
    }

    // Método que divide una lista en sub-listas para cada mapper
    private static List<List<Person>> partition(List<Person> list, int numPartitions) {
        List<List<Person>> partitions = new ArrayList<>();
        int partitionSize = list.size() / numPartitions;

        for (int i = 0; i < numPartitions; i++) {
            if (i == numPartitions - 1) {
                partitions.add(list.subList(i * partitionSize, list.size()));
            } else {
                partitions.add(list.subList(i * partitionSize, (i + 1) * partitionSize));
            }
        }

        return partitions;
    }

    // Método que ejecuta la función map en una sub-lista
    private static double map(List<Person> list) {
        int sum = 0;
        for (Person p : list) {
            sum += p.getAge();
        }
        return (double) sum / list.size();
    }

    // Método que ejecuta la función reduce para combinar los resultados de los mappers
    private static double reduce(double[] results, int numReducers) {
        for (int i = 0; i < numReducers; i++) {
            double sum = 0;
            int count = 0;

            for (int j = i; j < results.length; j += numReducers) {
                sum += results[j];
                count++;
            }

            results[i] = sum / count;
        }

        return results[0]; // devolvemos el resultado final
    }
}
