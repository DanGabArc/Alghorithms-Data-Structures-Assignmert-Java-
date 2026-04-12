public interface MyList<T> {
    void add(T element);

    void add(int index, T element);

    T get(int index);

    T remove(int index);

    T set(int index, T element);

    int size();

    boolean isEmpty();

    void clear();
}
