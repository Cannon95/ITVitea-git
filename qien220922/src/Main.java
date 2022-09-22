import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        opdracht2();
    }

    static void opdracht1() {
        Scanner input = new Scanner(System.in);
        System.out.print("Geef een willekeurige tekst: ");
        String text = input.nextLine();
        String result = "";
        for (char c : text.toCharArray()) {
            result = c + result;
        }
        System.out.println("omgedraait is het : " + result);
        String opt = result.equals(text) ? "een palindroom" : "GEEN palindroom";
        System.out.println("de tekst is " + opt);
    }

    static void opdracht2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Geef een willekeurige tekst: ");
        String text = input.nextLine();
        String[] numbers = text.split(" ");
        int[] result = new int[numbers.length];
        try {
            for (int i = 0; i < numbers.length; i++) {
                result[i] = Integer.parseInt(numbers[i]);
            }
            Function<Integer, String> function = (index) -> {
                String ans = "";
                for (int i = 0; i < index; i++) {
                    ans += "*";
                }
                return ans + "(" + result[index] + ")";
            };
            for (int i = 0; i < result.length; i++) {
                System.out.println(function.apply(i));
            }
        } catch (NumberFormatException e) {
            System.err.println("verkeerde invoer!!!");
        }
    }

    static void Eindopdracht(){

    }
}