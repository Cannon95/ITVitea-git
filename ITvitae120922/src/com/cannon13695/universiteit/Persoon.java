/**
 * een saai programma om te leren hoe je open deuren kan intrappen...
 * @author Mark van de Vliert
 * @version 1.0
 * @since 12-09-2022
 *
 */
package com.cannon13695.universiteit;


public class Persoon {
    private int leeftijd;
    private String naam;

    public Persoon(String naamIn, int leeftijdIn){
        this.leeftijd = leeftijdIn;
        this.naam = naamIn;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getNaam() {
        return naam;
    }

}
