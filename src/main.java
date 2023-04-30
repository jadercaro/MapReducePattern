import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Person> people = Person.getPeople();

        // Ejecutamos el cálculo del promedio utilizando MapReduce
        double average = MapReduce.calculateAverage(people);

        // Imprimimos el resultado
        System.out.println("La edad promedio de las personas es: " + average);
    }
}