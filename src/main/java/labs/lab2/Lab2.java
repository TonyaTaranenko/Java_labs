package labs.lab2;

public class Lab2 {
    public static void main(String[] args) {
        System.out.println(Person.toJson(new Person("John", "USA", 42)));
        System.out.println(Person.fromJson("{\"name\":\"John\",\"address\":\"USA\",\"age\":42}"));
    }
}
