import Product.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Store {

    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;


    List<Reservation> reservationList = new ArrayList<>();

    public List<Vehicle> getVehicle(){
        return vehicleInventoryManagement.getVehicles();
    }

    public void addVehicles(List<Vehicle> vehicles){
         vehicleInventoryManagement.addNewVehcile(vehicles);
    }

    public Reservation makeReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.setVehicle(vehicle);
        reservation.setUser(user);
        reservationList.add(reservation);
        return reservation;
    }

}
