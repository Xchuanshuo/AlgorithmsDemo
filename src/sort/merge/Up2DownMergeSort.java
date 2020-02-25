package sort.merge;

/**
 * @author Legend
 * @data by on 20-2-21.
 * @description 自顶向下的归并排序
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        this.aux = (T[]) new Comparable[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(T[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 8, 1, 9, 6, 10, 99, 52, 26};
        Up2DownMergeSort<Integer> sort = new Up2DownMergeSort<>();
        sort.sort(integers);
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }
}
