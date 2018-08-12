package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-9.
 * @description unique-binary-search-trees-ii
 */
public class Test164 {

    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i=start;i<=end;i++) {
            List<TreeNode> leftTree = helper(start, i-1);
            List<TreeNode> rightTree = helper(i+1, end);
            for (TreeNode leftNode: leftTree) {
                for (TreeNode rightNode: rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test164 test = new Test164();
        System.out.println(test.generateTrees(3));
    }
}
