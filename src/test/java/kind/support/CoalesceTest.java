package kind.support;

import org.junit.Test;
import static org.junit.Assert.*;
import static kind.support.Coalesce.*;

public class CoalesceTest {

    @Test
    public void test_Coalesce() {
        final String one, two, three;
        one = null; two = null; three = "world!";
        System.out.println("Hello " + coalesce(one, two, three));


        assertTrue(coalesce(null, null, true));
        assertEquals("foo", coalesce("foo", "bar", null));
        assertEquals("bar", coalesce(null, "bar", null));
    }

}