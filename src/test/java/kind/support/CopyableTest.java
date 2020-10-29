package kind.support;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyableTest {

    @Test
    public void testCopy(){
        MockCopyableObject mock = new MockCopyableObject(1);
        assertNotNull(mock.copy());
    }


    private class MockCopyableObject implements Copyable<MockCopyableObject>{

        private final int value;

        public MockCopyableObject(int value){
            this.value = value;
        }

        public MockCopyableObject copy() {
            return new MockCopyableObject(value);
        }

    }
}
