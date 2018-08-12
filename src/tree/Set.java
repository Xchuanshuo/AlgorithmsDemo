package tree;

/**
 * @author Legend
 * @data by on 18-6-18.
 * @description
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
