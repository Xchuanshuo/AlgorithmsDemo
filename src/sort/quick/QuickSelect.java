package sort.quick;

/**
 * @author Legend
 * @data by on 20-2-21.
 * @description 快速选择
 *  利用快速排序的切分 可以在O(N)时间复杂度内找到数组中第k大元素
 */
public class QuickSelect<T extends Comparable<T>> extends QuickSort<T> {

    public T select(T[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int p = partition(nums, l, r);
            if (p > k) {
                r = p - 1;
            } else if (p < k) {
                l = p + 1;
            } else {
                return nums[k];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 8, 1, 9, 6, 10, 99, 52, 26};
        QuickSelect<Integer> sort = new QuickSelect<>();
        System.out.println(sort.select(integers, 5));
    }
}
