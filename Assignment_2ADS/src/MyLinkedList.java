/**
 * A doubly-linked list implementation of the {@code MyList} interface.
 *
 * @param <T> the type of elements held in this list
 */
public class MyLinkedList<T> implements MyList<T> {

    /**
     * Inner class representing a node of the doubly-linked list.
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            Node<T> newNode = new Node<>(element);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
            return;
        } else if (index == size) { // FIXED: was assignment '='
            add(element);
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(element);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data; // FIXED: was current.element
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int index) {
        // FIXED: index >= size instead of index > size
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        T removedElement = current.data; // FIXED: was current.element

        if (size == 1) {
            head = tail = null;
        } else if (current == head) {
            head = current.next;
            head.prev = null;
        } else if (current == tail) {
            tail = current.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return removedElement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T old = current.data; // FIXED: was current.element
        current.data = element;
        return old;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = null;
            current.prev = null;
            current.data = null; // help garbage collector
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }
}
