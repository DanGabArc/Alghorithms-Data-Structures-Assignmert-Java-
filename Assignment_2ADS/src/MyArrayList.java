/**
 * A resizable-array implementation of the {@code MyList} interface.
 * When the internal array becomes full, its capacity is doubled automatically.
 *
 * @param <T> the type of elements stored in this list
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;

    // Конструктор
    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayList() {
        this.data = new Object[10];
        this.size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T element) {
        if (size == data.length) {
            // Расширяем массив в 2 раза
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size] = element;
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

        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = element;

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
        return (T) data[index];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        T removed = (T) data[index];

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }

        size--;

        return removed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T old = (T) data[index];
        data[index] = element;
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
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        size = 0;
    }

}
