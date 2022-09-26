import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        Eindopdracht();
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
        String raadHetWoord = "broodje";
        Scanner input = new Scanner(System.in);
        List<Character> woord = new ArrayList<>();
        List<Character> geheim = new ArrayList<>();

        int wrongGuesses = 5;
        for (char c : raadHetWoord.toCharArray()) {
            woord.add(c);
            geheim.add('_');
        }
        do{
            geheim.stream().forEach(System.out::print);
            System.out.println(" ( " + wrongGuesses + " verkeerde gokken over)");

            System.out.print("raad een letter of het hele woord: ");

            String ans = input.nextLine();
            if(ans.equals(raadHetWoord)){
                geheim.clear();
                System.out.println("je hebt het woord geraden, gefeliciteerd");

            } else if (ans.length() == 1 && raadHetWoord.contains(ans)) {

                for (int i = 0; i < raadHetWoord.toCharArray().length; i++) {
                    String letter = "" + raadHetWoord.toCharArray()[i];
                    if(letter.equals(ans)){
                        if(("" + geheim.get(i)).equals(ans)){
                            wrongGuesses--;
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Die letter was al gegokt...");
                            break;
                        }else{
                            geheim.set(i, ans.toCharArray()[0]);
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("je hebt een letter geraden");

                        }

                    }
                }

            } else{
                wrongGuesses--;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("het woord bevat deze letter niet");
            }

        }while(wrongGuesses >= 0 && geheim.contains('_'));



    }
}