/**
 * A minimum heap implementation that uses an array-based list internally.
 * The smallest element is always at the root (index 0).
 *
 * @param <T> the type of elements stored in the heap, must implement
 *            {@code Comparable<T>}
 */
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    /**
     * Inserts a new element into the heap, preserving the heap property.
     *
     * @param element the element to add
     */
    public void add(T element) {
        heap.add(element);
        siftUp(heap.size() - 1);
    }

    /**
     * Removes and returns the smallest element from the heap.
     *
     * @return the smallest element (the root of the heap)
     * @throws RuntimeException if the heap is empty
     */
    public T removeMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    /**
     * Returns the smallest element from the heap without removing it.
     *
     * @return the smallest element
     * @throws RuntimeException if the heap is empty
     */
    public T peek() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    /**
     * Checks whether the heap is empty.
     *
     * @return {@code true} if the heap contains no elements, {@code false}
     *         otherwise
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Returns the number of elements currently in the heap.
     *
     * @return the size of the heap
     */
    public int size() {
        return heap.size();
    }

    /**
     * Restores the heap property by moving the element at the given index up the
     * tree.
     *
     * @param index the index of the element to sift up
     */
    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T current = heap.get(index);
            T parent = heap.get(parentIndex);
            if (current.compareTo(parent) >= 0)
                break;
            heap.set(index, parent);
            heap.set(parentIndex, current);
            index = parentIndex;
        }
    }

    /**
     * Restores the heap property by moving the element at the given index down the
     * tree.
     *
     * @param index the index of the element to sift down
     */
    private void siftDown(int index) {
        int size = heap.size();
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == index)
                break;

            T temp = heap.get(index);
            heap.set(index, heap.get(smallest));
            heap.set(smallest, temp);

            index = smallest;
        }
    }
}