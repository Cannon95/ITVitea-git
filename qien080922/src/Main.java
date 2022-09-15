import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        vraag2();
    }

    /**
     * berekend de afstand via de x en y coordinaten
     *
     * @param x de x coordinaat
     * @param y de y coordinaat
     * @param z de z coordinaat
     * @return de afstand
     */
    public static double afstand(double x, double y, double z) {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static double afstand(Vec3d v) {

        return afstand(v.getX(), v.getY(), v.getZ());
    }

    public static double[] abc(double a, double b, double c) {
        double[] d = new double[2];
        double g = (b * b - 4 * a * c) / (2 * a);
        d[0] = -b + g;
        d[1] = -b - g;
        return d;
    }

    public static void dag(int dag) {

        if (dag == 0) {
            System.out.println("Zondag.");
        } else if (dag == 1) {
            System.out.println("Maandag.");
        } else if (dag == 2) {
            System.out.println("Dinsdag.");
        } else if (dag == 3) {
            System.out.println("Woensdag.");
        } else if (dag == 4) {
            System.out.println("Donderdag");
        } else if (dag == 5) {
            System.out.println("Vrijdag");
        } else if (dag == 6) {
            System.out.println("Zaterdag");
        } else {
            System.out.println("geen geldige dag");
        }

    }

    public static void for1() {

        for (int i = 1; i < 8; i++) {
            System.out.println(i + " " + (i + 1) + " " + (i + 2));
        }
    }

    public static void for2() {
        for (int i = 8; i > 0; i--) {
            for (int j = 1; j <= 8; j++) {
                System.out.print("(" + i + "," + j + ")");
            }
            System.out.println();
        }
    }

    public static void vraag() {
        Scanner input = new Scanner(System.in);
        System.out.print("Voer een naam in: ");
        String s = input.nextLine();
        if (s.length() < 0) {
            System.out.println("Hello, World!");
        } else {
            System.out.println("Hello, " + s);
        }
    }

    public static void vraag2() {
        Scanner input = new Scanner(System.in);
        int getal = -1;
        while(getal < 1){
            System.out.print("Geef een geheel positief getal: ");
            getal = input.nextInt();
            if(getal < 1){
                continue;
            }
            int somEven = 0;
            int somOneven = 0;
            for (int i = 1; i <= getal; i++) {
                if (i % 2 == 1) somOneven += i;
                else somEven += i;
            }
            System.out.println(String.format("som van oneven getallen tot en met %d is %d", getal, somOneven));
            System.out.println(String.format("som van even getallen tot en met %d is %d", getal, somEven));
            System.out.println("verschil tuusen twee sommen is " + Math.abs(somOneven - somEven));
        }

    }

    class Vec3d {

        private double x;
        private double y;
        private double z;

        public Vec3d(double x_, double y_, double z_) {
            this.x = x_;
            this.y = y_;
            this.z = z_;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getZ() {
            return z;
        }

        public void setZ(double z) {
            this.z = z;
        }

    }

    enum Lampje{

        UIT,
        AAN;

        private static Lampje lampje = Lampje.UIT;
        public void zetAan(){
            if (lampje == Lampje.AAN){
                throw(new IllegalStateException("lampje is al aan"));
            }
            else{
                lampje = Lampje.UIT;
                System.out.println("het licht ging aan");
            }
        }
        public void zetUit(){
            if (lampje == Lampje.UIT){
                throw(new IllegalStateException("lampje is al uit"));
            }
            else{
                lampje = Lampje.UIT;
                System.out.println("het licht ging uit");
            }
        }

    }
}
