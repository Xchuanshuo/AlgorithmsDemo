package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-9.
 * @description convert-expression-to-polish-notation
 * idea:
 *      先装换为表达式树 然后前序遍历即可得到波兰表达式
 */
public class Test369 {

    class TreeNode {
        int priority;
        String val;
        TreeNode left, right;
        public TreeNode(int priority, String val) {
            this.priority = priority;
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<String> convertToPN(String[] expression) {
        List<String> result = new ArrayList<>();
        if (expression == null || expression.length == 0) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        int base = 0;
        for (String s : expression) {
            if (s.contains("(")) {
                base += 10;
                continue;
            }
            if (s.contains(")")) {
                base -= 10;
                continue;
            }
            TreeNode curNode = new TreeNode(getPriority(base, s), s);
            while (!stack.isEmpty() && curNode.priority <= stack.peek().priority) {
                curNode.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = curNode;
            }
            stack.push(curNode);
        }
        if (stack.isEmpty()) return result;
        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }
        preOrder(root, result);
        return result;
    }

    public void preOrder(TreeNode root, List<String> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    public int getPriority(int base, String s) {
        if ("+-".contains(s)) {
            return base + 1;
        }
        if ("*/".contains(s)) {
            return base + 2;
        }
        return Integer.MAX_VALUE;
    }
}
