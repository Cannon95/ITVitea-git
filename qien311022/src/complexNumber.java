public class complexNumber {

   public int real, complex;

    public complexNumber(int real, int complex) {
        this.real = real;
        this.complex = complex;
    }

    public String toString(){
        return real + " + " + complex + "i";
    }
}
