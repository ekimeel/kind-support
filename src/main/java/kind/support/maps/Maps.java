package kind.support.maps;

import kind.support.text.Strings;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author Michael J. Lee
 */
public class Maps {

    /**
     * Creates an new instance of a <code>HashMap</code>.
     *
     * @return a new empty instance of a <code>HashMap</code>.
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }
    /**
     * Creates an new instance of a <code>LinkedHashMap</code>.
     *
     * @return a new empty instance of a <code>LinkedHashMap</code>.
     */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<K, V>();
    }
    /**
     * Creates an new instance of a <code>IteratableHashMap</code>.
     *
     * @return a new empty instance of a <code>IteratableHashMap</code>.
     */
    public static <K, V> IteratableHashMap<K, V> newIteratableHashMap() {
        return new IteratableHashMap<K, V>();
    }

    /**
     * Creates a new instance of a <code>HashMap<String, String></code> containing
     * the given <code>Properties</code>.
     *
     * @param properties The <code>Properties</code> to be contained in the returned
     *                   <code>HashMap<String, String></code>.
     * @return a new instance of a <code>HashMap<String, String></code> containing
     * the given <code>Properties</code>.
     */
    public static Map<String, String> of(Properties properties) {
        Map<String, String> ret = newHashMap();
        for (Enumeration<?> e = properties.propertyNames(); e.hasMoreElements(); ) {
            Object k = e.nextElement();
            String key = (k != null) ? k.toString() : null;
            ret.put(key, properties.getProperty(key));
        }
        return ret;
    }

    /**
     * Returns the the instance of the <code>Iterator</code> for each <code>Entry</code> for the given <code>Map</code>.
     *
     * @param <K>
     * @param <V>
     * @param map
     * @return
     * @throws NullPointerException if the given<code>Map</code> is <code>null</code>
     */
    public static <K, V> Iterator<Entry<K, V>> toIterator(Map<K, V> map) {
        return map.entrySet().iterator();
    }

    /**
     * Prints the give {@code Map} in {'key':'value'} format.
     *
     * @param map
     * @return
     */
    public static synchronized String toString(Map map) {
        final StringBuilder buffer = new StringBuilder();
        final Iterator<Entry<Object, Object>> iterator = toIterator(map);

        buffer.append("{");
        while (iterator.hasNext()) {
            final Entry<Object, Object> entry = iterator.next();
            buffer.append(Strings.quote(entry.getKey()))
                    .append(":");

            if (entry.getValue() instanceof Number) {
                buffer.append(entry.getValue());
            } else {
                buffer.append(Strings.quote(entry.getValue()));
            }
            if (iterator.hasNext()) {
                buffer.append(",");
            }
        }

        buffer.append("}");
        return buffer.toString();
    }

    private Maps() {
    }
}
