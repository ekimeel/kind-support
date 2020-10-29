package kind.support.tuples;

import java.io.Serializable;
import java.util.Objects;

public class Tuple3<V1, V2, V3> implements Serializable {
    private V1 value1;
    private V2 value2;
    private V3 value3;

    public Tuple3() {
    }

    public Tuple3(V1 value1, V2 value2, V3 value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public V1 getValue1() {
        return value1;
    }

    public void setValue1(V1 value1) {
        this.value1 = value1;
    }

    public V2 getValue2() {
        return value2;
    }

    public void setValue2(V2 value2) {
        this.value2 = value2;
    }

    public V3 getValue3() {
        return value3;
    }

    public void setValue3(V3 value3) {
        this.value3 = value3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple3)) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(getValue1(), tuple3.getValue1()) &&
                Objects.equals(getValue2(), tuple3.getValue2()) &&
                Objects.equals(getValue3(), tuple3.getValue3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue1(), getValue2(), getValue3());
    }
}
