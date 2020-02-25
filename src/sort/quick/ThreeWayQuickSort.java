package sort.quick;

import sort.Sort;

/**
 * @author Legend
 * @data by on 20-2-21.
 * @description 三路快速排序
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int r) {
        if (l >= r) return;
        int lt = l, i = lt + 1, gt = r;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, i++, lt++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, r);
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 8, 1, 9, 6, 10, 99, 52, 26};
        ThreeWayQuickSort<Integer> sort = new ThreeWayQuickSort<>();
        sort.sort(integers);
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }

}
