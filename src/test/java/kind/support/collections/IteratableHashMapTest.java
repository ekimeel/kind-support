package kind.support.collections;


import java.util.Map.Entry;

import kind.support.maps.IteratableHashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class IteratableHashMapTest {

    @Test
    public void testIterator(){
        final IteratableHashMap<String, Integer> map = new IteratableHashMap<>();
        
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        
        Integer testCase = 1;
        for(Entry<String, Integer> entry : map){
            
            assertEquals(testCase, entry.getValue());
            assertEquals(testCase.toString(), entry.getKey());
            
            testCase++;
        }
    }

}
