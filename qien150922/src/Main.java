import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        opdracht4();

    }


    public static void opdracht1() {
        Scanner input = new Scanner(System.in);
        System.out.println("tijd naar minuten");
        System.out.println("geef het aantal jaren: ");
        short years = input.nextShort();
        System.out.println("geef het aantal Maanden: ");
        short months = input.nextByte();
        System.out.println("geef het aantal Weken: ");
        short weeks = input.nextByte();
        System.out.println("geef het aantal Dagen: ");
        short days = input.nextByte();
        System.out.println("geef het aantal Uren: ");
        short hours = input.nextByte();

        int minutes = toMinutes((short) 2022, (byte) 1, (byte) 1, (byte) 1, (byte) 1);
        System.out.println("de hoeveelheid minuten vooruit is " + minutes);
    }

    public static void opdracht2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Voer het aantal graden Fahrenheit in");
        float getal = input.nextFloat();

        float celsius = fahrenheit2Celsius(getal);
        System.out.println(String.format("het is %f graden celsius ", celsius));
        System.out.println("Geef nu een een aantal meters");
        float meter = input.nextFloat();
        System.out.println("Geef nu een een aantal seconden");
        float seconden = input.nextFloat();
        float[] snelheden = snelheid(meter * seconden);
        System.out.println("invoer meters: " + meter);
        System.out.println("invoer tijd in uur: " + seconden / 3600F);
        System.out.println("snelheid in m/s: " + meter * seconden);
        System.out.println("snelheid in km/u: " + snelheden[0]);
        System.out.println("snelheid in mph: " + snelheden[1]);
    }

    public static void opdracht3() {
        Scanner input = new Scanner(System.in);
        System.out.print("voer een String in: ");
        String text = input.nextLine();
        String onleesbaar = onleesbaar(text);
        String leesbaar = maakLeesbaar(onleesbaar);
        System.out.println("ingevoerde text: " + text);
        System.out.println("encrypted: " + onleesbaar);
        System.out.println("decrypted: " + leesbaar);
    }

    public static void opdracht4() {
        Scanner input = new Scanner(System.in);
        System.out.print("Geef een geheel positief getal: ");
        int getal = -1;
        while (getal < 0) {
            try {
                getal = input.nextInt();
            } catch (InputMismatchException e) {
                String catchblock = input.next();
                System.out.print("Dat is geen geheel positief getal.Geef een geheel positief getal: ");
                continue;
            }
            if (getal < 0) {
                System.out.print("Dat is geen geheel positief getal.Geef een geheel positief getal: ");
            }
        }
        int evenGetallen = 0;
        int onevenGetallen = 0;
        for (int i = 0; i < getal; i++) {

            if (i % 2 == 0) {
                evenGetallen += i;
            } else {
                onevenGetallen += i;
            }
        }
        System.out.println(String.format("som van oneven getallen tot en met %d is %d", getal, onevenGetallen));
        System.out.println(String.format("som van even getallen tot en met %d is %d", getal, evenGetallen));
        System.out.println("verschil tussen twee sommen is " + Math.abs(evenGetallen - onevenGetallen));
    }

    public static int toMinutes(short year, byte months, byte weeks, byte days, byte hours) {

        int minutes = 0;
        LocalDate date = LocalDate.now();
        LocalDate date2 = date.plusMonths(months);
        LocalDate date3 = date.plusYears(year);

        minutes += (int) ((date3.toEpochDay() - date.toEpochDay()) * 24 * 60); //adding years in minutes
        minutes += (int) ((date2.toEpochDay() - date.toEpochDay()) * 24 * 60); //adding months in minutes
        minutes += (int) ((float) weeks * 7 * 24 * 60); //adding weeks in minutes
        minutes += (int) ((float) days * 24 * 60); //adding days in minutes
        minutes += (int) ((float) hours * 60); //adding hours in minutes

        return minutes;
    }

    public static float fahrenheit2Celsius(float fahrenheit) {
        float celsius = 0;
        celsius = -40.0F + ((fahrenheit + 40F) / 1.8F);
        return celsius;
    }

    public static float[] snelheid(float ms) {
        float kmu = ms / 3.6F;
        float mph = kmu * 1.609F;
        float[] arrList = {kmu, mph};
        return arrList;
    }

    public static String onleesbaar(String s) {
        String encrypt = "";
        char[] charList = s.toCharArray();
        for (int i = 0; i < charList.length; i++) {
            int var1 = i == charList.length - 1 ? (int) charList[i] * 5 + 15 : (int) charList[i] * 5 + 15 + charList[i + 1];
            char var2 = (char) (var1 / 128);
            char var3 = (char) (var1 % 128);
            encrypt += var2 + "" + var3;
        }

        return encrypt;
    }

    public static String maakLeesbaar(String s) {
        String decrypt = "";
        char[] charList = s.toCharArray();
        for (int i = charList.length - 1; i > -1; i -= 2) {
            if (0 == i) {
                System.out.println("Error during decrypting: not encrypted this way");
                return "err";
            } else if (i == charList.length - 1) {
                int var1 = charList[i - 1] * 128 + charList[i];
                int var2 = (var1 - 15) / 5;

                if (var2 > 127) {
                    System.out.println("Error during decrypting: calculation error");
                    return "err";
                } else {
                    decrypt += (char) var2;
                }
            } else {
                int var1 = charList[i - 1] * 128 + charList[i];
                char var1b = decrypt.toCharArray()[0];
                int var2 = (var1 - 15 - (int) var1b) / 5;
                System.out.println("var1: " + var1 + " , var2: " + var2);
                if (var2 > 127) {
                    System.out.println("Error during decrypting: calculation error");
                    return "err";
                } else {
                    decrypt = (char) var2 + decrypt;
                }
            }

        }

        return decrypt;
    }


}