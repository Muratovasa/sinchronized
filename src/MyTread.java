public class MyTread extends Thread {

    @Override
    public void run() {
            synchronized (Main.carSale) {
                Main.autoSalon.comeIn();
                if (Main.carSale.isEmpty()) {
                    System.out.println("машин нет");
                    try {
                        Main.carSale.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Main.autoSalon.buyCars();
                Main.carSale.remove(0);
            }
        }
    }
