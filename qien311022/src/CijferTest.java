import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CijferTest {

    @Test
    public void lagerDan0Test(){
        Cijfer cijfer = new Cijfer();
        assertThrows(IllegalArgumentException.class, () -> {
            cijfer.nummerNaarCijfer(-14);
        });
    }
    @Test
    public void fTest(){
        Cijfer cijfer = new Cijfer();
        assertEquals('F', cijfer.nummerNaarCijfer(42));
    }
    @Test
    public void fTest2(){
        Cijfer cijfer = new Cijfer();
        assertEquals('F', cijfer.nummerNaarCijfer(0));
    }
    @Test
    public void dTest(){
        Cijfer cijfer = new Cijfer();
        assertEquals('D', cijfer.nummerNaarCijfer(63));
    }
    @Test
    public void cTest(){
        Cijfer cijfer = new Cijfer();
        assertEquals('C', cijfer.nummerNaarCijfer(74));
    }
    @Test
    public void bTest(){
        Cijfer cijfer = new Cijfer();
        assertEquals('B', cijfer.nummerNaarCijfer(85));
    }
    @Test
    public void aTest(){
        Cijfer cijfer = new Cijfer();
        assertEquals('A', cijfer.nummerNaarCijfer(96));
    }
    @Test
    public void aTest2(){
        Cijfer cijfer = new Cijfer();
        assertEquals('A', cijfer.nummerNaarCijfer(100));
    }
    @Test
    public void hogerDan100Test(){
        Cijfer cijfer = new Cijfer();
        assertThrows(IllegalArgumentException.class, () -> {
            cijfer.nummerNaarCijfer(101);
        });
    }

}