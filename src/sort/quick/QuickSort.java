package sort.quick;

import sort.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 20-2-21.
 * @description 快速排序
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
//        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int r) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }

    protected int partition(T[] nums, int l, int r) {
        int i = l, j = r + 1;
        T p = nums[l];
        while (true) {
            while (less(nums[++i], p) && i != r);
            while (less(p, nums[--j]) && j != l);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        System.out.print(l + ":" + r + "----"+i + ":" + j + "----");
        for (T t : nums) {
            System.out.print(t + " ");
        }
        System.out.println();
        return j;
    }

    /**
     * 打乱数组顺序 防止出现极端情况
     * @param nums
     */
    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    public static void main(String[] args) {
//        Integer[] integers = new Integer[]{2, 5, 8, 1, 9, 6, 10, 99, 52, 26};
        Integer[] integers = new Integer[]{4,1,2,3};
        QuickSort<Integer> sort = new QuickSort<>();
        sort.sort(integers);
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }
}
