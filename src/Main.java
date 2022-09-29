public class Main {
    public static void main(String[] args) {
        final AutoSalon autoSalon=new AutoSalon();

        new Thread(null, autoSalon::sellCars, "Покупатель купил машину").start();

        new Thread(null, autoSalon::bringCars, "Пополнен склад автосалона").start();
    }
}
