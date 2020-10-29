package kind.support.text;

import kind.support.Nulls;
import kind.support.collections.Arrays;

import java.util.Iterator;

public class Strings {

    /**
     * whitespace
     */
    public static final String SPACE = " ";

    /**
     * tab
     */
    public static final String TAB = "\t";

    /**
     * empty
     */
    public static final String EMPTY = "";

    public static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");

    /**
     * All upper case leters A-Z
     */
    public static final char[] UPPER_LETTERS = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z'
    };

    /**
     * All lower case leters a-z
     */
    public static final char[] LOWER_LETTERS = {
            'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'
    };

    /**
     * All number 0-9
     */
    public static final char[] NUMBERS = {
            '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9'
    };

    private static void validateStringLength(String str, int totalLength, String pad) throws IndexOutOfBoundsException {

        //TODO: Clean up method
        if (str.length() != totalLength) {

            if (str.length() > totalLength) {
                throw new IndexOutOfBoundsException("Cannot pad the string [" + str + "] to a total length of [" + totalLength + "] " + "because it's current length already exceeds the total.");
            }

            if (str.length() + pad.length() > totalLength) {
                throw new IndexOutOfBoundsException("Cannot pad the string [" + str + "] to a total length of [" + totalLength + "] " + "because it's current length plus the padded length would exceed the total.");
            }
        }
    }

    private Strings() {
    }

    /**
     * Removes all the numeric characters in the string.
     * Note spaces are note removed.
     * <pre>
     * removeAlpha("hello world 1") ="hello world "
     * removeAlpha("1323125") =""
     * removeAlpha("34-mk1") ="-mk"
     * </pre>
     *
     * @param str
     * @return new string
     * @throws NullPointerException if str is null
     */
    public static String removeNumeric(String str) {
        return str.replaceAll("[0-9]+", "");
    }

    /**
     * Removes all the alpha characters in the string.
     * Note spaces are note removed.
     * <pre>
     * removeAlpha("hello world 1") ="  1"
     * removeAlpha("1323125") ="1323125"
     * removeAlpha("34-mk1") ="34-1"
     * </pre>
     *
     * @param str
     * @return new string
     * @throws NullPointerException if str is null
     */
    public static String removeAlpha(String str) {
        return str.replaceAll("\\pL+", "");
    }

    /**
     * Returns the string value of the give object if the given <code>String</code>
     * is empty or null.
     * <pre>
     * replaceIfEmpty("original", "new")    ="original"
     * replaceIfEmpty("", "new")            ="new"
     * replaceIfEmpty(null, "new")          ="new"
     * replaceIfEmpty(" ", "new")           =" "
     * replaceIfEmpty("", null)             =null
     * replaceIfEmpty(null, null)           ="null"
     * replaceIfEmpty(null, 1)              ="1"
     * replaceIfEmpty("",  new Double(1.1)) ="1.1"
     * </pre>
     *
     * @param str
     * @param with
     * @return
     * @see Strings.isEmpty(str)
     * @see Strings.valueOf(Object)
     */
    public static synchronized String replaceIfEmpty(String str, Object with) {
        return ((isEmpty(str) ? String.valueOf(with) : str));
    }

    /**
     * Replaces strings with a sub string
     *
     * <pre>
     * replace("frank", "fr", "t")  = "tank"
     * replace("abc", "123", "def") = "abc"
     * replace("", "123", "def")    = ""
     * </pre>
     *
     * @param str
     * @param innerString
     * @param with
     * @return
     */
    public static String replace(String str, String innerString, String with) {
        int c = 0;
        int i = str.indexOf(innerString, c);
        if (i == -1) {
            return str;
        }

        StringBuffer buf = new StringBuffer(str.length() + with.length());

        synchronized (buf) {
            do {
                buf.append(str.substring(c, i));
                buf.append(with);
                c = i + innerString.length();
            } while ((i = str.indexOf(innerString, c)) != -1);

            if (c < str.length()) {
                buf.append(str.substring(c, str.length()));
            }

            return buf.toString();
        }
    }

    /**
     * Returns if the given <code>String</code> contains any digits.
     *
     * @param str nullable string
     * @return True if the given <code>String</code> contains any
     * digits, otherwise false.
     */
    public static boolean containsDigit(String str) {
        if (str == null) {
            return false;
        }

        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns if the given <code>String</code> contains any lower
     * case characters.
     *
     * @param str nullable string
     * @return True if the given <code>String</code> contains any
     * lower case characters, otherwise false.
     */
    public static boolean containsLowerCase(String str) {
        if (str == null) {
            return false;
        }

        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (Character.isLowerCase(aChar)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns if the given <code>String</code> contains any upper
     * case characters.
     *
     * @param str nullable string
     * @return True if the given <code>String</code> contains any
     * upper case characters, otherwise false.
     */
    public static boolean containsUpperCase(String str) {
        if (str == null) {
            return false;
        }

        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns if the given <code>String</code> is empty or null.<br/>
     * Examples...<br/>
     * <pre>
     * isEmpty("Hello") = false
     * isEmpty("")      = true
     * isEmpty(null)    = true
     * isEmpty(" ")     = false
     * </pre>
     *
     * @param str the string to check
     * @return True if the given string is empty or null, otherwise false
     */
    public static boolean isEmpty(String str) {
        return ((str == null) ? true : str.length() == 0);
    }

    /**
     * Pads spaces to the left of a a given String.<br/>
     * Examples...
     * <pre>
     * padLeft("123", 5)    = "  123"
     * padLeft("12345", 5)  = "12345"
     * </pre>
     *
     * @param str         the string to pad
     * @param totalLength the total length of the string to return
     * @return the padded string
     * @throws NullPointerException      if str is null
     * @throws IndexOutOfBoundsException when lenght of text is
     *                                   greater than the total length
     */
    public static String padLeft(String str, int totalLength) throws IndexOutOfBoundsException {
        Nulls.failIfNull(str);
        validateStringLength(str, totalLength, SPACE);

        StringBuilder outputText = new StringBuilder();
        final int lenghtToPad = totalLength - str.length();
        for (int i = 0; i < lenghtToPad; i++) {
            outputText.append(SPACE);
        }

        return outputText.append(str).toString();
    }

    /**
     * Pads the given String with a Char to the left of the String.
     * <br/>
     * Examples...
     * <pre>
     * padLeft("123", 5, "0")   = "00123"
     * padLeft("12345", 5, "x") = "12345"
     * </pre>
     *
     * @param str
     * @param totalLength
     * @param pad
     * @return the paddd string
     * @throws NullPointerException      if str is null
     * @throws IndexOutOfBoundsException when lenght of text is
     *                                   greater than the total length
     */
    public static String padLeft(String str, int totalLength, String pad) {
        Nulls.failIfNull(str);
        validateStringLength(str, totalLength, pad);


        StringBuilder buffer = new StringBuilder(str);
        while (buffer.length() < totalLength) {
            buffer.insert(0, pad);
        }
        return buffer.toString();
    }

    /**
     * Pads or appends spaces to the right of a a given String.
     * Examples...
     * <pre>
     * padLeft("123", 5)    = "123  "
     * padLeft("12345", 5)  = "12345"
     * </pre>
     *
     * @param str         the string to pad
     * @param totalLength the total length of the string to return
     * @return the padded string
     * @throws IndexOutOfBoundsException when lenght of text is
     *                                   greater than the total length
     */
    public static String padRight(String str, int totalLength) throws IndexOutOfBoundsException {
        Nulls.failIfNull(str);
        validateStringLength(str, totalLength, SPACE);

        StringBuilder outputText = new StringBuilder(str);
        final int lenghtToPad = totalLength - str.length();
        for (int i = 0; i < lenghtToPad; i++) {
            outputText.append(SPACE);
        }

        return outputText.toString();
    }

    /**
     * Pads the given String with a Char to the right of the String.
     * <br/>
     * Examples...
     * <pre>
     * padRight("123", 5, "0")      = "12300"
     * padRight("12345", 5, "x")    = "12345"
     * padRight("1", 2, "123")      = throws IndexOutOfBoundsException
     * </pre>
     *
     * @param str
     * @param totalLength
     * @param pad
     * @return the paddd string
     * @throws NullPointerException      if str is null
     * @throws IndexOutOfBoundsException when lenght of text is
     *                                   greater than the total length
     */
    public static String padRight(String str, int totalLength, String pad) {
        Nulls.failIfNull(str);
        validateStringLength(str, totalLength, pad);


        StringBuilder buffer = new StringBuilder(str);
        while (buffer.length() < totalLength) {
            buffer.append(pad);
        }
        return buffer.toString();
    }

    /**
     * Checks if the String contains only unicode letters.
     * Examples...<br/>
     * <pre>
     * Strings.isAlpha(null)    = false
     * Strings.isAlpha("")      = true
     * Strings.isAlpha("  ")    = false
     * Strings.isAlpha("abc")   = true
     * Strings.isAlpha("ab2c")  = false
     * Strings.isAlpha("ab-c")  = false
     * </pre>
     *
     * @param str the String to check, may be null
     * @return <code>true</code> if only contains letters, and is non-null
     */
    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLetter(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the String contains only unicode letters or digits.
     *
     * <pre>
     * Strings.isAlphanumeric(null)   = false
     * Strings.isAlphanumeric("")     = true
     * Strings.isAlphanumeric("  ")   = false
     * Strings.isAlphanumeric("abc")  = true
     * Strings.isAlphanumeric("ab c") = false
     * Strings.isAlphanumeric("ab2c") = true
     * Strings.isAlphanumeric("ab-c") = false
     * </pre>
     *
     * @param str the String to check, may be null
     * @return <code>true</code> if only contains letters or digits,
     * and is non-null, otherwise false
     */
    public static boolean isAlphanumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLetterOrDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the String contains only unicode digits.
     * A decimal point is not a unicode digit and returns false.
     *
     * <pre>
     * Strings.isNumeric(null)   = false
     * Strings.isNumeric("")     = true
     * Strings.isNumeric("  ")   = false
     * Strings.isNumeric("123")  = true
     * Strings.isNumeric("12 3") = false
     * Strings.isNumeric("ab2c") = false
     * Strings.isNumeric("12-3") = false
     * Strings.isNumeric("12.3") = false
     * </pre>
     *
     * @param str the String to check, may be null
     * @return <code>true</code> if only contains digits, and is non-null,
     * otherwise
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the String contains only whitespace.
     *
     * <pre>
     * Strings.isWhitespace(null)   = false
     * Strings.isWhitespace("")     = true
     * Strings.isWhitespace("  ")   = true
     * Strings.isWhitespace("abc")  = false
     * Strings.isWhitespace("ab2c") = false
     * Strings.isWhitespace("ab-c") = false
     * </pre>
     *
     * @param str the String to check, may be null
     * @return <code>true</code> if only contains whitespace, and is non-null
     */
    public static boolean isWhitespace(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the string representation of the <code>char</code> array
     * argument. The contents of the character array are copied; subsequent
     * modification of the character array does not affect the newly
     * created string.
     *
     * @param data a <code>char</code> array.
     * @return a newly allocated string representing the same sequence of
     * characters contained in the character array argument.
     */
    public static String valueOf(char data[]) {
        return new String(data);
    }

    /**
     * Returns the string representation of a specific subarray of the
     * <code>char</code> array argument.
     * <p>
     * The <code>offset</code> argument is the index of the first
     * character of the subarray. The <code>count</code> argument
     * specifies the length of the subarray. The contents of the subarray
     * are copied; subsequent modification of the character array does not
     * affect the newly created string.
     *
     * @param data   the character array.
     * @param offset the initial offset into the value of the
     *               <code>String</code>.
     * @param count  the length of the value of the <code>String</code>.
     * @return a string representing the sequence of characters contained
     * in the subarray of the character array argument.
     * @throws IndexOutOfBoundsException if <code>offset</code> is
     *                                   negative, or <code>count</code> is negative, or
     *                                   <code>offset+count</code> is larger than
     *                                   <code>data.length</code>.
     */
    public static String valueOf(char data[], int offset, int count) {
        return new String(data, offset, count);
    }

    /**
     * Returns a String that represents the character sequence in the
     * array specified.
     *
     * @param data   the character array.
     * @param offset initial offset of the subarray.
     * @param count  length of the subarray.
     * @return a <code>String</code> that contains the characters of the
     * specified subarray of the character array.
     */
    public static String copyValueOf(char data[], int offset, int count) {
        // All public String constructors now copy the data.
        return new String(data, offset, count);
    }

    /**
     * Returns a String that represents the character sequence in the
     * array specified.
     *
     * @param data the character array.
     * @return a <code>String</code> that contains the characters of the
     * character array.
     */
    public static String copyValueOf(char data[]) {
        return copyValueOf(data, 0, data.length);
    }

    /**
     * Returns the string representation of the <code>boolean</code> argument.
     *
     * @param b a <code>boolean</code>.
     * @return if the argument is <code>true</code>, a string equal to
     * <code>"true"</code> is returned; otherwise, a string equal to
     * <code>"false"</code> is returned.
     */
    public static String valueOf(boolean b) {
        return String.valueOf(b);
    }

    /**
     * Returns the string representation of the <code>char</code>
     * argument.
     *
     * @param c a <code>char</code>.
     * @return a string of length <code>1</code> containing
     * as its single character the argument <code>c</code>.
     */
    public static String valueOf(char c) {
        return String.valueOf(c);
    }

    /**
     * Returns the string representation of the <code>int</code> argument.
     * <p>
     * The representation is exactly the one returned by the
     * <code>Integer.toString</code> method of one argument.
     *
     * @param i an <code>int</code>.
     * @return a string representation of the <code>int</code> argument.
     * @see Integer#toString(int, int)
     */
    public static String valueOf(int i) {
        return String.valueOf(i);
    }

    /**
     * Returns the string representation of the <code>long</code> argument.
     * <p>
     * The representation is exactly the one returned by the
     * <code>Long.toString</code> method of one argument.
     *
     * @param l a <code>long</code>.
     * @return a string representation of the <code>long</code> argument.
     * @see Long#toString(long)
     */
    public static String valueOf(long l) {
        return String.valueOf(l);
    }

    /**
     * Returns the string representation of the <code>float</code> argument.
     * <p>
     * The representation is exactly the one returned by the
     * <code>Float.toString</code> method of one argument.
     *
     * @param f a <code>float</code>.
     * @return a string representation of the <code>float</code> argument.
     * @see Float#toString(float)
     */
    public static String valueOf(float f) {
        return String.valueOf(f);
    }

    /**
     * Returns the string representation of the <code>double</code> argument.
     * <p>
     * The representation is exactly the one returned by the
     * <code>Double.toString</code> method of one argument.
     *
     * @param d a <code>double</code>.
     * @return a  string representation of the <code>double</code> argument.
     * @see Double#toString(double)
     */
    public static String valueOf(double d) {
        return String.valueOf(d);
    }

    /**
     * Copies the given <tt>str</tt> to the given <tt>amount</tt>
     * <pre>
     * copy("hello","|" 2) ="hello|hello"
     * copy("1",",",5)      ="1,1,1,1"
     * copy(null,"", 3)    ="nullnullnull"
     * </pre>
     *
     * @param str
     * @param delimiter
     * @param amount
     * @return
     */
    public static String copy(String str, String delimiter, int amount) {
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < amount; i++) {
            buffer.append(str);

            if (i < amount - 1) {
                buffer.append(delimiter);
            }
        }
        return buffer.toString();

    }

    /**
     * Copies the given <tt>str</tt> to the given <tt>amount</tt>
     * <pre>
     * copy("hello", 2) ="hellohello"
     * copy("1",5)      ="1111"
     * copy(null, 3)    ="nullnullnull"
     * </pre>
     *
     * @param str
     * @param amount
     * @return
     */
    public static String copy(String str, int amount) {
        return copy(str, "", amount);
    }

    /**
     * Converts all of the characters in this <code>String</code> to upper
     * case using the rules of the default locale. This method is equivalent to
     * <code>toUpperCase(Locale.getDefault())</code>.
     * <p>
     * <b>Note:</b> This method is locale sensitive, and may produce unexpected
     * results if used for strings that are intended to be interpreted locale
     * independently.
     * Examples are programming language identifiers, protocol keys, and HTML
     * tags.
     * For instance, <code>"title".toUpperCase()</code> in a Turkish locale
     * returns <code>"T\u0130TLE"</code>, where '\u0130' is the LATIN CAPITAL
     * LETTER I WITH DOT ABOVE character.
     * To obtain correct results for locale insensitive strings, use
     * <code>toUpperCase(Locale.ENGLISH)</code>.
     * <p>
     *
     * @param str
     * @return the <code>String</code>, converted to uppercase.
     */
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    /**
     * Converts only the index of a character in this <code>String</code> to upper
     * case using the rules of the default locale. This method is equivalent to
     * <code>toUpperCase(Locale.getDefault())</code>.
     * <p>
     * <b>Note:</b> This method is locale sensitive, and may produce unexpected
     * results if used for strings that are intended to be interpreted locale
     * independently.
     * Examples are programming language identifiers, protocol keys, and HTML
     * tags.
     * For instance, <code>"title".toUpperCase()</code> in a Turkish locale
     * returns <code>"T\u0130TLE"</code>, where '\u0130' is the LATIN CAPITAL
     * LETTER I WITH DOT ABOVE character.
     * To obtain correct results for locale insensitive strings, use
     * <code>toUpperCase(Locale.ENGLISH)</code>.
     * <p>
     *
     * @param str
     * @param charIndex the index to make upper
     * @return the <code>String</code>, converted to uppercase.
     * @throws IndexOutOfBoundsException if charIndex is outside the bounds
     */
    public static String toUpperCase(String str, int charIndex) {
        char[] chars = str.toCharArray();
        chars[charIndex] = Character.toUpperCase(chars[charIndex]);
        return Strings.valueOf(chars);
    }

    /**
     * Returns the string representation of the <code>Object</code> argument.
     *
     * @param obj an <code>Object</code>.
     * @return if the argument is <code>null</code>, then a string equal to
     * <code>"null"</code>; otherwise, the value of
     * <code>obj.toString()</code> is returned.
     * @see Object#toString()
     */
    public static String valueOf(Object obj) {
        return String.valueOf(obj);
    }

    public static String[] substrings(String str, String delimiters) {
        return str.split(delimiters);
    }

    /**
     * Compares two {@code String} to each another {@code String}, ignoring case
     * considerations.  Two strings are considered equal ignoring case if they
     * are of the same length and corresponding characters in the two strings
     * are equal ignoring case.
     *
     * <p> Two characters {@code str1} and {@code str2} are considered the same
     * ignoring case if at least one of the following is true:
     * <ul>
     *   <li> The two characters are the same (as compared by the
     *        {@code ==} operator)
     *   <li> Applying the method {@link
     *        Character#toUpperCase(char)} to each character
     *        produces the same result
     *   <li> Applying the method {@link
     *        Character#toLowerCase(char)} to each character
     *        produces the same result
     * </ul>
     *
     * @param str1 nullable
     * @param str2 nullable
     * @return {@code true} if both arguments are {@code null} or if both {@code String} are equivalent ignoring case; otherwise {@code false}
     */
    public static synchronized boolean equalsIgnoreCase(String str1, String str2) {
        return ((str1 == null && str2 == null) ? true : (str1 == null || str2 == null) ? false : str1.equalsIgnoreCase(str2));
    }

    /**
     * Returns a random {@code String} with the given length.  The returned {@code String} will contain lower and upper
     * case characters as well as numbers.
     *
     * @param length
     * @return
     */
    public static synchronized String random(int length) {

        char[] letters = Arrays.concat(LOWER_LETTERS, UPPER_LETTERS);
        char[] lettersAndNumbers = Arrays.concat(letters, NUMBERS);

        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            buffer.append(Arrays.random(lettersAndNumbers));
        }

        return buffer.toString();
    }

    /**
     * Returns {@code true} if the given {@code String} is {@code null} or has a lenght of zero, {@code false} otherwise.
     *
     * @param ref nullable
     * @return {@code true} if the given {@code String} is {@code null} or has a lenght of zero, {@code false} otherwise.
     */
    public static boolean isEmptyOrNull(String ref) {
        return ((ref == null) ? true : ref.length() == 0);

    }

    /**
     * <p>Gets the substring before the first occurrence of a separator.
     * The separator is not returned.</p>
     *
     * <p>A <code>null</code> string input will return <code>null</code>.
     * An empty ("") string input will return the empty string.
     * A <code>null</code> separator will return the input string.</p>
     *
     * <pre>
     * StringUtils.substringBefore(null, *)      = null
     * StringUtils.substringBefore("", *)        = ""
     * StringUtils.substringBefore("abc", "a")   = ""
     * StringUtils.substringBefore("abcba", "b") = "a"
     * StringUtils.substringBefore("abc", "c")   = "ab"
     * StringUtils.substringBefore("abc", "d")   = "abc"
     * StringUtils.substringBefore("abc", "")    = ""
     * StringUtils.substringBefore("abc", null)  = "abc"
     * </pre>
     *
     * @param str       the String to get a substring from, may be null
     * @param separator the String to search for, may be null
     * @return the substring before the first occurrence of the separator,
     * <code>null</code> if null String input
     */
    public static String substringBefore(String str, String separator) {
        if (isEmpty(str) || separator == null) {
            return str;
        }
        if (separator.length() == 0) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
     * <p>Gets the substring before the last occurrence of a separator.
     * The separator is not returned.</p>
     *
     * <p>A <code>null</code> string input will return <code>null</code>.
     * An empty ("") string input will return the empty string.
     * An empty or <code>null</code> separator will return the input string.</p>
     *
     * <pre>
     * StringUtils.substringBeforeLast(null, *)      = null
     * StringUtils.substringBeforeLast("", *)        = ""
     * StringUtils.substringBeforeLast("abcba", "b") = "abc"
     * StringUtils.substringBeforeLast("abc", "c")   = "ab"
     * StringUtils.substringBeforeLast("a", "a")     = ""
     * StringUtils.substringBeforeLast("a", "z")     = "a"
     * StringUtils.substringBeforeLast("a", null)    = "a"
     * StringUtils.substringBeforeLast("a", "")      = "a"
     * </pre>
     *
     * @param str       the String to get a substring from, may be null
     * @param separator the String to search for, may be null
     * @return the substring before the last occurrence of the separator,
     * <code>null</code> if null String input
     */
    public static String substringBeforeLast(String str, String separator) {
        if (isEmpty(str) || isEmpty(separator)) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
     * <p>Gets the substring after the last occurrence of a separator.
     * The separator is not returned.</p>
     *
     * <p>A <code>null</code> string input will return <code>null</code>.
     * An empty ("") string input will return the empty string.
     * An empty or <code>null</code> separator will return the empty string if
     * the input string is not <code>null</code>.</p>
     *
     * <pre>
     * StringUtils.substringAfterLast(null, *)      = null
     * StringUtils.substringAfterLast("", *)        = ""
     * StringUtils.substringAfterLast(*, "")        = ""
     * StringUtils.substringAfterLast(*, null)      = ""
     * StringUtils.substringAfterLast("abc", "a")   = "bc"
     * StringUtils.substringAfterLast("abcba", "b") = "a"
     * StringUtils.substringAfterLast("abc", "c")   = ""
     * StringUtils.substringAfterLast("a", "a")     = ""
     * StringUtils.substringAfterLast("a", "z")     = ""
     * </pre>
     *
     * @param str       the String to get a substring from, may be null
     * @param separator the String to search for, may be null
     * @return the substring after the last occurrence of the separator,
     * <code>null</code> if null String input
     */
    public static String substringAfterLast(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(separator)) {
            return EMPTY;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1 || pos == (str.length() - separator.length())) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
     * <p>Gets the substring after the first occurrence of a separator.
     * The separator is not returned.</p>
     *
     * <p>A <code>null</code> string input will return <code>null</code>.
     * An empty ("") string input will return the empty string.
     * A <code>null</code> separator will return the empty string if the
     * input string is not <code>null</code>.</p>
     *
     * <pre>
     * StringUtils.substringAfter(null, *)      = null
     * StringUtils.substringAfter("", *)        = ""
     * StringUtils.substringAfter(*, null)      = ""
     * StringUtils.substringAfter("abc", "a")   = "bc"
     * StringUtils.substringAfter("abcba", "b") = "cba"
     * StringUtils.substringAfter("abc", "c")   = ""
     * StringUtils.substringAfter("abc", "d")   = ""
     * StringUtils.substringAfter("abc", "")    = "abc"
     * </pre>
     *
     * @param str       the String to get a substring from, may be null
     * @param separator the String to search for, may be null
     * @return the substring after the first occurrence of the separator,
     * <code>null</code> if null String input
     */
    public static String substringAfter(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (separator == null) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
     * <p>Gets the String that is nested in between two Strings.
     * Only the first match is returned.</p>
     *
     * <p>A <code>null</code> input String returns <code>null</code>.
     * A <code>null</code> open/close returns <code>null</code> (no match).
     * An empty ("") open and close returns an empty string.</p>
     *
     * <pre>
     * StringUtils.substringBetween("wx[b]yz", "[", "]") = "b"
     * StringUtils.substringBetween(null, *, *)          = null
     * StringUtils.substringBetween(*, null, *)          = null
     * StringUtils.substringBetween(*, *, null)          = null
     * StringUtils.substringBetween("", "", "")          = ""
     * StringUtils.substringBetween("", "", "]")         = null
     * StringUtils.substringBetween("", "[", "]")        = null
     * StringUtils.substringBetween("yabcz", "", "")     = ""
     * StringUtils.substringBetween("yabcz", "y", "z")   = "abc"
     * StringUtils.substringBetween("yabczyabcz", "y", "z")   = "abc"
     * </pre>
     *
     * @param str   the String containing the substring, may be null
     * @param open  the String before the substring, may be null
     * @param close the String after the substring, may be null
     * @return the substring, <code>null</code> if no match
     */
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    /**
     * Builds a new {@code String} from the given args. Uses the
     * tokenizer of '%s' to replace the {@code str} with the {@code parameter}.
     * <table border="1">
     * <tr>
     * <td><b>input</b></td><td><b>returns</b></td>
     * </tr>
     * <tr><td>Strings.of("Hello %s", "World")</td><td>"Hello World"</td></tr>
     * <tr><td>Strings.of("Hello %s and %s", "Foo", "Bar")</td><td>"Hello Foo and Bar"</td></tr>
     * <tr><td>Strings.of("Hello")</td><td>"Hello"</td></tr>
     * <tr><td>Strings.of("%s, %s, %s", "a", "b")</td><td>"a, b"</td></tr>
     * </table>
     *
     * @param str
     * @param parameters
     * @return
     */
    public static synchronized String of(String str, Object... parameters) {

        Iterator<Object> pars = Arrays.toIterator(parameters);

        while (str.contains("%s") && pars.hasNext()) {
            str = str.replaceFirst("%s", Strings.valueOf(pars.next()));
        }

        return str;
    }

    public static String quote(Object val){
        return String.format("%s%s%s", "\"", valueOf(val), "\"");
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.  If the given {@code String} is {@code null} a {@code null} is returned
     * <p>
     * If this <code>String</code> object represents an empty character
     * sequence, or the first and last characters of character sequence
     * represented by this <code>String</code> object both have codes
     * greater than <code>'&#92;u0020'</code> (the space character), then a
     * reference to this <code>String</code> object is returned.
     * <p>
     * Otherwise, if there is no character with a code greater than
     * <code>'&#92;u0020'</code> in the string, then a new
     * <code>String</code> object representing an empty string is created
     * and returned.
     * <p>
     * Otherwise, let <i>k</i> be the index of the first character in the
     * string whose code is greater than <code>'&#92;u0020'</code>, and let
     * <i>m</i> be the index of the last character in the string whose code
     * is greater than <code>'&#92;u0020'</code>. A new <code>String</code>
     * object is created, representing the substring of this string that
     * begins with the character at index <i>k</i> and ends with the
     * character at index <i>m</i>-that is, the result of
     * <code>this.substring(<i>k</i>,&nbsp;<i>m</i>+1)</code>.
     * <p>
     * This method may be used to trim whitespace (as defined above) from
     * the beginning and end of a string.
     *
     * @param str nullable
     * @return A copy of this string with leading and trailing white
     * space removed, or this string if it has no leading or
     * trailing white space.
     */
    public static synchronized String trim(String str) {
        return ((str == null) ? null : str.trim());
    }
}
