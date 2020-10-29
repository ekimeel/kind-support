
package kind.support.maps;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

public class MapsTest {


    @Test
    public void testToString_full(){
        Map<String, Object> myMap = Maps.newLinkedHashMap();

        myMap.put("Last Name", "Lee");
        myMap.put("First Name", "Mike");
        myMap.put("Age", 26);
        
        final String expOutput = "{\"Last Name\":\"Lee\",\"First Name\":\"Mike\",\"Age\":26}";
        System.out.println(Maps.toString(myMap));
        System.out.println(expOutput);
        assertEquals(expOutput, Maps.toString(myMap));
    }


    @Test
    public void testToIterator(){
        Map<String, Object> myMap = Maps.newHashMap();

        myMap.put("First Name", "Mike");
        myMap.put("Last Name", "Lee");

        Iterator iterator = Maps.toIterator(myMap);

        assertNotNull(iterator);        
    }

    @Test
    public void testNewHashMap(){
        
        Map<String, Object> map = Maps.newHashMap();
        
        assertNotNull(map);
    }
    
    @Test
    public void testNewIteratableHashMap(){
        
        IteratableHashMap<String, Object> map = Maps.newIteratableHashMap();
        
        assertNotNull(map);
    }
    
    @Test
    public void testn(){
        Map<String, Object> map = Maps.newHashMap();
    }
    
    
    
    
    @Test
    public void testOfOnProperties(){
        Properties properties = new Properties();
        properties.put("Hello", "World");
        
        Map<String, String> map = Maps.of(properties);
        assertEquals(1, map.size());
        assertEquals("World", map.get("Hello"));
        
    }

}
