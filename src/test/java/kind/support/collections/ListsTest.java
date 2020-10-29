package kind.support.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import static org.junit.Assert.*;


public class ListsTest {

    @Test
    public void testToArrayOnString() {

        List<String> numbers = Lists.of("1", "2", "Hello", "4", "5");
        String[] numbersInArray = Lists.toArray(numbers);

        assertEquals(5, numbersInArray.length);

        assertTrue(numbersInArray[0].equals("1"));
        assertTrue(numbersInArray[1].equals("2"));
        assertTrue(numbersInArray[2].equals("Hello"));
        assertTrue(numbersInArray[3].equals("4"));
        assertTrue(numbersInArray[4].equals("5"));
    }

    @Test
    public void testToArray() {
        List<Integer> numbers = Lists.of(1, 2, 3, 4, 5);
        Integer[] numbersInArray = Lists.toArray(numbers);

        assertEquals(5, numbersInArray.length);

        assertTrue(numbersInArray[0] == 1);
        assertTrue(numbersInArray[1] == 2);
        assertTrue(numbersInArray[2] == 3);
        assertTrue(numbersInArray[3] == 4);
        assertTrue(numbersInArray[4] == 5);
    }

    @Test(expected = NullPointerException.class)
    public void testToArrayWhenGivenNull() {
        Lists.toArray(null);
    }

    @Test
    public void testToStringOnEmptyList() {
        assertEquals("[]", Lists.toString(Lists.newArrayList()));
    }

    @Test
    public void testToString() {
        List ints = Lists.of(1, 2, 4, 5);


        List aList = Lists.of("1", "2", "3", "4");


        assertEquals("[1, 2, 3, 4]", Lists.toString(aList));
    }

    @Test
    public void testToStringOnNull() {
        assertEquals("null", Lists.toString(null));
    }

    @Test
    public void testToDelimitedString() {
        List aList = Lists.of("1", "2", "3", "4");

        assertEquals("1|2|3|4", Lists.toDelimitedString(aList, "|"));
        assertEquals("1,2,3,4", Lists.toDelimitedString(aList, ","));
    }

    @Test(expected = NullPointerException.class)
    public void testToDelimitedStringWhenListIsNull() {
        Lists.toDelimitedString(null, "|");
    }

    @Test
    public void testIsLastItemWithObject() {
        List<String> aList = Lists.of("1", "2", "3", "4");

        assertFalse(Lists.isLastItem("1", aList));
        assertFalse(Lists.isLastItem("2", aList));
        assertFalse(Lists.isLastItem("3", aList));
        assertTrue(Lists.isLastItem("4", aList));
        assertFalse(Lists.isLastItem("5", aList)); //<-- Doesn't exist in list
    }

    @Test
    public void testIsLastItem() {
        List aList = Lists.of("1", "2", "3", "4");

        assertFalse(Lists.isLastItem(0, aList));
        assertFalse(Lists.isLastItem(1, aList));
        assertFalse(Lists.isLastItem(2, aList));

        assertTrue(Lists.isLastItem(3, aList));

        assertFalse(Lists.isLastItem(4, aList));
        assertFalse(Lists.isLastItem(5, aList));
    }

    @Test(expected = NullPointerException.class)
    public void testIsLastItemWhenArrayIsNull() {


        Lists.isLastItem(0, null);

    }

    @Test
    public void testNewArrayList() {
        assertNotNull(Lists.newArrayList());
        assertEquals(0, Lists.newArrayList().size());
    }

    @Test
    public void testTransform() {
        List<String> names = Lists.of("Mike", "Carla");

        ListTransformer mixer = createMockListTransformer(); //<-- converts strings to uppercase.

        assertEquals("Mike", names.get(0));
        assertEquals("Carla", names.get(1));
        Lists.transform(names, mixer);
        assertEquals("MIKE", names.get(0));
        assertEquals("CARLA", names.get(1));
    }

    @Test
    public void testOfOnAIterator() {
        final Iterator<String> mockIterator = createMockIterator("Joe", "Cindy", "Mark");
        final List<String> list = Lists.of(mockIterator);

        assertEquals(3, list.size());
        assertTrue(list.contains("Joe"));
        assertTrue(list.contains("Cindy"));
        assertTrue(list.contains("Mark"));

    }

    @Test
    public void testOfOnAMap() {

        //TODO: Test does not check items within the return list;
        final Map<String, Double> map = new HashMap();
        map.put("1", 1.00);
        map.put("2", 1.00);
        map.put("3", 1.00);

        final List<Entry<String, Double>> list = Lists.of(map);

        assertEquals(map.size(), list.size());
    }

    @Test
    public void testOfOnAObjectArray() {

        final Integer[] ints = {1, 2, 3};
        final List<Integer> list = Lists.of(ints);

        assertEquals(3, list.size());
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }

    public ListTransformer createMockListTransformer() {
        return new ListTransformer() {

            @SuppressWarnings("unchecked")
            public <T> List<T> transform(List<T> list) {
                for (int i = 0; i < list.size(); i++) {
                    String name = (String) list.get(i);
                    list.set(i, (T) name.toUpperCase());
                }
                return list;
            }
        };
    }

    public <T> Iterator<T> createMockIterator(final T... items) {

        return new Iterator<T>() {

            int currentIndex = 0;

            public Object[] array = items;

            public boolean hasNext() {
                return ((currentIndex < array.length) ? true : false);
            }

            @SuppressWarnings("unchecked")
            public T next() {
                return (T) array[currentIndex++];
            }

            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };


    }
}
