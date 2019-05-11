package lintcode;

/**
 * @author Legend
 * @data by on 19-5-11.
 * @description kth-largest-element
 */
public class Test5 {

    public int kthLargestElement(int n, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int partition = partition(nums, 0, nums.length - 1);
        while (partition+1 != n) {
            if (partition + 1 < n) {
                partition = partition(nums, partition+1, nums.length - 1);
            } else {
                partition = partition(nums, 0, partition - 1);
            }
        }
        return nums[partition];
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l, j = l;
        while (j < r) {
            if (arr[j] > pivot) {
                swap(arr, i++, j);
            }
            j++;
        }
        swap(arr, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
