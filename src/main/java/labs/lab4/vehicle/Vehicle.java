package labs.lab4.vehicle;

import labs.lab4.human.Human;

import java.util.ArrayList;
import java.util.List;

public class Vehicle<T extends Human> {
    private List<T> passengers;
    private int seatCount;

    public Vehicle(int seatCount) {
        this.seatCount = seatCount;
        this.passengers = new ArrayList<>();
    }

    public T getByAge(int age) {
        for (T human : passengers) {
            if (human.getAge() == age) {
                return human;
            }
        }
        return null;
    }

    public void addPassenger(T passenger) {
        if (passengers.size() < seatCount) {
            passengers.add(passenger);
        } else {
            throw new RuntimeException();
        }
    }

    public void removePassenger(T passenger) {
        if (!passengers.remove(passenger)) {
            throw new RuntimeException();
        }
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public int getTotalSeats() {
        return seatCount;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "passengerList=" + passengers +
                ", numberOfSeats=" + seatCount +
                '}';
    }
}
