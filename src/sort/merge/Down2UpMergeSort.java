package sort.merge;

/**
 * @author Legend
 * @data by on 20-2-21.
 * @description 自底向上归并排序
 */
public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        this.aux = (T[]) new Comparable[nums.length];
        int n = nums.length;
        for (int sz = 1;sz < n;sz+=sz) {
            for (int l = 0;l < n - sz;l+=2*sz) {
                merge(nums, l, l + sz - 1, Math.min(l + 2*sz - 1,n-1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 8, 1, 9, 6, 10, 99, 52, 26};
        Down2UpMergeSort<Integer> sort = new Down2UpMergeSort<>();
        sort.sort(integers);
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }
}
