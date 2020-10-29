package kind.support.tuples;

import java.io.Serializable;
import java.util.Objects;

public class Tuple2<V1, V2> implements Serializable {
    private V1 value1;
    private V2 value2;

    public Tuple2() {
    }

    public Tuple2(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple2)) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(getValue1(), tuple2.getValue1()) &&
                Objects.equals(getValue2(), tuple2.getValue2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue1(), getValue2());
    }
}
