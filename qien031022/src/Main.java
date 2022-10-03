import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double stroomversnelling = new Random().nextDouble()*20;

        String sv = "zwak";
        if(stroomversnelling > 15)sv = "zeer sterk";
        else if(stroomversnelling > 10)sv = "sterk";
        else if(stroomversnelling > 5)sv = "matig";

        System.out.println("je begint aan je plezierige rondje Raften. de stroomversnelling is " + sv);
        try{
            for (int i = 0; i < 20; i++) {
                Thread.sleep(1000);
                raften(stroomversnelling);
                System.out.print(".");
            }
            System.out.println("je hebt zonder problemen geraft. je bent trots op jezelf");
        }catch(PlonsException e){
            klimopBoot();

        }catch(RoeispaanException e){
            roeispaan();

        }catch(InterruptedException e){
            System.out.println("err interupted");
        }finally{
            betalen();
        }


    }

    static void raften(double stroomversnelling) throws PlonsException, InterruptedException, RoeispaanException {

        double kansopPlons = (stroomversnelling-10)*2;
        Random r = new Random();
        if(kansopPlons > 0 && kansopPlons > r.nextInt(100)){
            throw new PlonsException();
        }
        if(1 > r.nextInt(30)){
            throw new RoeispaanException();
        }


    }
    static void klimopBoot(){
        Scanner input = new Scanner(System.in);
        System.out.print("Je bent in het water gevallen. welk voorwerp gebruik je? ");
        String voorwerp = input.nextLine();
        if(voorwerp.toLowerCase().equals("touw") || voorwerp.toLowerCase().equals("roeispaan")){
            System.out.println("je klom succesvol op de boot. je besloot door het slechte voorval meteen weer naar terug te gaan.");
        }
        else{
            try {
                System.out.println("je verdrinkt...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("je raakt je bewustzijn kwijt...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("je word wakker gemaakt door de raft eigenaar...");
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("err interupted");
            }

        }
    }

    static void roeispaan() {
        Scanner input = new Scanner(System.in);
        System.out.print("Je liet de roeispaan in het water vallen raak je in paniek? ");
        String voorwerp = input.nextLine();
        if (voorwerp.toLowerCase().equals("nee")) {
            System.out.println("je raakte niet in paniek. je wachte af...");
            try {
                Thread.sleep(1000);
                System.out.print("...");
                Thread.sleep(1000);
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("een reiger heeft je ontdekt en hij neemt je veilig mee naar de kant zodat je de eigenaar kan betalen.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("err interupted");
            }
        } else {
            System.out.println("je bleef je de hele rit stressen.");
            try {
                Thread.sleep(1000);
                System.out.println("de verlangen naar die vertrouwde roeispaan...");
                Thread.sleep(1000);
                System.out.println("de passie voor om ermee in het water te plonsen...");
                Thread.sleep(1000);
                System.out.println("het opspattende water.");
                Thread.sleep(1000);
                System.out.println("die boze naakte dronken man in het water die je er mee mept.");
                Thread.sleep(1000);
                System.out.println("uiteindelijk besloot je maar de straalmotor aan te zetten en je kwam veilig aan land");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("err interupted");
            }
        }
    }

    static void betalen(){
        System.out.println("je betaalde een belachelijk bedrag van 250 euro voor een klein beetje raften!");
        System.out.println("bij dit bedrijf ga je de volgende keer niet meer raften.");
    }


}



class PlonsException extends Exception{

    public PlonsException(){
        super("je viel in de rivier");
    }
}

class RoeispaanException extends Exception{

    public RoeispaanException(){
        super("je liet je roeispaan in het water vallen");
    }
}