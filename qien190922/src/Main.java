import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        eindOpdracht();
    }

    static void opdracht1(){
        Scanner input = new Scanner(System.in);
        System.out.print("Geef de basis: ");
        int basis = input.nextInt();
        System.out.print("Geef de exponent: ");
        int exponent = input.nextInt();
        int result = new Methods().exponent(basis,exponent);
        System.out.println(String.format("%d tot de macht %d is: %d", basis, exponent,result));
    }

    static void opdracht2(){
        Scanner input = new Scanner(System.in);
        System.out.print("Geef een getal: ");
        int getal = input.nextInt();

        String result = new OddEvenClass().isOdd(getal) ? "oneven" : "even";
        System.out.println(String.format("getal %d is %s", getal, result));
    }

    static void eindOpdracht(){
        Scanner input = new Scanner(System.in);
        System.out.print("Geef een natuurlijk getal: ");
        int getal = input.nextInt();
        List<Integer> result = new Methods().lucasgetal(getal);
        if(result.size() == 1 && result.get(0) == -1){
            System.out.println("Getal negatief, fout");
        }
        else if(result.size() == 1 && result.get(0) == -2){
            System.out.println("Getal te groot, past niet");
        }
        else {
            System.out.println("De eerste " + getal + " Lucas-getallen:");

            result.forEach(i -> System.out.println(i + " "));

        }
    }

}