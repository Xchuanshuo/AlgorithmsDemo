package sort;

/**
 * @author Legend
 * @data by on 20-2-20.
 * @description 选择排序 每一轮找到最小元素的位置 然后与当前位置交换
 *  和冒泡排序类似 但不必每次比较都交换位置 只需要每一轮找到最大或
 *  最小索引后交换即可 但减少了交互次数
 */
public class SelectSort<T extends Comparable<T>> extends Sort<T>{

    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int i = 0;i < n;i++) {
            int minIndex = i;
            for (int j = i + 1;j < n;j++) {
                if (less(nums[j], nums[minIndex])) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 8, 1, 9, 6, 10, 99, 52, 26};
        SelectSort<Integer> sort = new SelectSort<>();
        sort.sort(integers);
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }
}
