/**
 * A simple list interface with basic operations.
 *
 * @param <T> the type of elements stored in the list
 */
public interface MyList<T> {

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    void add(T element);

    /**
     * Inserts an element at the specified position.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right.
     *
     * @param index   the position where the element should be inserted (0..size)
     * @param element the element to insert
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void add(int index, T element);

    /**
     * Returns the element at the specified position in the list.
     *
     * @param index the index of the element to return (0..size-1)
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T get(int index);

    /**
     * Removes the element at the specified position and returns it.
     * Shifts any subsequent elements to the left.
     *
     * @param index the index of the element to remove (0..size-1)
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T remove(int index);

    /**
     * Replaces the element at the specified position with a new element.
     *
     * @param index   the index of the element to replace
     * @param element the new element to store at that position
     * @return the old element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T set(int index, T element);

    /**
     * Returns the number of elements currently in the list.
     *
     * @return the current size of the list
     */
    int size();

    /**
     * Checks whether the list contains no elements.
     *
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Removes all elements from the list. The list will be empty after this call.
     */
    void clear();
}
