public class MyLinkedList<T> implements MyList<T> {
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

    @Override
    public T set(int index, T element) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T old = current.element;
        current.element = element;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }
}