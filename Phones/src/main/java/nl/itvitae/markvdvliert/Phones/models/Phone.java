package nl.itvitae.markvdvliert.Phones.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
public class Phone {
    private @Id @GeneratedValue Integer propertyId;
    private String merk;
    private String type;
    private int prijs;
    private String beschrijving;

    public Phone(String merk, String type, int prijs,Integer id, String beschrijving) {
        this.propertyId = id;
        this.merk = merk;
        this.type = type;
        this.prijs = prijs;
        this.beschrijving = beschrijving;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    public int getPrijs() {
        return prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }
}
