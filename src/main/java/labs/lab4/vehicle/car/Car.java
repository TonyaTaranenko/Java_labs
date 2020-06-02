package labs.lab4.vehicle.car;

import labs.lab4.human.Human;
import labs.lab4.vehicle.Vehicle;

public class Car<T extends Human> extends Vehicle<T> {
    public Car(int numberOfSeats) {
        super(numberOfSeats);
    }
}
