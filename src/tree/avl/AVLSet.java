package tree.avl;

import tree.Set;

/**
 * @author Legend
 * @data by on 18-6-24.
 * @description
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E, Object> avl;

    public AVLSet() {
        avl = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
