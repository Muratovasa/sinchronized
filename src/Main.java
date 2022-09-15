import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int count = 10;
        final int time = 300;
        List<String> products = new ArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                synchronized (products) {
                    if (products.isEmpty()) {
                        try {
                            products.wait();
                            System.out.println("машин нет");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("\"Продавец выпустил новый авто №\" " + i + products.remove(0));
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                synchronized (products) {
                    products.add(" Выдали товар покупателю ");
                    products.notify();
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
