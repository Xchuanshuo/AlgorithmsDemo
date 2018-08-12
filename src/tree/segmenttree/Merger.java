package tree.segmenttree;

/**
 * @author Legend
 * @data by on 18-6-21.
 * @description
 */
public interface Merger<E> {
    E merge(E a, E b);
}
