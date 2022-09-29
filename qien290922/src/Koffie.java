/**
 * binnenkort geen koffie meer te verkrijgen. drink maar water
 */
@Deprecated
public class Koffie extends Drinken{

    String sterkte;
    /**
     * binnenkort geen koffie meer te verkrijgen. drink maar water
     */
    public Koffie(double temperatuur, double volume, String sterkte) {
        super(temperatuur, volume);
        this.sterkte = sterkte;
    }

    @Override
    public void drinken(){
        this.volume = Math.max( this.volume - 30,0);
    }


}
