public class Rekenmachine {

    public int optellen(int a, int b){
        return a + b;
    }
    public int aftrekken(int a, int b){
        return a - b;
    }

    public double delen(double a, double b){
        if(b == 0){
            if(a > 0)return Double.POSITIVE_INFINITY;
            if(a < 0)return Double.NEGATIVE_INFINITY;
            else return Double.NaN;
        }
        else{
            return a / b;
        }

    }

    public int vermenigvuldigen(int a, int b){
        return a * b;
    }
    public double totDeMacht(double a, double b){

       return Math.pow(a,b);
    }
    public double wortel(double a){
        if (a >= 0){
            return (int)Math.sqrt(a);
        }
        else{
            return Double.POSITIVE_INFINITY;
        }
    }

}
