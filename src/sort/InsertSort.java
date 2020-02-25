package sort;

/**
 * @author Legend
 * @data by on 20-2-20.
 * @description 直接插入排序 每次将元素插入到左边已经排好序的位置
 * 假设数组长度为n 每次将当前位置的元素和前一个位置进行比较, 如果比前面元素大
 * 说明当前元素已经找到了插入的位置, 而当前元素左边都是已经排好序的, 所以本轮
 * 直接结束; 如果比前面元素小,就直接交换，然后继续往前比较, 直到比前面的元素大
 * 而前面元素的左边都是排好序的 所以从0到当前位置都是有序的. 一直到n-1的位置 则整体有序
 */
public class InsertSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int i = 1;i < n;i++) {
            for (int j = i;j>0 && less(nums[j], nums[j-1]);j--) {
                swap(nums, j, j-1);
            }
        }
    }


    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 8, 1, 9, 6, 10, 99, 52, 26};
        InsertSort<Integer> sort = new InsertSort<>();
        sort.sort(integers);
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }
}
