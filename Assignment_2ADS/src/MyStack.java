/**
 * A generic stack implementation based on a linked list.
 * It follows the LIFO (Last-In-First-Out) principle.
 *
 * @param <T> the type of elements held in the stack
 */
public class MyStack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param item the element to push
     */
    public void push(T item) {
        list.add(item);
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element that was removed from the top
     * @throws RuntimeException if the stack is empty
     */
    public T pop() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws RuntimeException if the stack is empty
     */
    public T peek() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack contains no elements, {@code false}
     *         otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return list.size();
    }
}