package kind.support.collections;

import java.util.List;

public interface ListTransformer {

    <T> List<T> transform(List<T> list);
}
