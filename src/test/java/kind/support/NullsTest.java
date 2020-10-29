package kind.support;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NullsTest {

    public void testFailIfNullWithMessage() {
        final String message = "This is a message!";
        try {
            Nulls.failIfNull(null, message);
        } catch (NullPointerException ex) {
            assertTrue(ex.getMessage().contains(message));
        }
    }

    @Test
    public void testFailIfNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Nulls.failIfNull(null);
        });
    }

    @Test
    public void testFailIfNullWhenNot() {
        Nulls.failIfNull("Hello");
    }

    @Test
    public void testReplace() {
        Nulls.replaceIfNull(null, "Hello");
    }
}
