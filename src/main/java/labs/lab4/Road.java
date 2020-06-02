package labs.lab4;

import labs.lab4.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private List<Vehicle<?>> vehicles = new ArrayList<>();

    public int getTotalPeople() {
        int ret = 0;
        for (Vehicle<?> vehicle : vehicles) {
            ret += vehicle.getOccupiedSeats();
        }
        return ret;
    }

    public void addVehicle(Vehicle<?> vehicle) {
        vehicles.add(vehicle);
    }
}
