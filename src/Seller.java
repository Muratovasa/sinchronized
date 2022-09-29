public class Seller {
    private AutoSalon autoSalon;
    public Seller(AutoSalon autoSalon){
        this.autoSalon=autoSalon;
    }
    public synchronized void receiveCars(){
        try {
            System.out.println("Автосалон: Доставка и прием автомобилей");
            Thread.sleep(3000);
            autoSalon.getCars().add(new Cars());
            System.out.println("Автосалон: машины на складе");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Cars sellCars(){
        try {
            while (autoSalon.getCars().size()==0){
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(100);
            System.out.println(" Покупатель уехал на новом автомобиле");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return autoSalon.getCars().remove(0);
    }
}
