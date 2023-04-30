import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    public static List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alicia", 75, "Quindio"));
        people.add(new Person("Robinson", 32, "Pereira"));
        people.add(new Person("Carlos", 85, "Medellin"));
        people.add(new Person("David", 49, "Caldas"));
        people.add(new Person("Camila", 15, "Barbosa"));
        people.add(new Person("Frank", 54, "Cucúta"));
        people.add(new Person("Alice", 26, "Quindio"));
        people.add(new Person("Robert", 60, "Pereira"));
        people.add(new Person("Charles", 35, "Medellin"));
        people.add(new Person("Daniela", 40, "Caldas"));
        people.add(new Person("Camilo", 27, "Barbosa"));
        people.add(new Person("Franklin", 58, "Cucúta"));
        people.add(new Person("Alberto", 25, "Quindio"));
        people.add(new Person("Sonia", 10, "Pereira"));
        people.add(new Person("Sofia", 68, "Medellin"));
        people.add(new Person("Melany", 70, "Caldas"));
        people.add(new Person("Natalia", 45, "Barbosa"));
        people.add(new Person("Zoraya", 51, "Cucúta"));
        return people;
    }
}


