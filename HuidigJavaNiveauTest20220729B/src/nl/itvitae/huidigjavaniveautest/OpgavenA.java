package nl.itvitae.huidigjavaniveautest;

import java.util.List;

public class OpgavenA {
    public static void opgave1() {
        // maak een variabele 'character' en ken er de waarde 'b' aan toe

        // [vul hier de code in om de variabele te maken]

        // Als je de code wilt testen, 'oncommentaar' de regels hieronder,
        // verwijder de '//' (bijvoorbeeld door de regels te selecteren en
        // op Ctrl + / te drukken
        char character = 'b';
         if (character != 'b') throw new RuntimeException("Opgave A1 faalt!");
         System.out.println("Opgave A1 is geslaagd!");
    }

    public static int opgave2(int eersteGetal, int tweedeGetal) {
        // geef de som terug van het eerste getal en het tweede getal
        // (maak de code hierbeneden kloppend)
        // Als je klaar bent, verwijder de regel met throw new NotYetImplementedException.

         return eersteGetal + tweedeGetal;

    }

    public static String opgave3(int kinderen, int appels) {
        // Als er meer appels dan kinderen zijn (of evenveel appels als kinderen), geef de tekst
        // "Voor elk kind is er minstens 1 appel!" terug
        // Geef anders "We hebben meer appels nodig!" terug
        // Hint: gebruik "if", "else" en "return" om de boodschap terug te geven
        // Als je klaar bent, verwijder de regel met throw new NotYetImplementedException.
        return (float)appels/(float)kinderen < 1 ? "We hebben meer appels nodig!" : "Voor elk kind is er minstens 1 appel!";

    }

    public static String opgave4(int n) {
        // Maak een string die de getallen 1 tot en met n teruggeeft in een string. Als n 4 is,
        // moet de methode dus "1234" teruggeven.
        // Hint: een for-loop is hier handig, net zoals weten dat je iets aan een string-variabele
        // vast kan plakken door iets als "tekst += extraTekst" te gebruiken
        // Als je klaar bent, verwijder de regel met throw new NotYetImplementedException.
        String getallen = "";
        for(int i = 1; i < n+1; i++){
            getallen +=  i;
        }
        return getallen;
    }

    public static List<String> opgave5() {
        // maak een lijst van strings die de namen van programmeertalen bevat, en geef die terug
        // met een return.
        // in de lijst moet "C", "C++" en "Java" zitten (in die volgorde)
        // Als je klaar bent, verwijder de regel met throw new NotYetImplementedException.
        List<String> programmeerTalen = List.of("C", "C++", "Java");
        return programmeerTalen;
    }

    public static class Car {
        private final String brand;

        public Car(String brand) {
            this.brand = brand;
        }

        public String getBrand() {
            return brand;
        }
    }

    public static Car opgave6() {
        // Zorg dat je een auto teruggeeft met als merk "Jaguar"
        // Als je klaar bent, verwijder de regel met throw new NotYetImplementedException.
        Car Jaguar = new Car("Jaguar");
        return Jaguar;
    }
}
