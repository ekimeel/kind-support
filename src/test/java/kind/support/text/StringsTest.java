package kind.support.text;


import kind.support.Timer;
import kind.support.collections.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael J. Lee @ Synergy Energy Holdings, LLC
 */
public class StringsTest {

    public void testTrim_string(){
        assertEquals("", Strings.trim("    "));
        assertEquals("123", Strings.trim(" 123   "));
        assertEquals(null, Strings.trim(null));
        assertEquals("1 b c", Strings.trim("1 b c"));
    }

//    @Test(expected=NullPointerException.class)
//    public void testOf_null_null() {
//         Strings.of(null, null);
//    }

    @Test
    public void testOf_string_WrongTokenizer() {
        final String expOut = "Hello %d";
        assertEquals(expOut, Strings.of("Hello %d", "Mike", "Ryan", "Derek"));
    }

    @Test
    public void testOf_string_GreaterParameters() {
        final String expOut = "Hello Mike";
        assertEquals(expOut, Strings.of("Hello %s", "Mike", "Ryan", "Derek"));
    }

    @Test
    public void testOf_string_LessParameters() {
        final String expOut = "Hello Mike and %s";

        assertEquals(expOut, Strings.of("Hello %s and %s", "Mike"));
    }

    @Test
    public void testOf_string() {
        final String expOut = "Hello";

        assertEquals(expOut, Strings.of("Hello"));
    }

    @Test
    public void testOf_string_10parameters() {
        final String expOut = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";

        assertEquals(expOut, Strings.of("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    }

    @Test
    public void testOf_string_2parameters() {
        final String expOut = "Hello Mike how is your testing going?";

        assertEquals(expOut, Strings.of("Hello %s how is your %s going?", "Mike", "testing"));
    }

    @Test
    public void testOf_string_1parameters() {
        final String expOut = "Hello World.";

        assertEquals(expOut, Strings.of("Hello %s.", "World"));
    }

    @Test
    public void testSubstringBetween() {
        assertEquals(null, Strings.substringBetween(null, "", ""));
        assertEquals("", Strings.substringBetween("", "", ""));
        assertEquals("", Strings.substringBetween("foo", "", ""));
        assertEquals(null, Strings.substringBetween("foo", "", "]"));
        assertEquals(null, Strings.substringBetween("foo", "[", "]"));
        assertEquals("", Strings.substringBetween("    ", " ", "  "));
        assertEquals("bar", Strings.substringBetween("<foo>bar</foo>", "<foo>", "</foo>"));
    }

    @Test
    public void testSubstringAfterLast() {
        assertEquals("baz", Strings.substringAfterLast("fooXXbarXXbaz", "XX"));

        assertEquals(null, Strings.substringAfterLast(null, null));
        assertEquals(null, Strings.substringAfterLast(null, ""));
        assertEquals(null, Strings.substringAfterLast(null, "XX"));
        assertEquals("", Strings.substringAfterLast("", null));
        assertEquals("", Strings.substringAfterLast("", ""));
        assertEquals("", Strings.substringAfterLast("", "a"));

        assertEquals("", Strings.substringAfterLast("foo", null));
        assertEquals("", Strings.substringAfterLast("foo", "b"));
        assertEquals("t", Strings.substringAfterLast("foot", "o"));
        assertEquals("bc", Strings.substringAfterLast("abc", "a"));
        assertEquals("a", Strings.substringAfterLast("abcba", "b"));
        assertEquals("", Strings.substringAfterLast("abc", "c"));
        assertEquals("", Strings.substringAfterLast("", "d"));
        assertEquals("", Strings.substringAfterLast("abc", ""));
    }

    @Test
    public void testSubstringBeforeLast() {
        assertEquals("fooXXbar", Strings.substringBeforeLast("fooXXbarXXbaz", "XX"));

        assertEquals(null, Strings.substringBeforeLast(null, null));
        assertEquals(null, Strings.substringBeforeLast(null, ""));
        assertEquals(null, Strings.substringBeforeLast(null, "XX"));
        assertEquals("", Strings.substringBeforeLast("", null));
        assertEquals("", Strings.substringBeforeLast("", ""));
        assertEquals("", Strings.substringBeforeLast("", "XX"));

        assertEquals("foo", Strings.substringBeforeLast("foo", null));
        assertEquals("foo", Strings.substringBeforeLast("foo", "b"));
        assertEquals("fo", Strings.substringBeforeLast("foo", "o"));
        assertEquals("abc\r\n", Strings.substringBeforeLast("abc\r\n", "d"));
        assertEquals("abc", Strings.substringBeforeLast("abcdabc", "d"));
        assertEquals("abcdabc", Strings.substringBeforeLast("abcdabcd", "d"));
        assertEquals("a", Strings.substringBeforeLast("abc", "b"));
        assertEquals("abc ", Strings.substringBeforeLast("abc \n", "\n"));
        assertEquals("a", Strings.substringBeforeLast("a", null));
        assertEquals("a", Strings.substringBeforeLast("a", ""));
        assertEquals("", Strings.substringBeforeLast("a", "a"));
    }

    @Test
    public void testSubstringBefore() {
        assertEquals("foo", Strings.substringBefore("fooXXbarXXbaz", "XX"));

        assertEquals(null, Strings.substringBefore(null, null));
        assertEquals(null, Strings.substringBefore(null, ""));
        assertEquals(null, Strings.substringBefore(null, "XX"));
        assertEquals("", Strings.substringBefore("", null));
        assertEquals("", Strings.substringBefore("", ""));
        assertEquals("", Strings.substringBefore("", "XX"));

        assertEquals("foo", Strings.substringBefore("foo", null));
        assertEquals("foo", Strings.substringBefore("foo", "b"));
        assertEquals("f", Strings.substringBefore("foot", "o"));
        assertEquals("", Strings.substringBefore("abc", "a"));
        assertEquals("a", Strings.substringBefore("abcba", "b"));
        assertEquals("ab", Strings.substringBefore("abc", "c"));
        assertEquals("", Strings.substringBefore("abc", ""));
    }

    @Test
    public void testSubstringAfter() {
        assertEquals("barXXbaz", Strings.substringAfter("fooXXbarXXbaz", "XX"));

        assertEquals(null, Strings.substringAfter(null, null));
        assertEquals(null, Strings.substringAfter(null, ""));
        assertEquals(null, Strings.substringAfter(null, "XX"));
        assertEquals("", Strings.substringAfter("", null));
        assertEquals("", Strings.substringAfter("", ""));
        assertEquals("", Strings.substringAfter("", "XX"));

        assertEquals("", Strings.substringAfter("foo", null));
        assertEquals("ot", Strings.substringAfter("foot", "o"));
        assertEquals("bc", Strings.substringAfter("abc", "a"));
        assertEquals("cba", Strings.substringAfter("abcba", "b"));
        assertEquals("", Strings.substringAfter("abc", "c"));
        assertEquals("abc", Strings.substringAfter("abc", ""));
        assertEquals("", Strings.substringAfter("abc", "d"));
    }

    @Test
    public void testEmpty() {
        assertEquals("", Strings.EMPTY);
    }

    @Test
    public void testIsEmptyOrNull() {
        assertTrue(Strings.isEmptyOrNull(null));
        assertTrue(Strings.isEmptyOrNull(""));

        assertFalse(Strings.isEmptyOrNull(" ")); //<-- one space is not empty
        assertFalse(Strings.isEmptyOrNull("hello world")); //<-- one space is not empty
    }

    @Test
    public void testRandom() {
        assertTrue(Strings.random(10).length() == 10);
        assertFalse(Strings.random(10).equals(Strings.random(10)));
    }

    @Test
    public void testEqualsIgnoreCase() {
        assertTrue(Strings.equalsIgnoreCase("1", "1"));
        assertTrue(Strings.equalsIgnoreCase("joe", "JOE"));
        assertTrue(Strings.equalsIgnoreCase("DUKE", "DUKE"));
        assertTrue(Strings.equalsIgnoreCase(null, null));
        assertTrue(Strings.equalsIgnoreCase("HeLLO wOrld", "hello world"));

        assertFalse(Strings.equalsIgnoreCase("DUKE", "DUK E"));
        assertFalse(Strings.equalsIgnoreCase("DUKE", "DUK4"));
        assertFalse(Strings.equalsIgnoreCase("DUKE", null));
        assertFalse(Strings.equalsIgnoreCase(null, "hello"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testToUpperWithIndexOutOfBounds() {
        assertEquals("helLo", Strings.toUpperCase("hello", -3));
    }

    @Test
    public void testToUpperWithIndex() {
        assertEquals("Hello", Strings.toUpperCase("hello", 0));
        assertEquals("helLo", Strings.toUpperCase("hello", 3));

    }

    @Test
    public void testToUpper() {
        assertEquals("HELLO", Strings.toUpperCase("hello"));

    }

    @Test
    public void testCopyWithDelimiter() {
        assertEquals("hello|hello", Strings.copy("hello", "|", 2));
        assertEquals("nullnull", Strings.copy(null, "", 2));
        assertEquals("1  1  1  1  1", Strings.copy("1", "  ", 5));
    }

    @Test
    public void testCopy() {
        assertEquals("hellohello", Strings.copy("hello", 2));
        assertEquals("nullnull", Strings.copy(null, 2));
        assertEquals("11111", Strings.copy("1", 5));
    }

    @Test
    public void testUpperLetters() {
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'A'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'B'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'C'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'D'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'E'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'F'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'G'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'H'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'I'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'J'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'K'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'L'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'M'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'N'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'O'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'P'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'Q'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'R'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'S'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'T'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'U'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'V'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'W'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'X'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'Y'));
        assertTrue(Arrays.contains(Strings.UPPER_LETTERS, 'Z'));

    }

    @Test
    public void testReplaceIfEmpty() {
        assertEquals("original", Strings.replaceIfEmpty("original", "new"));
        assertEquals(" ", Strings.replaceIfEmpty(" ", "new"));
        assertEquals("new", Strings.replaceIfEmpty("", "new"));
        assertEquals("new", Strings.replaceIfEmpty(null, "new"));
        assertEquals("null", Strings.replaceIfEmpty(null, null));
        assertEquals("1", Strings.replaceIfEmpty(null, 1));
        assertEquals("1.1", Strings.replaceIfEmpty(null, new Double(1.1)));


    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNumericWhenGivenNull() {
        Strings.removeNumeric(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveAlphaWhenGivenNull() {
        Strings.removeAlpha(null);
    }

    @Test
    public void testRemoveNumeric() {
        assertEquals("abc", Strings.removeNumeric("abc123"));
        assertEquals("hello world", Strings.removeNumeric("hello world1"));
        assertEquals("hello world", Strings.removeNumeric("hello world"));
        assertEquals("-mk", Strings.removeNumeric("34-mk1"));

    }

    @Test
    public void testRemoveAlpha() {
        assertEquals("123", Strings.removeAlpha("abc123"));
        assertEquals(" 1", Strings.removeAlpha("hello world1"));
        assertEquals(" ", Strings.removeAlpha("hello world"));
        assertEquals("34-1", Strings.removeAlpha("34-mk1"));

    }

    @Test
    public void testReplace() {
        assertEquals("tank", Strings.replace("frank", "fr", "t"));
        assertEquals("fran1", Strings.replace("frank", "k", "1"));
        assertEquals("", Strings.replace("", "k", "1"));
        assertEquals("123", Strings.replace("123", "abc", "456"));
    }


    @Test
    public void testContainsDigits() {
        assertTrue(Strings.containsDigit("Hello1"));
        assertTrue(Strings.containsDigit("HELLO 1oRLD"));
        assertFalse(Strings.containsDigit(""));
        assertTrue(Strings.containsDigit("1"));
        assertFalse(Strings.containsDigit(null));
    }

    @Test
    public void testContainsLowerCase() {
        assertTrue(Strings.containsLowerCase("Hello"));
        assertTrue(Strings.containsLowerCase("HELLO WoRLD"));
        assertFalse(Strings.containsLowerCase(""));
        assertTrue(Strings.containsLowerCase("jo"));
        assertFalse(Strings.containsDigit(null));
    }

    @Test
    public void testContainsUpperCase() {
        assertTrue(Strings.containsUpperCase("Hello"));
        assertTrue(Strings.containsUpperCase("STRING"));
        assertTrue(Strings.containsUpperCase("hello woRld"));
        assertFalse(Strings.containsUpperCase(""));
        assertFalse(Strings.containsUpperCase("jo"));
        assertFalse(Strings.containsDigit(null));
    }

    @Test
    public void testTab() {
        assertEquals("\t", Strings.TAB);
    }

    @Test
    public void testSpace() {
        assertEquals(" ", Strings.SPACE);
    }

    @Test
    public void testPadLeftWithAChar() {
        assertEquals("001234", Strings.padLeft("1234", 6, "0"));
        assertEquals("1234", Strings.padLeft("1234", 4, "0"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPadLeftWithAStringThatWouldExceedTheTotal() {
        Strings.padLeft("1234", 6, "Hello");//Adding 'Hello' would exceed 6
    }

    @Test
    public void testIsWhitespace() {
        assertFalse(Strings.isWhitespace(null));
        assertTrue(Strings.isWhitespace(""));
        assertTrue(Strings.isWhitespace(" "));
        assertFalse(Strings.isWhitespace("123"));
        assertFalse(Strings.isWhitespace("12 3"));
        assertFalse(Strings.isWhitespace("12-3"));
        assertFalse(Strings.isWhitespace("12.3"));
        assertFalse(Strings.isWhitespace("abc"));
    }

    @Test
    public void testIsNumeric() {
        assertFalse(Strings.isNumeric(null));
        assertTrue(Strings.isNumeric(""));
        assertFalse(Strings.isNumeric(" "));
        assertTrue(Strings.isNumeric("123"));
        assertFalse(Strings.isNumeric("12 3"));
        assertFalse(Strings.isNumeric("12-3"));
        assertFalse(Strings.isNumeric("12.3"));
    }

    @Test
    public void testIsAlphanumeric() {
        assertFalse(Strings.isAlphanumeric(null));
        assertTrue(Strings.isAlphanumeric(""));
        assertFalse(Strings.isAlphanumeric(" "));
        assertTrue(Strings.isAlphanumeric("abc"));
        assertTrue(Strings.isAlphanumeric("ab2c"));
        assertFalse(Strings.isAlphanumeric("ab2-c"));
    }

    @Test
    public void testIsAlpha() {
        assertFalse(Strings.isAlpha(null));
        assertTrue(Strings.isAlpha(""));
        assertFalse(Strings.isAlpha(" "));
        assertTrue(Strings.isAlpha("abc"));
        assertFalse(Strings.isAlpha("ab2c"));
        assertFalse(Strings.isAlpha("ab2-c"));
    }

    @Test
    public void testIsEmpty() {

        assertTrue(Strings.isEmpty(""));
        assertFalse(Strings.isEmpty("1"));
        assertFalse(Strings.isEmpty(" "));

    }

    @Test
    public void testIsEmptyOnANull() {
        assertTrue(Strings.isEmpty(null));
    }

    @Test
    public void testPadLeft() {

        assertEquals("       123", Strings.padLeft("123", 10));
        assertEquals(" 123", Strings.padLeft("123", 4));
        assertEquals("123", Strings.padLeft("123", 3));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPadLeftWhenGivenStringIsLongerThanMaxLenght() {
        Strings.padLeft("123", 2);
    }

    @Test
    public void testPadRight() {

        assertEquals("123       ", Strings.padRight("123", 10));
        assertEquals("123 ", Strings.padRight("123", 4));
        assertEquals("123", Strings.padRight("123", 3));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPadRightWhenGivenStringIsLongerThanMaxLenght() {
        Strings.padRight("123", 2);
    }


}
