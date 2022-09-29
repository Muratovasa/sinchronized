import java.util.ArrayList;
import java.util.List;

public class AutoSalon {
    final int countCars=5;
    Seller seller= new Seller(this);
    List <Cars> cars=new ArrayList<>(countCars);
    public Cars sellCars(){
        return seller.sellCars();
    }

    public void bringCars(){
        seller.receiveCars();
    }

    List<Cars> getCars(){
        return cars;
    }
}
