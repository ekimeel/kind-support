package kind.support.collections;

public interface ListObserver {
    void onAdd(Object element);
    void onRemove(Object element);
}
