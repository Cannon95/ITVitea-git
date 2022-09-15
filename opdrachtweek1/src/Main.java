import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Phone> phones = new ArrayList<>();

    public static void main(String[] args) {
        registerPhones();
        show();
    }

    private static void registerPhones() {
        phones.add(new Phone("Huawei", "P30", 697, "6.47\" FHD+ (2340x1080) OLED, Kirin 980 Octa-Core (2x Cortex-A76 2.6GHz+ 2x Cortex-A76 1.92GHz + 4x Cortex-A55 1.8GHz), 8GB RAM, 128GB ROM,40+20+8+TOF/32MP, Dual SIM, 4200mAh, Android 9.0 + EMUI 9.1"));
        phones.add(new Phone("Samsung", "Galaxy A52", 399, "64 megapixel camera, 4k videokwaliteit 6.5 inch AMOLED scherm 128 GBopslaggeheugen (Uitbreidbaar met Micro-sd) Water- en stofbestendig(IP67)"));
        phones.add(new Phone("Apple", "iPhone 11", 619, "Met de dubbele camera schiet je in elke situatie een perfecte foto of videoDe krachtige A13-chipset zorgt voor razendsnelle prestaties Met Face IDhoef je enkel en alleen naar je toestel te kijken om te ontgrendelen Hettoestel heeft een lange accuduur dankzij een energiezuinige processor"));
        phones.add(new Phone("Google", "Pixel 4a", 411, "12.2 megapixel camera, 4k videokwaliteit 5.81 inch OLED scherm 128 GBopslaggeheugen 3140 mAh accucapaciteit"));
        phones.add(new Phone("Xiaomi", "Redmi Note 10 Pro", 298, "108 megapixel camera, 4k videokwaliteit 6.67 inch AMOLED scherm 128GB opslaggeheugen (Uitbreidbaar met Micro-sd) Water- en stofbestendig(IP53)"));
    }

    private static void show() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Kies een nummer uit:");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println(i + 1 + " : " + phones.get(i).getName());
        }

        System.out.println("... ");
        int n = sc.nextInt();
        if (n >= 1 && n <= phones.size()) {
            Phone p = phones.get(n - 1);
            System.out.flush();
            System.out.println("merk = " + p.getName() + " , Type " + p.getType() + " , Prijs: €" + p.getPrice());
            System.out.println("Omschrijving: " + p.getDesc());
        } else {
            System.err.println("Dit nummer is niet geldig!");
        }
    }
}
