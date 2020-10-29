package kind.support;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooleansTest {

    @Test
    public void testToBoolean(){
        assertFalse(Booleans.toBoolean(-2));
        assertFalse(Booleans.toBoolean(-1));
        assertFalse(Booleans.toBoolean(0));
        assertTrue(Booleans.toBoolean(1));
        assertTrue(Booleans.toBoolean(2));
        assertTrue(Booleans.toBoolean(3));
    }

    @Test
    public void testToggle(){
        assertTrue(Booleans.inverse(false));
        assertFalse(Booleans.inverse(true));
    }

}
