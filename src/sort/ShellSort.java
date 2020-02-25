package sort;

/**
 * @author Legend
 * @data by on 20-2-20.
 * @description 希尔排序 在插入排序基础上进行分组优化
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        int d = n;
        while (d > 1) {
            d = d  / 2;
            for (int i = d;i < n;i++) {
                for (int j = i;(j-d) >= 0 && less(nums[j], nums[j -  d]);j-=d) {
                    swap(nums, j, j - d);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 8, 1, 9, 6, 10, 99, 52, 26};
        ShellSort<Integer> sort = new ShellSort<>();
        sort.sort(integers);
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }
}
