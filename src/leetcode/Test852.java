package leetcode;

/**
 * @author Legend
 * @data by on 21-6-15.
 * @description https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class Test852 {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (mid+1<=arr.length-1 && arr[mid] > arr[mid+1]) {
                if (mid - 1 >= 0 && arr[mid] > arr[mid-1]) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {18,29,38,59,98,100,99,98,90};
        Test852 test = new Test852();
        System.out.println(test.peakIndexInMountainArray(arr));
    }
}
