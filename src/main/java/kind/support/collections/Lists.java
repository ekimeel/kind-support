package kind.support.collections;

import static kind.support.Preconditions.assertNotNull;
import static kind.support.Preconditions.assertState;

import kind.support.Nulls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Lists {

    public static final ListTransformer MODIFIABLE_LIST = new ModifiableList();
    public static final ListTransformer UNMODIFIABLE_LIST = new UnModifiableList();

    /**
     * Creates an new instance of a <code>ArrayList</code>.
     *
     * @return a new empty instance of a <code>ArrayList</code>.
     */
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<T>();
    }

    /**
     * Creates an new instance of a <code>ArrayList</code>.
     *
     * @param <T> size
     * @return a new empty instance of a <code>ArrayList</code>.
     */
    public static <T> ArrayList<T> newArrayList(final int size) {
        return new ArrayList<T>(size);
    }

    /**
     * Creates a new instance of a <code>ArrayList</code> containing the
     * given elements
     *
     * @param elements The elements to be contained in the returned <code>ArrayList</code>
     * @return a new instance of a <code>ArrayList</code> containing the
     * given elements.
     */
    public static <E> ArrayList<E> of(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            @SuppressWarnings("unchecked")
            Collection<? extends E> collection = (Collection<? extends E>) elements;
            return new ArrayList<E>(collection);
        } else {
            return of(elements.iterator());
        }
    }

    /**
     * Creates a new instance of a <code>ArrayList</code> containing the
     * given elements
     *
     * @param elements The elements to be contained in the returned <code>ArrayList</code>
     * @return a new instance of a <code>ArrayList</code> containing the
     * given elements.
     */
    public static <E> ArrayList<E> of(Iterator<? extends E> elements) {
        ArrayList<E> list = newArrayList();
        while (elements.hasNext()) {
            list.add(elements.next());
        }
        return list;

    }

    /**
     * Creates a new instance of a <code>ArrayList</code> containing the
     * given <code>Map</code>'s <code>Entry</code>s
     *
     * @param map The map to be contained in the returned <code>ArrayList</code>
     * @return a new instance of a <code>ArrayList</code> containing the
     * given entries.
     */
    public static <K, V> List<Entry<K, V>> of(Map<K, V> map) {
        Iterator<Entry<K, V>> entries = map.entrySet().iterator();
        return of(entries);
    }

    /**
     * Creates a new instance of a <code>ArrayList</code> containing the given
     * elemetns
     *
     * @param elements The elements to be contained in the returned <code>ArrayList</code>
     * @return a new instance of a <code>ArrayList</code> containing the
     * given elements.
     */
    public static <T> List<T> of(T... elements) {
        return of(elements, MODIFIABLE_LIST);
    }

    public static <T> List<T> transform(List<T> list, ListTransformer transformer) {
        return transformer.transform(list);
    }

    public static synchronized <T> List<T> of(T[] elements, ListTransformer transformer) {
        return transformer.transform(Arrays.toList(elements));
    }

    /**
     * Returns if the given Object is the last item in the given list.
     * Throws a <code>NullPointerException</code> if the given list is
     * null.
     *
     * @param obj  Generic object to test
     * @param list list
     * @return True if the given objec is the last item in the given
     * list, otherwise false.
     * @throws NullPointerException if list is null
     */
    public static <T> boolean isLastItem(T obj, List<T> list) {

        if (list == null) {
            throw new NullPointerException("Cannot check the size of a null list.");
        }

        if (list.indexOf(obj) == (list.size() - 1)) {
            return true;
        }

        return false;
    }

    /**
     * Returns if the given index is the last item in the given list.
     * Throws a <code>NullPointerException</code> if the given list is
     * null.
     *
     * @param i    a valid index in the list
     * @param list list
     * @return True if the given index is the last item in the given
     * list, otherwise false.
     * @throws NullPointerException if list is null
     */
    public static boolean isLastItem(int i, List list) {

        if (list == null) {
            throw new NullPointerException("Cannot check the size of a null list.");
        }

        if (i == (list.size() - 1)) {
            return true;
        }

        return false;
    }

    /**
     * Returns a string containing the items in the given list delimited
     * by the given delimiter.
     * <br/>
     * Example<br/>
     * If a <code>List</code> containing the items [1,2,3,4,5,6] was
     * given to this method with a delimiter of "|" the result would be
     * "1|2|3|4|5|6".
     *
     * @param list      a valid list
     * @param delimiter a delimiter to put between the items
     * @return a string containing the items in the given list delimited
     * by the given delimiter.
     * @throws NullPointerException if list is null
     */
    public static String toDelimitedString(List list, String delimiter) {

        if (list == null) {
            throw new NullPointerException("List is null");
        }

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            Object aObject = list.get(i);
            buffer.append(String.valueOf(aObject));
            if (!isLastItem(i, list)) {
                buffer.append(delimiter);
            }
        }

        return buffer.toString();
    }

    /**
     * Returns the last item in the given <code>List</code>.
     *
     * @param <T>
     * @param list
     * @return last item in the given <code>List</code>
     * @throws NullPointerException if list is null
     */
    public static <T> T lastItem(List<T> list) {
        Nulls.failIfNull(list);

        return list.get(list.size() - 1);
    }

    public static final class ModifiableList implements ListTransformer {

        public <T> List<T> transform(List<T> list) {
            //does nothing
            return list;
        }
    }

    public static final class UnModifiableList implements ListTransformer {

        public <T> List<T> transform(List<T> list) {
            return Collections.unmodifiableList(list);
        }
    }

    /**
     * Returns a string representation of the contents of the specified list.
     * If the list contains other list as elements, they are converted to
     * strings by the {@link Object#toString} method inherited from
     * <tt>Object</tt>, which describes their <i>identities</i> rather than
     * their contents.
     *
     * <p>The value returned by this method is equal to the value that would
     * be returned by <tt>Arrays.asList(a).toString()</tt>, unless <tt>a</tt>
     * is <tt>null</tt>, in which case <tt>"null"</tt> is returned.
     *
     * @param list the list whose string representation to return
     * @return a string representation of <tt>list</tt>
     */
    public static String toString(List list) {
        if (list == null) {
            return "null";
        }

        int iMax = list.size() - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < list.size(); i++) {
            b.append(String.valueOf(list.get(i)));

            if (i == iMax) {
                return b.append(']').toString();
            }

            b.append(", ");
        }

        return b.toString();
    }


    /**
     * Returns if the given list is empty
     *
     * @param list
     * @return
     */
    public static synchronized boolean isEmpty(List list) {
        //TODO: JavaDoc
        assertNotNull(list);

        if (list.size() == 0) {
            return true;
        }

        return false;
    }

    /**
     * Returns if the given list is empty or null.
     *
     * @param list
     * @return
     */
    public static synchronized boolean isEmptyOrNull(List list) {
        //TODO: JavaDoc
        if (list == null) {
            return true;
        }

        if (list.size() == 0) {
            return true;
        }

        return false;
    }

    /**
     * Adds all the values in the give collection.  May throw a
     * NPE if one of the values is null.
     *
     * @param values the values to add
     * @return the result
     * @throw NullPointerException if any values are null
     */
    public static Integer sumIntegers(Collection<Integer> values) {

        int sum = 0;

        for (Integer value : values)
            sum += value;

        return sum;
    }

    /**
     * Adds all the values in the give collection.  May throw a
     * NPE if one of the values is null.
     *
     * @param values the values to add
     * @return the result if any values are null
     */
    public static Double sumDoubles(Collection<Double> values) {

        double sum = 0;

        for (Double value : values)
            sum += value;

        return sum;
    }
}
