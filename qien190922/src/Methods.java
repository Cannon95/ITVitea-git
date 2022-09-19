import java.util.ArrayList;
import java.util.List;

public class Methods {

    public int exponent(int base, int exp){
        if(exp == 0){
            return 1;
        }
        else if(exp < 0){
            return 1/(base*exponent(base, exp + 1));
        }
        else {
            return base*exponent(base, exp - 1);
        }



    }
    public List<Integer> lucasgetal(int getal){
        if(getal < 1){
            return List.of(-1);
        }
        List<Integer> list = new ArrayList<>();
        int waarde = 0;
        int tempwaarde1 = 0;
        int tempwaarde2 = 0;
        for (int i = 1; i < getal; i++) {
            if (i == 1){
                waarde = 2;
                list.add(waarde);
                tempwaarde1 = 2;
            }
            else if (i == 2){
                waarde = 1;
                tempwaarde2 = tempwaarde1;
                tempwaarde1 = waarde;
                list.add(waarde);
            }
            else{

                waarde += tempwaarde2;
                if(waarde < 0){
                    return List.of(-2);
                }
                tempwaarde2 = tempwaarde1;
                tempwaarde1 = waarde;
                list.add(waarde);
            }

        }
        return list;
    }



}
