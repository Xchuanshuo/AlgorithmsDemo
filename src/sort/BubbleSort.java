package sort;

/**
 * @author Legend
 * @data by on 20-2-20.
 * @description 冒泡排序 每次上浮当前最大的元素到最右边
 * 假设数组长度为n, 从位置0开始,依次比较 第1轮找到最大的元素放到n-1的位置
 *                                  第2轮则找到最大的元素放到n-2的位置
 *                                  ... 直到n-1最大个元素都放到右边 整体就有序了
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int i = n - 1;i > 0;i--) {
            for (int j = 0;j < i;j++) {
                if (less(nums[j+1], nums[j])) {
                    swap(nums, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 8, 1, 9, 6, 10, 99, 52, 26};
        BubbleSort<Integer> sort = new BubbleSort<>();
        sort.sort(integers);
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }
}
