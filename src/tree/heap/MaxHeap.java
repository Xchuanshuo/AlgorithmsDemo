package tree.heap;

/**
 * @author Legend
 * @data by on 18-6-19.
 * @description 最大堆
 */
public class MaxHeap<E extends Comparable> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i=parent(arr.length-1);i>=0;i--) {
            shiftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中　一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent!");
        }
        return (index-1)/2;
    }

    // 返回完全二叉树的数组表示中　一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index*2+1;
    }

    // 返回完全二叉树的数组表示中　一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize()-1);
    }

    private void shiftUp(int k) {
        while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Cant not findMax when heap is Empty!");
        }
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize()-1);
        data.removeLast();
        shiftDown(0);

        return ret;
    }

    private void shiftDown(int k) {

        while (leftChild(k)<data.getSize()) {
            int j = leftChild(k);
            if (j+1<data.getSize() && data.get(j).compareTo(data.get(j+1))<0) {
                j++;
            }
            // j是左右孩子中较大值对应的索引
            if (data.get(j).compareTo(data.get(k))<=0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素　并且替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }
}
