import java.util.List;

public class VehicleRentalSystem {

    List<User> userList;

    List<Store> storeList;

    public VehicleRentalSystem(List<User> userList, List<Store> storeList) {
        this.userList = userList;
        this.storeList = storeList;
    }

    public Store getStore(Location location){
        return storeList.get(0);
    }
}
