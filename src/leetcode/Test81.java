package leetcode;

/**
 * @author Legend
 * @data by on 21-4-7.
 * @description 81. 搜索旋转排序数组 II
 * idea:
 *      与test33类似, 但存在重复元素, 这样就没办法确定要往哪一边去查找
 *      如: 10111 查找0 mid=2, 应该到左边查找 而:11101 查找 mid=2,应该到右边查找
 *      解决办法是先对左右两边【去重】
 */
public class Test81 {

    public boolean search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            while (l < r && arr[l] == arr[l+1]) l++;
            while (l < r && arr[r] == arr[r-1]) r--;
            int mid = l + (r-l)/2;
            if (arr[mid] == target)  return true;
            if (arr[mid] < arr[r]) {
                if (arr[mid] < target && target <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (arr[l] <= target &&  target < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}
