package kind.support;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static kind.support.Coalesce.*;

class CoalesceTest {

    @Test
    public void test_Coalesce() {
        assertTrue(coalesce(null, null, true));
        assertEquals("foo", coalesce("foo", "bar", null));
        assertEquals("bar", coalesce(null, "bar", null));
    }

}