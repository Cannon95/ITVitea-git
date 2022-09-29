public class Drinken {

    protected double temperatuur;
    protected double volume;

    public Drinken(double temperatuur, double volume) {
        this.temperatuur = temperatuur;
        this.volume = volume;
    }

    public void drinken(){

        this.volume = Math.max( this.volume - 50,0);
    }

    public double getTemperatuur() {
        return temperatuur;
    }

    public double getVolume() {
        return volume;
    }
}
