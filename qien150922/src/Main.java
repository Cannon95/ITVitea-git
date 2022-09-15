import java.time.LocalDate;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("tijd naar minuten");
//        System.out.println("geef het aantal jaren: ");
//        short years = input.nextShort();
//        System.out.println("geef het aantal Maanden: ");
//        short months = input.nextByte();
//        System.out.println("geef het aantal Weken: ");
//        short weeks = input.nextByte();
//        System.out.println("geef het aantal Dagen: ");
//        short days = input.nextByte();
//        System.out.println("geef het aantal Uren: ");
//        short hours = input.nextByte();
//
//        int minutes = toMinutes((short)2022,(byte)1,(byte)1,(byte)1,(byte)1);
//        System.out.println("de hoeveelheid minuten vooruit is " + minutes);
//
//
//    }
    public static void main(String[] args) {

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
        System.out.println("invoer tijd in uur: " + seconden/3600F);
        System.out.println("snelheid in m/s: " + meter*seconden);
        System.out.println("snelheid in km/u: " + snelheden[0]);
        System.out.println("snelheid in mph: " + snelheden[1]);

    }
    public static int toMinutes(short year, byte months, byte weeks, byte days, byte hours){

        int minutes = 0;
        LocalDate date = LocalDate.now();
        LocalDate date2 = date.plusMonths(months);
        LocalDate date3 = date.plusYears(year);

        minutes += (int)((date3.toEpochDay() - date.toEpochDay()) * 24 * 60); //adding years in minutes
        minutes += (int)((date2.toEpochDay() - date.toEpochDay()) * 24 * 60); //adding months in minutes
        minutes += (int)((float)weeks * 7 * 24 * 60); //adding weeks in minutes
        minutes += (int)((float)days * 24 * 60); //adding days in minutes
        minutes += (int)((float)hours * 60); //adding hours in minutes

        return minutes;
    }

    public static float fahrenheit2Celsius(float fahrenheit){
        float celsius = 0;
        celsius = -40.0F + ((fahrenheit+40F)/1.8F);
        return celsius;
    }

    public static float[] snelheid(float ms){
        float kmu = ms/3.6F;
        float mph = kmu*1.609F;
        float[] arrList = {kmu,mph}
        return arrList;
    }

}