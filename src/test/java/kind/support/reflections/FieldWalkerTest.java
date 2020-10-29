package kind.support.reflections;

import org.junit.Test;
import static org.junit.Assert.*;

public class FieldWalkerTest {

    @Test
    public void testWalk_object_() {
        AMockClass level1 = new AMockClass();
        level1.setValue(1);
        level1.setName("First Level");

        AMockClass level2 = new AMockClass();
        level2.setValue(2);
        level2.setName("Second Level");

        AMockClass level3 = new AMockClass();
        level3.setValue(3);
        level3.setName("Third Level");

        level2.setChild(level3);
        level1.setChild(level2);

        assertEquals("First Level", FieldWalker.walk(level1, "name"));//<---walks to level1.getName()
        assertEquals(1, FieldWalker.walk(level1, "value"));

        assertEquals("Second Level", FieldWalker.walk(level1, "child.name"));//<---walks to level1.getChild().getName()
        assertEquals(2, FieldWalker.walk(level1, "child.value"));

        assertEquals("Third Level", FieldWalker.walk(level1, "child.child.name"));//<---walks to level1.getChild().getChild().getName()
        assertEquals(3, FieldWalker.walk(level1, "child.child.value"));

    }

    public class AMockClass {

        private int value;

        private String name;

        private AMockClass child;

        public AMockClass getChild() {
            return child;
        }

        public void setChild(AMockClass child) {
            this.child = child;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "name=[" + getName() + "] value=[" + getValue() + "]";
        }
    }
}
