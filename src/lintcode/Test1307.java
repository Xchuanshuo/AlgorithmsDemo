package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-6.
 * @description verify-preorder-sequence-in-binary-search-tree
 * idea:
 *        1.如果当前树没有右节点 则不会进入该循环
 *        2.如果有右节点 就需要找到未遍历到的第一个右节点 该右节点对应的父节点值 作为临界值
 *        3.对于这个临界值 根据BST前序遍历的性质 后续的节点(因为是还未遍历到的右节点)值不可能小于该值
 */
public class Test1307 {

    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int p : preorder) {
            if (p < low) {
                return false;
            }
            while (!stack.isEmpty() && p > stack.peek()) {
                low = stack.pop();
            }
            stack.push(p);
        }
        return true;
    }
}

