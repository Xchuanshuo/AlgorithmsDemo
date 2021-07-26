package leetcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 21-4-17.
 * @description https://leetcode-cn.com/problems/create-maximum-number/submissions/
 * idea:
 *      要从nums1(长度n1)和nums2(长度n2)中 共取出k位数 =>
 *          分别从nums1中移除n1-i位数, nums2中移除n2-(k-i)位数 使得剩余的数能组成最大整数
 *          枚举所有情况, 即两个数组分别取0-k位数的情况
 *          直接利用单调递减栈, 栈顶小于当前元素则移除 直到移除了指定个数
 *
 *          对处理后的数组进行归并, 优先放较大的值，归并后的结果再与当前最大归并结果比较
 */
public class Test321 {

    int[] max;
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        for (int i = 0;i <= k;i++) {
            int d1 = n1 - i, d2 = n2 - (k-i);
            if (d1 < 0 || d2 < 0) continue;
            int[] left = helper(nums1, d1);
            int[] right = helper(nums2, d2);
            int[] union = merge(left, right);
            calMax(union);
        }
        return max;
    }

    private void calMax(int[] union) {
        if (max == null) {
            max = union; return;
        }
        for (int i = 0;i < union.length;i++) {
            if (union[i] > max[i]) {
                max = union;
                break;
            } else if (union[i] < max[i]) {
                break;
            }
        }
    }

    public int[] helper(int[] nums, int k) {
        if (k == 0) return nums;
        if (k == nums.length) return new int[0];
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1;i >= 0;i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    private int[] merge(int[] left, int[] right) {
        int m = left.length, n = right.length;
        int i = 0, j = 0, k = 0;
        int[] res = new int[m+n];
        while (k < res.length) {
            if (compare(left, i, right, j)) {
                res[k++] = left[i++];
            } else {
                res[k++] = right[j++];
            }
        }
        return res;
    }

    private boolean compare(int[] nums1, int i, int[] nums2, int j) {
        if (i >= nums1.length) return false;
        if (j >= nums2.length) return true;
        if (nums1[i] > nums2[j]) return true;
        if (nums1[i] < nums2[j]) return false;
        return compare(nums1, i + 1, nums2, j + 1);
    }
}
