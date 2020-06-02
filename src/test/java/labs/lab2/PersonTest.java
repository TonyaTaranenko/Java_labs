package labs.lab2;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    @Test
    void testEquals() {
        EqualsVerifier.forClass(Person.class).verify();

        Person person = new Person("John", "USA", 42);
        assertEquals(person, Person.fromJson(Person.toJson(person)));
    }
}
