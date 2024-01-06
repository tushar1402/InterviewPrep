import Product.Vehicle;

import java.util.Date;

public class Reservation {

    Vehicle vehicle;
    Store store;
    User user;
    Date bookingDate;

    String bookedFrom;
    String bookedTo;

    Long bookedAtTimeStamp;
    Long bookedTillTimeStamp;

    ReservationStatus reservationStatus;

    Location pickupLocation;
    Location dropOffLocation;

    public void setVehicle(Vehicle vehicle){

    }

    public void setUser(User user){

    }
}
