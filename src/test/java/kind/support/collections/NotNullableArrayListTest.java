/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kind.support.collections;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class NotNullableArrayListTest {

    @Test
    public void testAdd(){
        List<String> list = new NotNullableArrayList<String>();
        
        assertEquals(0, list.size());
        list.add("my not null addition");
        assertEquals(1, list.size());   
    }
    
    @Test(expected=NullPointerException.class)
    public void testAddANull(){
        List<String> list = new NotNullableArrayList<String>();
        
        assertEquals(0, list.size());
        list.add(null);
        fail("should have failed");
    }

}
