public class Bill {

    Reservation reservation;
    long billAmount;
    boolean isPaid;

    Bill(Reservation reservation){
        this.reservation = reservation;
        this.billAmount = (long) computeBill();
        isPaid = false;
    }

    private double computeBill(){
        return 100.0;

    }
}
