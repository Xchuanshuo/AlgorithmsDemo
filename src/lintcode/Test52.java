package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-8-14.
 * @description next-permutation
 * idea:
 *      以1 2 2 4 1---> 1 2 4 1 2为例
 *      首先从右边向左开始遍历 找到第一个为升序的位置 也就是 2->4
 *      然后从2的位置 向右遍历 找到第一个大于2并且是大于2中最小的数
 *      显然 这里只有4 然后把2和4交换位置 最终得到1 2 4 2 1
 *      到了这里 再把4后面的数字按升序排列(翻转) 就得到了最终结果 1 2 4 1 2
 *      所以一共一下几步 1.后找 2.右找 3.交换 3.翻转
 *      注: 如果第一步找不到对应的 就说明当前排列是最后一个排列 这时直接返回
 *          第一个排列 直接排序即可
 */
public class Test52 {

    public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums==null || nums.length==0) return nums;
        int n = nums.length;
        int pos = n-2;
        while (pos>=0 && nums[pos]>=nums[pos+1]) { pos--;}
        if (pos < 0) {
            Arrays.sort(nums);
            return nums;
        }
        int i = n-1;
        while (nums[i]<=nums[pos]) { i--; }
        swap(nums, i, pos);
        while(pos+1<n) {
            swap(nums, ++pos, --n);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Test52 test = new Test52();
        int[] arr = {1, 2, 2, 4, 1};
        int[] result = test.nextPermutation(arr);
        for (int i: result) {
            System.out.print(i+", ");
        }
    }
}
