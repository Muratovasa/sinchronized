public class Cars {
    public static String name;
    private int countCar = 0;
    public Cars(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCar(){
        System.out.printf("производитель %s выпустил 1 авто\n", Cars.name,"\n");
        return countCar++;
    }
}
