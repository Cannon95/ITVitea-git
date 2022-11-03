public class Cijfer {

    public char nummerNaarCijfer(int cijfer){
        if(cijfer < 0){
            throw new IllegalArgumentException("Cijfer kan niet lager zijn dan 0");
        }
        else if(cijfer > 100){
            throw new IllegalArgumentException("Cijfer kan niet hoger zijn dan 100");
        }
        else if(cijfer < 60){
            return 'F';
        }
        else if(cijfer < 70){
            return 'D';
        }
        else if(cijfer < 80){
            return 'C';
        }
        else if(cijfer < 90){
            return 'B';
        }
        else{
            return 'A';
        }
    }

}
