package kind.support;

import kind.support.collections.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumbersTest {


    @Test
    public void testRandomWithExclusions(){

        int[] usedNumbers = new int[100];
        for(int i = 0; i < 100; i++){
            usedNumbers[i] = Numbers.random(1, 100, usedNumbers);
        }

        assertTrue(usedNumbers.length == 100);

        for(int i = 1; i <= 100; i++){
            assertTrue(i + "was not found!", Arrays.contains(usedNumbers, i)); //checks to make sure that all randoms where accounted for
        }

    }

    @Test
    public void testRandomWithMinAndMax(){
        assertTrue(Numbers.random(0,1) < 2);
        assertTrue(Numbers.random(0,1) > -1);
        assertTrue(Numbers.random(-100,0) < 0);
    }



    @Test
    public void testIsOdd() {
        assertTrue(Numbers.isOdd(-1));
        assertFalse(Numbers.isOdd(0));
        assertTrue(Numbers.isOdd(1));
        assertFalse(Numbers.isOdd(2));
        assertTrue(Numbers.isOdd(3));
        assertFalse(Numbers.isOdd(4));
        assertTrue(Numbers.isOdd(5));
        assertFalse(Numbers.isOdd(6));
        assertTrue(Numbers.isOdd(7));
        assertFalse(Numbers.isOdd(8));
        assertTrue(Numbers.isOdd(9));
    }

    @Test
    public void testIsEven() {
        assertFalse(Numbers.isEven(-1));
        assertTrue(Numbers.isEven(0));
        assertFalse(Numbers.isEven(1));
        assertTrue(Numbers.isEven(2));
        assertFalse(Numbers.isEven(3));
        assertTrue(Numbers.isEven(4));
        assertFalse(Numbers.isEven(5));
        assertTrue(Numbers.isEven(6));
        assertFalse(Numbers.isEven(7));
        assertTrue(Numbers.isEven(8));
        assertFalse(Numbers.isEven(9));
    }
}
