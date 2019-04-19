package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-17.
 * @description construct-binary-tree-from-string
 */
public class Test880 {

    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            } else if (Character.isDigit(c) || c == '-') {
                int k = i + 1;
                while (c != '(' && c != ')') {
                    c = s.charAt(k++);
                }
                TreeNode node = new TreeNode(Integer.parseInt(s.substring(i, --k)));
                if (!stack.isEmpty()) {
                    TreeNode curRoot = stack.peek();
                    if (curRoot.left == null) {
                        curRoot.left = node;
                    } else {
                        curRoot.right = node;
                    }
                }
                stack.push(node);
                i = k - 1;
            }
        }
        return stack.pop();
    }
}
