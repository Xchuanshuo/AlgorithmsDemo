package lintcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-27.
 * @description next-greater-element-i
 */
public class Test1206 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for (int i = 0;i<nums1.length;i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
