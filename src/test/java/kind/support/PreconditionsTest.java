/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kind.support;

import org.junit.Test;
import static org.junit.Assert.*;
import static kind.support.Preconditions.*;

/**
 *
 * @author mlee
 */
public class PreconditionsTest {

    public void testAssertNotEmptyString_string() {
        try{
            kind.support.Preconditions.assertNotEmpty("1");
            kind.support.Preconditions.assertNotEmpty(" "); //<--non empty
            kind.support.Preconditions.assertNotEmpty(" asdf ");
            kind.support.Preconditions.assertNotEmpty("_");
        }catch(Exception ex){
            fail("Should of passed but was" + ex.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAssertNotEmptyString_string_OnNull() {
        kind.support.Preconditions.assertNotEmpty(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAssertNotEmptyString_string_OnEmptyString() {
        kind.support.Preconditions.assertNotEmpty("");
    }

    @Test
    public void testAssertNotEmptyString_string_string() {
        try {
            kind.support.Preconditions.assertNotEmpty("foo", "");
            fail("should have failed");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("foo"));
        }
    }

    @Test
    public void testChecArgumentWithMessage_false() {
        final String message = "my message!";
        try {
            assertArgument(1 == 2, message);
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains(message));
        }
    }

    @Test()
    public void testChecArgument_true() {
        kind.support.Preconditions.assertArgument(1 == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChecArgument_false() {
        kind.support.Preconditions.assertArgument(1 == 2);
    }

    @Test
    public void testCheckStateWithMessage() {
        final String message = "Your state is invalid!!";
        try {
            kind.support.Preconditions.assertState(false, message);
        } catch (IllegalStateException ex) {
            assertTrue(ex.getMessage().contains(message));
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testCheckState_false() {
        kind.support.Preconditions.assertState(1 == 2);
    }

    @Test(expected = NullPointerException.class)
    public void testCheckNotNull_false() {
        kind.support.Preconditions.assertNotNull(null);
    }

    @Test
    public void testCheckNotNullWithMessage() {
        final String message = "Your object is null!!";

        try {
            kind.support.Preconditions.assertNotNull(null, message);
        } catch (NullPointerException ex) {
            assertTrue(ex.getMessage().contains(message));
        }
    }

    @Test
    public void testCheckNotNullWhenNot() {
        String subject = "test";
        assertEquals("test", kind.support.Preconditions.assertNotNull(subject));
    }

    public void testthis() {
    }
}
