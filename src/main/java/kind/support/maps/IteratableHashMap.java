package kind.support.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class IteratableHashMap<K, V> extends HashMap<K, V> implements Iterable<Entry<K, V>> {

    private static final long serialVersionUID = 1;

    public Iterator<Entry<K, V>> iterator() {
        return entrySet().iterator();
    }
}
