package tree.heap;

/**
 * @author Legend
 * @data by on 18-6-20.
 * @description
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
