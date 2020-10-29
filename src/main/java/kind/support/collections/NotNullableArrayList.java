package kind.support.collections;

import java.util.ArrayList;
import java.util.Collection;

public class NotNullableArrayList<E> extends ArrayList<E> {

    private static final long serialVersionUID = 1;

    /**
     * Appends the specified element to the end of this list if it is
     * not null.  If the element is null a NullPointerException
     * will be thrown
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws NullPointerException if element is null
     */
    @Override
    public boolean add(E e) {
        failIfNull(e);
        return super.add(e);
    }

    /**
     * Inserts the specified element at the specified position in this
     * list if it is not null. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     * If the element is null a NullPointerException will be thrown
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException      if element is null
     */
    @Override
    public void add(int index, E element) {
        failIfNull(element);
        super.add(index, element);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list as long as no nulls exist in the collection , in the order
     * that they are returned by the specified collection's Iterator.  The
     * behavior of this operation is undefined if the specified collection
     * is modified while the operation is in progress.  (This implies
     * that the behavior of this call is undefined if the specified
     * collection is this list, and this list is nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null or
     *                              if any elements are null
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        failIfNull(c);
        for (E e : c) {
            failIfNull(e);
        }

        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        failIfNull(c);
        for (E e : c) {
            failIfNull(e);
        }

        return super.addAll(index, c);
    }

    private void failIfNull(Object o) {
        if (o == null)
            throw new NullPointerException("The current list does not allow nulls.");
    }
}
