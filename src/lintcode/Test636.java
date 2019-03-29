package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-29.
 * @description 132-pattern
 * idea:
 *      难想到的解法 还是单调栈 132 要找到这种模式 往最优的情况看就是尽量找到比第2个数小的最大的第3个元素
 *      这样比较与第1个数比较时 更容易匹配到结果 所以这里从后往前遍历 需要维护一个单调递减栈 也就是保存的
 *      当前元素永远比栈顶的元素要小 这样做的好处是 要找到最优的第3个数 只需要在维护单调递减栈时 更新第3
 *      个数的值即可 例: 假如当前维护了一个栈 从栈顶到低端依次是 1 2 4 5, 这时新来了一个元素3 要保持单调递减
 *      就只能将栈顶的元素pop 每次记录pop出的元素 而这个栈又是从顶端到底端递增的 所以,每轮记录更新后的一定是最优的
 *      情况 这里就是元素2.  在继续往前遍历时 只需要判断当前元素是否比保存的最优的第3个数小 满足则找到32匹配
 *      不满足则继续维护栈 更新third的值 push新元素入栈
 */
public class Test636 {

    public boolean find132pattern(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;
        for (int i = nums.length - 1;i >= 0;i--) {
            if (nums[i] < third) {
                return true;
            } else {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    third = stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
