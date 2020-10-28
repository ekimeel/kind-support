package kind.support;

public interface Copyable<T> {

    /**
     * Creates a new copy of the current object. It is left to the implementation whether the copy is deep or shallow
     * @return a shallow OR deep copy of the current object
     */
    public T copy();
}
