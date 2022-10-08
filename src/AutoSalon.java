import java.util.ArrayList;
import java.util.List;

public class AutoSalon {
    public void comeIn(){
        System.out.printf(" Покупатель "+Thread.currentThread().getName()+" зашел в автосалон\n");
    }

    public void buyCars(){
        System.out.println(" Покупатель "+Thread.currentThread().getName()+" уехал на авто\n");
    }
    }
