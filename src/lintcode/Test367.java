package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-9.
 * @description expression-tree-build
 */
public class Test367 {

    class TreeNode {
        int priority;
        ExpressionTreeNode eNode;
        TreeNode(int priority, String s) {
            this.priority = priority;
            this.eNode = new ExpressionTreeNode(s);
        }
    }

    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int base = 0;
        for (int i = 0;i < expression.length;i++) {
            if ("(".equals(expression[i])) {
                base += 10;
                continue;
            }
            if (")".equals(expression[i])) {
                base -= 10;
                continue;
            }
            int priority = getPriority(base, expression[i]);
            TreeNode curNode = new TreeNode(priority, expression[i]);
            while (!stack.isEmpty() && curNode.priority <= stack.peek().priority) {
                curNode.eNode.left = stack.pop().eNode;
            }
            if (!stack.isEmpty()) {
                stack.peek().eNode.right = curNode.eNode;
            }
            stack.push(curNode);
        }
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode rootNode = stack.pop();
        while (!stack.isEmpty()) {
            rootNode = stack.pop();
        }
        return rootNode.eNode;
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
class ExpressionTreeNode {
    public String symbol;
    public ExpressionTreeNode left, right;
    public ExpressionTreeNode(String symbol) {
        this.symbol = symbol;
        this.left = this.right = null;
    }
}
