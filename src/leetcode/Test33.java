package leetcode;

/**
 * @author Legend
 * @data by on 21-4-7.
 * @description 33. 搜索旋转排序数组
 * idea:
 *      二分查找. 因为是旋转数组, 所以只需要找到一个临界点
 *      临界点左、右两边都是有序的, 若 arr[r] > arr[mid] 则右边有序
 *                              若 arr[l] < arr[mid] 则左边有序
 *      然后确定target落在哪一边 若target > arr[mid] 且 target <= arr[r] 则 target位于该范围
 *                            若target >= arr[l] 且 target < arr[mid] 则 target位于该范围
 */
public class Test33 {

    public int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < arr[r]) {
                if (arr[mid] < target && target <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (arr[l] <= target && target < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
