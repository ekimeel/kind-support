package kind.support.collections;

import java.util.Iterator;

/**
 * An iterator that supports a one-element lookahead while iterating.
 */
public interface PeekingIterator<E> extends Iterator<E> {

    /**
     * Returns the next element in the iteration without advancing the iteration.
     *
     * <p> If possible, calls to {@code peek()} should not affect the iteration.
     * As is the case with most Iterators, modifications to the underlying
     * iteration may have unanticipated results.
     * </p>
     * <p>If there are no remaining elements in the iteration, {@code peek()}
     * will throw a {@code NoSuchElementException}.  (A {@code null} return value
     * does <em>not</em> indicate that this iterator has reached the end of its
     * iteration.)
     * </p>
     * <p><b>Usage note</b>:  Implementations may, but are not required to,
     * support {@code remove()} following a call to {@code peek()}.
     * </p>
     *
     * @throws java.util.NoSuchElementException if the iteration has
     *                                          no more elements.
     */
    E peek();
}
