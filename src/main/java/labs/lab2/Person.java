package labs.lab2;

import com.google.gson.Gson;

import java.util.Objects;

public class Person {
    private final String name;
    private final String address;
    private final int age;

    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(address, person.address);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name, address, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public static String toJson(Person person) {
        return new Gson().toJson(person);
    }

    public static Person fromJson(String json) {
        return new Gson().fromJson(json, Person.class);
    }
}
