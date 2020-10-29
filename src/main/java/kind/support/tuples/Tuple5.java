package kind.support.tuples;

import java.io.Serializable;
import java.util.Objects;

public class Tuple5<V1, V2, V3, V4, V5> implements Serializable {
    private V1 value1;
    private V2 value2;
    private V3 value3;
    private V4 value4;
    private V5 value5;

    public Tuple5() {
    }

    public Tuple5(V1 value1, V2 value2, V3 value3, V4 value4, V5 value5) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
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

    public V4 getValue4() {
        return value4;
    }

    public void setValue4(V4 value4) {
        this.value4 = value4;
    }

    public V5 getValue5() {
        return value5;
    }

    public void setValue5(V5 value5) {
        this.value5 = value5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple5)) return false;
        Tuple5<?, ?, ?, ?, ?> tuple5 = (Tuple5<?, ?, ?, ?, ?>) o;
        return Objects.equals(getValue1(), tuple5.getValue1()) &&
                Objects.equals(getValue2(), tuple5.getValue2()) &&
                Objects.equals(getValue3(), tuple5.getValue3()) &&
                Objects.equals(getValue4(), tuple5.getValue4()) &&
                Objects.equals(getValue5(), tuple5.getValue5());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue1(), getValue2(), getValue3(), getValue4(), getValue5());
    }
}
