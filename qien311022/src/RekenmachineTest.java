import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RekenmachineTest {

    @Test
    public void optellenTest1(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(4, r.optellen(2,2));
    }
    @Test
    public void optellenTest2(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(7, r.optellen(3,4));
    }

    @Test
    public void aftrekkenTest1(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(4, r.aftrekken(6,2));
    }
    @Test
    public void aftrekkenTest2(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(0, r.aftrekken(2,2));
    }

    @Test
    public void vermenigvuldigenTest1(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(4, r.vermenigvuldigen(2,2));
    }
    @Test
    public void vermenigvuldigenTest2(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(27, r.vermenigvuldigen(9,3));
    }

    @Test
    public void totDeMachtTest1(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(27.0, r.totDeMacht(3.0,3.0));
    }
    @Test
    public void totDeMachtTest2(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(0.2, r.totDeMacht(5.0,-1.0));
    }

    @Test
    public void wortelTest1(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(9.0, r.wortel(81.0));
    }
    @Test
    public void wortelTest2(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(Double.POSITIVE_INFINITY, r.wortel(-6.0));
    }

    @Test
    public void delenTest1(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(6.0, r.delen(30.0, 5.0));
    }
    @Test
    public void delenTest2(){
        Rekenmachine r = new Rekenmachine();
        assertEquals(Double.NaN, r.delen(0,0));

    }

}