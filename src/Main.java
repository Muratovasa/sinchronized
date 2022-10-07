import java.util.ArrayList;
import java.util.List;

public class Main {
    static final AutoSalon autoSalon = new AutoSalon();
    static  final int countCars = 10;
    static final long timeSleep=3000L;
    static int countBayer=5;
    static  List<Integer> carSale = new ArrayList<>();
    public static void main(String[] args) {
    for(int i=0;i<countBayer;i++){
        new MyTread().start();
    }
        new Thread(() -> {
            for(int i = 0; i<=countBayer; i++) {
                synchronized (carSale) {
                    autoSalon.comeIn();
                    if (carSale.isEmpty()) {
                        System.out.println("машин нет");
                        try {
                            carSale.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    autoSalon.buyCars();
                    carSale.remove(0);
                }
            }
        }).start();
        new Thread(()->{
            for (int i=0;i<countCars;i++){
                Cars cars=new Cars("mersedes");
                synchronized (carSale){
                    carSale.add(cars.getCar());
                    carSale.notify();
                }
                try {
                        Thread.sleep(timeSleep);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }).start();

        new Thread(()->{
            for (int i=0;i<countCars;i++){
                Cars cars=new Cars("bmv");
                synchronized (carSale){
                    carSale.add(cars.getCar());
                    carSale.notify();
                }
                try {
                    Thread.sleep(timeSleep);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();
        }
    }
