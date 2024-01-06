import Product.Vehicle;
import Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Vehicle> vehicle = null;

        List<User> userList = addUser();
        List<Store> storeList = addStore(vehicle);
        List<Vehicle> vehicles = addVehicles();

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(userList, storeList);


        //TODO: Workflow

        //TODO: User comes

        User user = userList.get(0);

        //TODO: User search for the store;

        Location location = new Location("Bellandur", "Bangalore", "BEKAAR", 500000);
        Store store = vehicleRentalSystem.getStore(location);

        //TODO: User looks for the vehicles present in store;

        List<Vehicle> storeVehicle = store.getVehicle();

        //TODO: User reserves specific vehicle

        Reservation reservation = store.makeReservation(vehicles.get(0), user);

        //TODO: bill is generate

        Bill bill = new Bill(reservation);

        //TODO: User makes the payment
        Payment payment = new Payment();
        payment.payBill(bill);


    }

    private static List<Vehicle> addVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(1);
        vehicle.setVehicleNumber(1234);
        vehicle.setVehicleType(VehicleType.CAR);
        vehicles.add(vehicle);
        return vehicles;
    }

    private static List<Store> addStore(List<Vehicle> vehicles) {
        List<Store> stores = new ArrayList<>();

        Store store = new Store();
        store.storeId = 1;
        store.addVehicles(vehicles);
        stores.add(store);
        return stores;

    }

    private static List<User> addUser() {
        List<User> users = new ArrayList<>();

        User user = new User();
        user.setUserId(1);
        user.setUserName("USer 1");
        user.setDrivingLicense("BR33");

        users.add(user);
        return users;

    }
}