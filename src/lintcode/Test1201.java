package lintcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-27.
 * @description next-greater-element-ii
 */
public class Test1201 {

    public int[] nextGreaterElements(int[] nums) {
        // Write your code here
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < 2*n;i++) {
            int num = nums[i%n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < n) stack.push(i);
        }
        return res;
    }

}
