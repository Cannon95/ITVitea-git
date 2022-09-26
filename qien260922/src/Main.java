import java.util.*;

public class Main {
    public static void main(String[] args) {

        eindopdracht();

    }


    static void Opdracht1(){
        List<Integer> percLijst = List.of(25,45,50,60,80);
        List<String> CijferLijst = List.of("F","E","D","C","B");
        Scanner input = new Scanner(System.in);
        System.out.print("Geef een getal weer: ");
        int getal = input.nextInt();
        for (int i = 0; i < percLijst.size(); i++) {
            if(getal < percLijst.get(i)){
                System.out.println("het cijfer is: " + CijferLijst.get(i));
                return;
            }
            System.out.println("het cijfer is: A");
        }
    }

    static int fibonacci(int reeks){
        return reeks == 1 ? 0 : (reeks == 2 ? 1 : fibonacci(reeks-2) + fibonacci(reeks-1));
    }

    static void opdracht2(String browser){
        switch(browser){
            case "edge":
                System.out.println("je Gebruikt Edge D:");
                break;
            case "chrome":
            case "firefox":
            case "opera":
                System.out.println("je gebruikt een moderne browser");
                break;
            case "IE":
                System.out.println("Waarom gerbuik je Internet Explorer");
                break;
            default:
                System.out.println("je gebruikt een niet-ondersteunde browser");
        }
    }

    static void opdracht3(){
        Scanner input = new Scanner(System.in);
        System.out.print("TafelMaker: Geef de groote aan: ");
        int getal = input.nextInt();
        System.out.print("*|");
        for (int i = 1; i < 11; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();
        System.out.println("---------------------------------------------------");
        for (int i = 1; i < getal +1; i++) {
            System.out.print(i + "|");
            for (int j = 1; j < 11; j++) {
                System.out.print("\t" + j*i);
            }
            System.out.println();
        }
    }

    static void opdracht4(){
        int[] list1 = new int[5];
        int[] list2 = new int[5];
        int index = 0;
        while(index < list1.length){
            list1[index] = index + 2;
            index++;
        }
        do {
            list2[index] = index + 3;
            index++;
        }while(index < list2.length);
    }

    static void eindopdracht(){
        Scanner input = new Scanner(System.in);
        System.out.print("voer een zin in: ");
        String zin = input.nextLine().toLowerCase();
        int characters = zin.toCharArray().length;
        System.out.println("aantal characters: " + characters);
        int[] staafd = new int[27];

        int woorden = zin.split(" ").length;
        int klinkers = 0;
        for (char c: zin.toLowerCase().toCharArray()) {
            switch(c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'y':
                    klinkers++;
            }
            //voor de staaf diagram
            switch(c){
                case ' ':
                    staafd[26]++;
                    break;
                // 97 geeft een a. dus zo kan a toegevoegd worden aan array[0]. characters volgen boven die 97 verder met b,c,d ect
                default:
                    staafd[c-97]++;
            }


        }
        System.out.println("aantal klinkers: " + klinkers);
        String omdraai = "";
        for (int i = zin.toCharArray().length -1; i > -1; i--){
            omdraai += "" + zin.toCharArray()[i];
        }
        System.out.println(omdraai.equals(zin) ? "Zin is palindroom" : "Zin is geen palindroom");

        int meesteChars = Arrays.stream(staafd).max().getAsInt();
        System.out.println("max chars: " + meesteChars);
        for (int i = 0; i < meesteChars; i++) {
            for (int j = 0; j < staafd.length; j++) {

                System.out.print(staafd[j] >= meesteChars - i ? "\t*" : "\t.");

            }
            System.out.println();
        }
        for (char c = 0; c < staafd.length - 1; c++) {

            System.out.print("\t" + (char)(c+97));
        }
        System.out.print("\t" + " ");
        System.out.println();
    }
}

