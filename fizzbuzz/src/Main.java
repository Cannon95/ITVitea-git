public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++){
            System.out.println(fizzbuzz(i));
        }
    }

    public static String fizzbuzz(int getal){
    String answ = "";
        if(getal%3 == 0){
            answ += "Fizz";
        }
        if(getal%5 == 0){
            answ += "Buzz";
        }
        if(answ.equals("")){
            answ = "" + getal;
        }

        return answ;
    }

}

