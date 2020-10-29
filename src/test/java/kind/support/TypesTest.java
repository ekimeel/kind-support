/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kind.support;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mlee
 */
public class TypesTest {

    @Test
    public void testFromNameWithShortString() {

        assertEquals(String.class, Types.fromName("String"));
        assertEquals(Boolean.class, Types.fromName("Boolean"));
        assertEquals(Byte.class, Types.fromName("Byte"));
        assertEquals(Character.class, Types.fromName("Character"));
        assertEquals(Double.class, Types.fromName("Double"));
        assertEquals(Float.class, Types.fromName("Float"));
        assertEquals(Integer.class, Types.fromName("Integer"));
        assertEquals(Long.class, Types.fromName("Long"));
        assertEquals(Short.class, Types.fromName("Short"));

        assertEquals(String.class, Types.fromName("string"));
        assertEquals(boolean.class, Types.fromName("boolean"));
        assertEquals(byte.class, Types.fromName("byte"));
        assertEquals(char.class, Types.fromName("char"));
        assertEquals(double.class, Types.fromName("double"));
        assertEquals(float.class, Types.fromName("float"));
        assertEquals(int.class, Types.fromName("int"));
        assertEquals(long.class, Types.fromName("long"));
        assertEquals(short.class, Types.fromName("short"));

    }

        @Test
    public void testFromNameWithLongString() {

        assertEquals(String.class, Types.fromName("java.lang.String"));
        assertEquals(Boolean.class, Types.fromName("java.lang.Boolean"));
        assertEquals(Byte.class, Types.fromName("java.lang.Byte"));
        assertEquals(Character.class, Types.fromName("java.lang.Character"));
        assertEquals(Double.class, Types.fromName("java.lang.Double"));
        assertEquals(Float.class, Types.fromName("java.lang.Float"));
        assertEquals(Integer.class, Types.fromName("java.lang.Integer"));
        assertEquals(Long.class, Types.fromName("java.lang.Long"));
        assertEquals(Short.class, Types.fromName("java.lang.Short"));
    }
}
