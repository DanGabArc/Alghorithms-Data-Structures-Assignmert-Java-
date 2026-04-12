/**
 * A generic queue implementation based on a linked list.
 * It follows the FIFO (First-In-First-Out) principle.
 *
 * @param <T> the type of elements held in the queue
 */
public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    /**
     * Adds an element to the end of the queue.
     *
     * @param item the element to add
     */
    public void enqueue(T item) {
        list.add(item);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element that was removed from the front
     * @throws RuntimeException if the queue is empty
     */
    public T dequeue() {
        if (list.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.remove(0);
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return {@code true} if the queue contains no elements, {@code false}
     *         otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements currently in the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return list.size();
    }
}