package graph.base;

/**
 * 最小索引堆
 *
 * @author Legend
 * @create 2018-05-19 上午10:19
 *
 **/

public class IndexMinHeap<Item extends Comparable> {

    // 最小索引堆中对的数据
    protected Item[] data;
    // 最小索引堆中的索引
    protected int[] indexes;
    //　反向索引
    protected int[] reverse;
    protected int count;
    protected int capacity;

    public IndexMinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity+1];
        indexes = new int[capacity+1];
        reverse = new int[capacity+1];
        for (int i=0;i <= capacity;i++) {
            reverse[i] = 0;
        }
        count = 0;
        this.capacity = capacity;
    }

    // 返回索引堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值　表示索引堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向最小索引堆中插入一个新的元素，新元素的索引为i,元素为item
    public void insert(int i, Item item) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        assert !contain(i);
        i++;
        data[i] = item;
        indexes[count+1] = i;
        reverse[i] = count + 1;
        count++;

        shiftUp(count);
    }

    // 从最小索引堆中取出堆顶元素, 即索引堆中所存储的最小数据
    public Item extractMin() {
        assert count > 0;
        Item ret = data[indexes[1]];
        swapIndex(1 , count);
        reverse[indexes[count]] = 0;
        count --;
        shiftDown(1);

        return ret;
    }
    // 从最小索引堆中取出堆顶元素的索引
    public int extractMinIndex() {
        assert count > 0;

        int ret = indexes[1] -1;
        swapIndex(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    // 获取最小索引堆中的堆顶元素
    public Item getMin(){
        assert count > 0;
        return data[indexes[1]];
    }

    // 获取最小索引堆中的堆顶元素的索引
    public int getMinIndex(){
        assert count > 0;
        return indexes[1]-1;
    }

    // 获取最小索引堆中索引为i的元素
    public Item getItem( int i ){
        assert contain(i);
        return data[i+1];
    }

    // 将最小索引堆中索引为i的元素改为newItem
    public void change(int i, Item newItem) {
        assert contain(i);
        i++;
        data[i] = newItem;
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    // 看索引i所在的位置是否存在元素
    public boolean contain( int i ){
        assert  i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i+1] != 0;
    }

    //　交换索引堆中的索引i和ｊ
    private void swapIndex(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    // 上浮操作
    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) > 0) {
            swapIndex(k ,k/2);
            k /= 2;
        }
    }

    // 下沉操作
    private void shiftDown(int k) {
        while (2*k <= count) {
            int j =  2*k;
            if (j+1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]]) <= 0) {
                j++;
            }
            if (data[indexes[k]].compareTo(data[indexes[j]]) <= 0) {
                break;
            }
            swapIndex(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<>(N);
        for (int i=0;i < N;i++) {
            indexMinHeap.insert(i, (int) (Math.random() * N));
        }
        System.out.println(indexMinHeap.extractMin());
        indexMinHeap.change(1,1);
        System.out.println(indexMinHeap.extractMin());
    }
}
