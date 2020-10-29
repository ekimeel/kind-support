package kind.support.reflections;

import java.io.Serializable;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassReaderTest {

    public ClassReaderTest() {
    }

    @Test
    public void testReadProp() {

    }

    @Test
    public void testIsSerializableTrue() {
        assertTrue("Class is not serializble", ClassReader.isSerializable(MockSerializableClass.class));
    }

    @Test
    public void testIsSerializableFalse() {
        assertFalse("Class is serializble", ClassReader.isSerializable(MockEmptyClass.class));
    }

    @Test
    public void testIsInterfaceTrue() {
        assertTrue("Interface not found", ClassReader.isInterface(MockInterface.class));
    }

    @Test
    public void testIsInterfaceFalse() {
        assertFalse("Interface not found", ClassReader.isInterface(MockEmptyClass.class));
    }

    @Test
    public void testHasAccessibleConstructorTrue() {
        assertTrue("No accessible constructor found.", ClassReader.hasPublicConstructor(MockPublicConstructorClass.class));
        assertTrue("No accessible constructor found.", ClassReader.hasPublicConstructor(MockEmptyClass.class));
    }

    @Test
    public void testHasAccessibleConstructorWhenConstructorIsPrivate() {
        assertFalse("Accessible constructor found.", ClassReader.hasPublicConstructor(MockPrivateConstructorClass.class));
    }

    @Test
    public void testHasInterfaceTrue() {
        assertTrue("Interface not found", ClassReader.hasInterface(MockSerializableClass.class, Serializable.class));
    }

    @Test
    public void testHasInterfaceFalse() {
        assertFalse("Interface found", ClassReader.hasInterface(MockEmptyClass.class, Serializable.class));
    }

    @Test
    public void testHasMethodTrue() {
        assertTrue("Method not found", ClassReader.hasPublicMethod(MockPublicConstructorClass.class, "setName"));
    }

    @Test
    public void testHasMethodFalse() {
        assertFalse("Method found", ClassReader.hasPublicMethod(MockPublicConstructorClass.class, "getBadName"));
    }

    @Test
    public void testHasNoArgPublicConstructor() {
        assertTrue(ClassReader.hasNoArgPublicConstructor(MockPublicConstructorClass.class));
        assertFalse(ClassReader.hasNoArgPublicConstructor(MockPrivateConstructorClass.class));
        assertTrue(ClassReader.hasNoArgPublicConstructor(MockEmptyClass.class));
    }

    @Test
    public void testHasProtectedConstructor() {
        assertTrue(ClassReader.hasProtectedConstructor(MockProtectedConstructorClass.class));
        assertFalse(ClassReader.hasProtectedConstructor(MockPublicConstructorClass.class));
        assertFalse(ClassReader.hasProtectedConstructor(MockPrivateConstructorClass.class));
    }
}
