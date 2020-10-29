package kind.support.collections;

import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael J. Lee @ Synergy Energy Holdings, LLC
 */
public class ArraysTest {

    @Test(expected = NullPointerException.class)
    public void testInvert_array_WithNulls() {
        Arrays.invert(null);
    }

    @Test
    public void testInvert_array_WithStrings() {
        String[] str = {"1", "2", "3", "4", "5"};
        String[] strInverted = Arrays.invert(str);
        assertEquals("5", strInverted[0]);
        assertEquals("4", strInverted[1]);
        assertEquals("3", strInverted[2]);
        assertEquals("2", strInverted[3]);
        assertEquals("1", strInverted[4]);
        assertNotSame(str, strInverted);
    }

    @Test
    public void testToIterator_ints() {
        int[] ins = {1, 2, 3, 4};
        Iterator iterator = Arrays.toIterator(ins);
        assertNotNull(iterator);

        Integer[] outs = new Integer[ins.length];
        int i = 0;
        while (iterator.hasNext()) {
            outs[i] = (Integer) iterator.next();
            assertEquals(new Integer(ins[i]), outs[i]);
            ;
            i++;
        }

        assertEquals(i, outs.length);

    }

    @Test
    public void testToIterator_String() {
        String[] strsIn = {"1", "2", "3", "4"};
        Iterator<String> iterator = Arrays.toIterator(strsIn);
        assertNotNull(iterator);

        String[] strsOut = new String[strsIn.length];
        int i = 0;
        while (iterator.hasNext()) {
            strsOut[i] = iterator.next();
            assertEquals(strsIn[i], strsOut[i]);
            i++;
        }

        assertEquals(i, strsOut.length);

    }

    @Test
    public void testCopy_Strings() {
        String[] strs1 = {"1", "2", "3"};
        String[] strs2 = Arrays.copy(strs1);

        assertNotSame(strs1, strs2);
        assertEquals("1", strs1[0]);
        assertEquals("2", strs1[1]);
        assertEquals("3", strs1[2]);
    }

    @Test
    public void testCopy_null() {
        assertNull(Arrays.copy(null));
    }

    @Test
    public void testContains_char() {
        char[] dbls = {'1', '2', '3', '4', '4', '5'};

        assertTrue(Arrays.contains(dbls, '1'));
        assertTrue(Arrays.contains(dbls, '4'));
        assertTrue(Arrays.contains(dbls, '5'));
        assertFalse(Arrays.contains(dbls, '9'));
    }

    @Test
    public void testContains_double() {
        double[] dbls = {1, 2, 3, 4, 4, 5};

        assertTrue(Arrays.contains(dbls, (float) 1));
        assertTrue(Arrays.contains(dbls, (float) 4));
        assertTrue(Arrays.contains(dbls, (float) 5));
        assertFalse(Arrays.contains(dbls, (float) 9));
    }

    @Test
    public void testContains_float() {
        float[] flts = {1, 2, 3, 4, 4, 5};

        assertTrue(Arrays.contains(flts, (float) 1));
        assertTrue(Arrays.contains(flts, (float) 4));
        assertTrue(Arrays.contains(flts, (float) 5));
        assertFalse(Arrays.contains(flts, (float) 9));
    }

    @Test
    public void testContains_boolean() {
        boolean[] byts = {true, true, true, false, false, true};

        assertTrue(Arrays.contains(byts, true));
        assertTrue(Arrays.contains(byts, false));
    }

    @Test
    public void testContains_byte() {
        byte[] byts = {1, 2, 3, 4, 4, 5};

        assertTrue(Arrays.contains(byts, (byte) 1));
        assertTrue(Arrays.contains(byts, (byte) 4));
        assertTrue(Arrays.contains(byts, (byte) 5));
        assertFalse(Arrays.contains(byts, (byte) 9));
    }

    @Test
    public void testContains_long() {
        long[] lngs = {1, 2, 3, 4, 4, 5};

        assertTrue(Arrays.contains(lngs, (long) 1));
        assertTrue(Arrays.contains(lngs, (long) 4));
        assertTrue(Arrays.contains(lngs, (long) 5));
        assertFalse(Arrays.contains(lngs, (long) 9));
    }

    @Test
    public void testContains_short() {
        short[] shts = {1, 2, 3, 4, 4, 5};

        assertTrue(Arrays.contains(shts, (short) 1));
        assertTrue(Arrays.contains(shts, (short) 4));
        assertTrue(Arrays.contains(shts, (short) 5));
        assertFalse(Arrays.contains(shts, (short) 9));

    }

    @Test
    public void testContains_int() {
        int[] ints = {1, 2, 3, 4, 4, 5};

        assertTrue(Arrays.contains(ints, 1));
        assertTrue(Arrays.contains(ints, 4));
        assertTrue(Arrays.contains(ints, 5));
        assertFalse(Arrays.contains(ints, 9));
    }

    @Test
    public void testContains_String() {
        String[] strs = {"1", "2", "3", "4", "4", "5"};

        assertTrue(Arrays.contains(strs, "1"));
        assertTrue(Arrays.contains(strs, "4"));
        assertTrue(Arrays.contains(strs, "5"));
        assertFalse(Arrays.contains(strs, "9"));
    }

    @Test
    public void testIndexOf_char() {
        char[] dbls = {'1', '2', '3', '4', '4', '5'};

        assertEquals(0, Arrays.indexOf(dbls, '1'));
        assertEquals(1, Arrays.indexOf(dbls, '2'));
        assertEquals(2, Arrays.indexOf(dbls, '3'));
        assertEquals(3, Arrays.indexOf(dbls, '4'));//<-- skipped the first "4"
        assertEquals(5, Arrays.indexOf(dbls, '5'));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(dbls, '9'));
    }

    @Test
    public void testIndexOf_double() {
        double[] dbls = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.indexOf(dbls, (float) 1));
        assertEquals(1, Arrays.indexOf(dbls, (float) 2));
        assertEquals(2, Arrays.indexOf(dbls, (float) 3));
        assertEquals(3, Arrays.indexOf(dbls, (float) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.indexOf(dbls, (float) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(dbls, (float) 9));
    }

    @Test
    public void testIndexOf_float() {
        float[] flts = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.indexOf(flts, (float) 1));
        assertEquals(1, Arrays.indexOf(flts, (float) 2));
        assertEquals(2, Arrays.indexOf(flts, (float) 3));
        assertEquals(3, Arrays.indexOf(flts, (float) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.indexOf(flts, (float) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(flts, (float) 9));
    }

    @Test
    public void testIndexOf_boolean() {
        boolean[] byts = {true, true, true, false, false, true};

        assertEquals(0, Arrays.indexOf(byts, true));
        assertEquals(3, Arrays.indexOf(byts, false));
    }

    @Test
    public void testIndexOf_byte() {
        byte[] byts = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.indexOf(byts, (byte) 1));
        assertEquals(1, Arrays.indexOf(byts, (byte) 2));
        assertEquals(2, Arrays.indexOf(byts, (byte) 3));
        assertEquals(3, Arrays.indexOf(byts, (byte) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.indexOf(byts, (byte) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(byts, (byte) 9));
    }

    @Test
    public void testIndexOf_long() {
        long[] lngs = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.indexOf(lngs, (long) 1));
        assertEquals(1, Arrays.indexOf(lngs, (long) 2));
        assertEquals(2, Arrays.indexOf(lngs, (long) 3));
        assertEquals(3, Arrays.indexOf(lngs, (long) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.indexOf(lngs, (long) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(lngs, (long) 9));
    }

    @Test
    public void testIndexOf_short() {
        short[] shts = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.indexOf(shts, (short) 1));
        assertEquals(1, Arrays.indexOf(shts, (short) 2));
        assertEquals(2, Arrays.indexOf(shts, (short) 3));
        assertEquals(3, Arrays.indexOf(shts, (short) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.indexOf(shts, (short) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(shts, (short) 9));
    }

    @Test
    public void testIndexOf_int() {
        int[] ints = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.indexOf(ints, 1));
        assertEquals(1, Arrays.indexOf(ints, 2));
        assertEquals(2, Arrays.indexOf(ints, 3));
        assertEquals(3, Arrays.indexOf(ints, 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.indexOf(ints, 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(ints, 9));
    }

    @Test
    public void testIndexOf_String() {
        String[] strs = {"1", "2", "3", "4", "4", "5"};

        assertEquals(0, Arrays.indexOf(strs, "1"));
        assertEquals(1, Arrays.indexOf(strs, "2"));
        assertEquals(2, Arrays.indexOf(strs, "3"));
        assertEquals(3, Arrays.indexOf(strs, "4"));//<-- skipped the first "4"
        assertEquals(5, Arrays.indexOf(strs, "5"));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(strs, "9"));
    }

    @Test
    public void lastIndexOf_char() {
        char[] dbls = {'1', '2', '3', '4', '4', '5'};

        assertEquals(0, Arrays.lastIndexOf(dbls, '1'));
        assertEquals(1, Arrays.lastIndexOf(dbls, '2'));
        assertEquals(2, Arrays.lastIndexOf(dbls, '3'));
        assertEquals(4, Arrays.lastIndexOf(dbls, '4'));//<-- skipped the first "4"
        assertEquals(5, Arrays.lastIndexOf(dbls, '5'));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.lastIndexOf(dbls, '9'));
    }

    @Test
    public void testLastIndexOf_double() {
        double[] dbls = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.lastIndexOf(dbls, (float) 1));
        assertEquals(1, Arrays.lastIndexOf(dbls, (float) 2));
        assertEquals(2, Arrays.lastIndexOf(dbls, (float) 3));
        assertEquals(4, Arrays.lastIndexOf(dbls, (float) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.lastIndexOf(dbls, (float) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.lastIndexOf(dbls, (float) 9));
    }

    @Test
    public void testLastIndexOf_float() {
        float[] flts = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.lastIndexOf(flts, (float) 1));
        assertEquals(1, Arrays.lastIndexOf(flts, (float) 2));
        assertEquals(2, Arrays.lastIndexOf(flts, (float) 3));
        assertEquals(4, Arrays.lastIndexOf(flts, (float) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.lastIndexOf(flts, (float) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.lastIndexOf(flts, (float) 9));
    }

    @Test
    public void testLastIndexOf_boolean() {
        boolean[] byts = {true, true, true, false, false, true};

        assertEquals(5, Arrays.lastIndexOf(byts, true));
        assertEquals(4, Arrays.lastIndexOf(byts, false));
    }

    @Test
    public void testLastIndexOf_byte() {
        byte[] byts = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.lastIndexOf(byts, (byte) 1));
        assertEquals(1, Arrays.lastIndexOf(byts, (byte) 2));
        assertEquals(2, Arrays.lastIndexOf(byts, (byte) 3));
        assertEquals(4, Arrays.lastIndexOf(byts, (byte) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.lastIndexOf(byts, (byte) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.lastIndexOf(byts, (byte) 9));
    }

    @Test
    public void testLastIndexOf_long() {
        long[] lngs = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.lastIndexOf(lngs, (long) 1));
        assertEquals(1, Arrays.lastIndexOf(lngs, (long) 2));
        assertEquals(2, Arrays.lastIndexOf(lngs, (long) 3));
        assertEquals(4, Arrays.lastIndexOf(lngs, (long) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.lastIndexOf(lngs, (long) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.lastIndexOf(lngs, (long) 9));
    }

    @Test
    public void testLastIndexOf_short() {
        short[] shts = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.lastIndexOf(shts, (short) 1));
        assertEquals(1, Arrays.lastIndexOf(shts, (short) 2));
        assertEquals(2, Arrays.lastIndexOf(shts, (short) 3));
        assertEquals(4, Arrays.lastIndexOf(shts, (short) 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.lastIndexOf(shts, (short) 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.lastIndexOf(shts, (short) 9));
    }

    @Test
    public void testLastIndexOf_int() {
        int[] ints = {1, 2, 3, 4, 4, 5};

        assertEquals(0, Arrays.lastIndexOf(ints, 1));
        assertEquals(1, Arrays.lastIndexOf(ints, 2));
        assertEquals(2, Arrays.lastIndexOf(ints, 3));
        assertEquals(4, Arrays.lastIndexOf(ints, 4));//<-- skipped the first "4"
        assertEquals(5, Arrays.lastIndexOf(ints, 5));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.lastIndexOf(ints, 9));
    }

    @Test
    public void testLastIndexOf_String() {
        String[] strs = {"1", "2", "3", "4", "4", "5"};

        assertEquals(0, Arrays.lastIndexOf(strs, "1"));
        assertEquals(1, Arrays.lastIndexOf(strs, "2"));
        assertEquals(2, Arrays.lastIndexOf(strs, "3"));
        assertEquals(4, Arrays.lastIndexOf(strs, "4"));//<-- skipped the first "4"
        assertEquals(5, Arrays.lastIndexOf(strs, "5"));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.lastIndexOf(strs, "9"));
    }

    @Test
    public void testLastIndexOf_null_null() {
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.lastIndexOf(null, null));
    }

    @Test
    public void testEmptyArray_filledArray() {
        final String[] str = {"1", "2"};

        assertNotNull(Arrays.emptyArray(str));
        assertEquals(0, Arrays.emptyArray(str).length);
        assertEquals(2, str.length);

    }

    @Test
    public void testEmptyArray_emptyArray() {
        final String[] str = {};
        assertNotNull(Arrays.emptyArray(str));
        assertEquals(0, Arrays.emptyArray(str).length);

    }

    @Test
    public void testNewArray_ref_lenght() {
        String[] ary1 = {"1", "2", "3"};
        String[] ary2 = Arrays.newArray(ary1, 5);

        assertEquals(5, ary2.length);
        assertEquals(null, ary2[0]);
        assertEquals(null, ary2[1]);
        assertEquals(null, ary2[2]);
        assertEquals(null, ary2[3]);
        assertEquals(null, ary2[4]);

        assertEquals(3, ary1.length); //<-- check original
        assertEquals("1", ary1[0]);
        assertEquals("2", ary1[1]);
        assertEquals("3", ary1[2]);
    }

    @Test
    public void testNewArray_ZeroLength() {
        String[] strArry = Arrays.newArray(String.class, 0);
        assertNotNull(strArry);
        assertEquals(0, strArry.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewArray_NegativeLength() {
        Arrays.newArray(String.class, -1);
    }

    @Test
    public void testNewArray_String() {

        final int arrySize = 10;
        String[] strArry = Arrays.newArray(String.class, arrySize);

        assertEquals(arrySize, strArry.length);

        for (String str : strArry) {
            assertEquals(null, str);
        }

    }

    @Test
    public void testConcat() {
        Integer[] a = {1, 2, 3, 4};
        Integer[] b = {5, 6, 7, 8};

        Integer[] c = Arrays.concat(a, b);

        assertEquals(a.length + b.length, c.length);

        assertEquals(new Integer(1), c[0]);
        assertEquals(new Integer(2), c[1]);
        assertEquals(new Integer(3), c[2]);
        assertEquals(new Integer(4), c[3]);
        assertEquals(new Integer(5), c[4]);
        assertEquals(new Integer(6), c[5]);
        assertEquals(new Integer(7), c[6]);
        assertEquals(new Integer(8), c[7]);
    }

    @Test
    public void testRandom() {

        final int tests = 100;
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] randoms = new Integer[tests];

        for (int i = 0; i < tests; i++) {
            randoms[i] = Arrays.random(ints); //build random numbers
        }

        for (int i = 0; i < ints.length; i++) {
            Arrays.contains(randoms, ints[i]); //test that ints are in the randoms
        }

        for (int i = 0; i < randoms.length; i++) {
            Arrays.contains(ints, randoms[i]); //test that randoms are in the ints
        }

    }

    @Test
    public void testToList() {
        String[] array = {"1", "2", "3", "4", "5", "6"};
        List<String> list = Arrays.toList(array);
        assertEquals(array.length, list.size());

    }

    @Test
    public void testToString() {

        String[] strs = {"1", "2", "3", "4", "5", "6"};
        assertEquals("123456", Arrays.toString(strs));

    }

    @Test
    public void testToStringWhenGivenNull() {
        assertEquals("null", Arrays.toString(null));
    }

    @Test
    public void testIsEmptyOnCharArray() {
        char[] filled = {
            '0', '1'
        };
        char[] empty = {};

        assertFalse(Arrays.isEmpty(filled));
        assertTrue(Arrays.isEmpty(empty));
    }

    @Test
    public void testIsEmptyOnBooleanArray() {
        boolean[] filled = {
            true, false
        };
        boolean[] empty = {};

        assertFalse(Arrays.isEmpty(filled));
        assertTrue(Arrays.isEmpty(empty));
    }

    @Test
    public void testIsEmptyOnByteArray() {
        byte[] filled = {
            1, 2, 3
        };
        byte[] empty = {};

        assertFalse(Arrays.isEmpty(filled));
        assertTrue(Arrays.isEmpty(empty));
    }

    @Test
    public void testIsEmptyOnDoubleArray() {
        double[] filled = {
            1.1d, 2.2d, 3.3d
        };
        double[] empty = {};

        assertFalse(Arrays.isEmpty(filled));
        assertTrue(Arrays.isEmpty(empty));
    }

    @Test
    public void testIsEmptyOnFloatArray() {
        float[] filled = {
            1.1f, 2.2f, 3.3f
        };
        float[] empty = {};

        assertFalse(Arrays.isEmpty(filled));
        assertTrue(Arrays.isEmpty(empty));
    }

    @Test
    public void testIsEmptyOnShortArray() {
        short[] filled = {
            1, 2, 3
        };
        short[] empty = {};

        assertFalse(Arrays.isEmpty(filled));
        assertTrue(Arrays.isEmpty(empty));
    }

    @Test
    public void testIsEmptyOnLongArray() {
        long[] filled = {
            1L, 2L, 3L
        };
        long[] empty = {};

        assertFalse(Arrays.isEmpty(filled));
        assertTrue(Arrays.isEmpty(empty));
    }

    @Test
    public void testIsEmptyOnIntArray() {
        int[] filled = {
            1, 2, 3
        };
        int[] empty = {};

        assertFalse(Arrays.isEmpty(filled));
        assertTrue(Arrays.isEmpty(empty));
    }

    @Test
    public void testIndexOfOnAByte() {
        byte[] array = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 0
        };

        assertEquals(0, Arrays.indexOf(array, (byte) 1));
        assertEquals(1, Arrays.indexOf(array, (byte) 2));
        assertEquals(2, Arrays.indexOf(array, (byte) 3));
        assertEquals(3, Arrays.indexOf(array, (byte) 4));
        assertEquals(4, Arrays.indexOf(array, (byte) 5));
        assertEquals(5, Arrays.indexOf(array, (byte) 6));
        assertEquals(6, Arrays.indexOf(array, (byte) 7));
        assertEquals(7, Arrays.indexOf(array, (byte) 8));
        assertEquals(8, Arrays.indexOf(array, (byte) 9));
        assertEquals(9, Arrays.indexOf(array, (byte) 0));

        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, (byte) -1));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, (byte) 10));

        array = null;
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, (byte) 1));
    }

    @Test
    public void testIndexOfOnAChar() {
        char[] array = {
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
        };

        assertEquals(0, Arrays.indexOf(array, '1'));
        assertEquals(1, Arrays.indexOf(array, '2'));
        assertEquals(2, Arrays.indexOf(array, '3'));
        assertEquals(3, Arrays.indexOf(array, '4'));
        assertEquals(4, Arrays.indexOf(array, '5'));
        assertEquals(5, Arrays.indexOf(array, '6'));
        assertEquals(6, Arrays.indexOf(array, '7'));
        assertEquals(7, Arrays.indexOf(array, '8'));
        assertEquals(8, Arrays.indexOf(array, '9'));
        assertEquals(9, Arrays.indexOf(array, '0'));

        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, 'a'));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, '-'));

        array = null;
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, '0'));
    }

    @Test
    public void testIndexOfOnAShort() {
        short[] array = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 0
        };

        assertEquals(0, Arrays.indexOf(array, (short) 1));
        assertEquals(1, Arrays.indexOf(array, (short) 2));
        assertEquals(2, Arrays.indexOf(array, (short) 3));
        assertEquals(3, Arrays.indexOf(array, (short) 4));
        assertEquals(4, Arrays.indexOf(array, (short) 5));
        assertEquals(5, Arrays.indexOf(array, (short) 6));
        assertEquals(6, Arrays.indexOf(array, (short) 7));
        assertEquals(7, Arrays.indexOf(array, (short) 8));
        assertEquals(8, Arrays.indexOf(array, (short) 9));
        assertEquals(9, Arrays.indexOf(array, (short) 0));

        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, (short) 10));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, (short) -10));

        array = null;
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, (short) 0));
    }

    @Test
    public void testIndexOfOnALong() {
        long[] array = {
            1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 0L
        };

        assertEquals(0, Arrays.indexOf(array, 1));
        assertEquals(1, Arrays.indexOf(array, 2));
        assertEquals(2, Arrays.indexOf(array, 3));
        assertEquals(3, Arrays.indexOf(array, 4));
        assertEquals(4, Arrays.indexOf(array, 5));
        assertEquals(5, Arrays.indexOf(array, 6));
        assertEquals(6, Arrays.indexOf(array, 7));
        assertEquals(7, Arrays.indexOf(array, 8));
        assertEquals(8, Arrays.indexOf(array, 9));
        assertEquals(9, Arrays.indexOf(array, 0));

        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, 10));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, -10));

        array = null;
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, 0));
    }

    @Test
    public void testIndexOfOnAInt() {
        int[] array = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 0
        };

        assertEquals(0, Arrays.indexOf(array, 1));
        assertEquals(1, Arrays.indexOf(array, 2));
        assertEquals(2, Arrays.indexOf(array, 3));
        assertEquals(3, Arrays.indexOf(array, 4));
        assertEquals(4, Arrays.indexOf(array, 5));
        assertEquals(5, Arrays.indexOf(array, 6));
        assertEquals(6, Arrays.indexOf(array, 7));
        assertEquals(7, Arrays.indexOf(array, 8));
        assertEquals(8, Arrays.indexOf(array, 9));
        assertEquals(9, Arrays.indexOf(array, 0));

        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, 10));
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, -10));

        array = null;
        assertEquals(Arrays.INDEX_NOT_FOUND, Arrays.indexOf(array, 0));
    }

    @Test
    public void testIndexNotFound() {
        assertEquals(-1, Arrays.INDEX_NOT_FOUND);
    }

    @Test
    public void testAdd() {
        Object[] aArray = Arrays.of(1, 2, 3, 4, 5, 6);
        assertTrue(aArray.length == 6);
        aArray = Arrays.add(aArray, 7);
        assertTrue(aArray.length == 7);
        assertTrue(aArray[6] == (Integer) 7);
    }

    @Test(expected = NullPointerException.class)
    public void testExpandWhenGivenNull() {
        Arrays.expand(null, 1);
    }

    @Test
    public void testExpandByOne() {
        Boolean[] aArray = Arrays.of(true, true, false, false);
        assertTrue(aArray.length == 4);
        aArray = Arrays.expand(aArray, 1);

        assertTrue(aArray.length == 5);
        assertNull(aArray[4]);
        aArray[4] = false;
        assertNotNull(aArray[4]);
    }

    @Test
    public void testOf() {
        String[] aArray = Arrays.of("1", "2");
        assertTrue(aArray.length == 2);
    }

    @Test
    public void testIsLastItemOnAObject() {

        String[] aArray = {
            "1", "2", "3", "4"
        };


        assertFalse(Arrays.isLastItem("1", aArray));
        assertFalse(Arrays.isLastItem("2", aArray));
        assertFalse(Arrays.isLastItem("3", aArray));

        assertTrue(Arrays.isLastItem("4", aArray));

        assertFalse(Arrays.isLastItem("6", aArray));
        assertFalse(Arrays.isLastItem(null, aArray));
    }

    @Test
    public void testIsLastItem() {
        String[] aArray = {
            "1", "2", "3", "4"
        };


        assertFalse(Arrays.isLastItem(0, aArray));
        assertFalse(Arrays.isLastItem(1, aArray));
        assertFalse(Arrays.isLastItem(2, aArray));

        assertTrue(Arrays.isLastItem(3, aArray));

        assertFalse(Arrays.isLastItem(4, aArray));
        assertFalse(Arrays.isLastItem(5, aArray));
    }

    @Test(expected = NullPointerException.class)
    public void testIsLastItemWhenArrayIsNull() {


        Arrays.isLastItem(0, null);

    }
}
