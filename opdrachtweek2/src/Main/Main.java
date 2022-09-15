package Main;

import Main.Phoneshop.Business.PhoneService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PhoneService service = new PhoneService();
        service.show();
        int getal = input.nextInt();
        service.getResult(getal - 1);
    }
}