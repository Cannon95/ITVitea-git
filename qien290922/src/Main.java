public class Main {
    public static void main(String[] args) {

        Koffie koffie = new Koffie(82.3, 250.0, "HEEL STERK!!");
        Water water = new Water(16.4, 250.0);

        koffie.drinken();
        water.drinken();

        System.out.println(koffie.getVolume());
        System.out.println(water.getVolume());
    }
}