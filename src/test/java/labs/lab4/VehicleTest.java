package labs.lab4;

import labs.lab4.human.Firefighter;
import labs.lab4.human.Human;
import labs.lab4.human.Policeman;
import labs.lab4.vehicle.Bus;
import labs.lab4.vehicle.Vehicle;
import labs.lab4.vehicle.car.FireTruck;
import labs.lab4.vehicle.car.Police;
import labs.lab4.vehicle.car.Taxi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VehicleTest {
    @SuppressWarnings({"unchecked"})
    @Test
    void testAddRemovePassengersAndRoad() {
        Human human1 = new Human(23);
        Human human2 = new Human(42);
        Policeman policeman1 = new Policeman(29);
        Policeman policeman2 = new Policeman(40);
        Policeman policeman3 = new Policeman(50);
        Firefighter firefighter = new Firefighter(54);

        Bus bus = new Bus(30);
        bus.addPassenger(human1);
        bus.addPassenger(human2);
        bus.addPassenger(policeman1);
        bus.addPassenger(firefighter);

        Police police = new Police(2);
        // error
        // police.addPassenger(human1);
        // error
        // police.addPassenger(firefighter);
        assertThrows(RuntimeException.class, () -> police.removePassenger(policeman1));
        police.addPassenger(policeman1);
        police.addPassenger(policeman2);
        assertThrows(RuntimeException.class, () -> police.addPassenger(policeman3));

        FireTruck fireTruck = new FireTruck(10);
        // error
        // fireTruck.addPassenger(human1);
        // error
        // fireTruck.addPassenger(policeman1);
        fireTruck.addPassenger(firefighter);

        Taxi taxi = new Taxi(3);
        taxi.addPassenger(human1);
        taxi.addPassenger(policeman1);
        taxi.addPassenger(firefighter);

        Road road = new Road();
        road.addVehicle(bus);
        road.addVehicle(police);
        road.addVehicle(fireTruck);
        road.addVehicle(taxi);
        assertEquals(10, road.getTotalPeople());

        Vehicle<Policeman> vehicleB = (Vehicle<Policeman>) (Vehicle<?>) fireTruck;
        vehicleB.addPassenger(policeman1);
        assertThrows(ClassCastException.class, () -> {
            //noinspection unused
            Firefighter notAFirefighter = fireTruck.getByAge(policeman1.getAge());
        });
    }
}
