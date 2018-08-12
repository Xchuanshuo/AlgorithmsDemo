package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-17.
 * @description
 */
public class Test71 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        helper(root, result, 0);

        return result;
    }

    private void helper(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }

        if (result.size()<level+1) {
            result.add(new LinkedList<Integer>());
        }
        if (level%2!=0) {
            ((LinkedList<Integer>)result.get(level)).addFirst(node.val);
        } else {
            result.get(level).add(node.val);
        }
        helper(node.left, result, level+1);
        helper(node.right, result, level+1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        Test71 test = new Test71();
        System.out.println(test.zigzagLevelOrder(treeNode));
    }
}
