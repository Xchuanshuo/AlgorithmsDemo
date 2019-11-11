package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-11-9.
 * @description recovery-binary-search-tree
 * idea:
 *      方法1: 中序遍历找到错乱的两个点，交换值
 *      方法2: 将val值从小到大排序, 对中序遍历的节点依次赋值
 */
public class Test691 {

//    TreeNode preNode = null, a = null, b = null;
//    public TreeNode bstSwappedNode(TreeNode root) {
//        // write your code here
//        helper(root);
//        if (a != null && b != null) {
//            int val = b.val;
//            b.val = a.val;
//            a.val = val;
//        }
//        return root;
//    }
//
//    public void helper(TreeNode root) {
//        if (root == null) return;
//        helper(root.left);
//        if (preNode != null && root.val < preNode.val) {
//            if (a == null) a = preNode;
//            b = root;
//        }
//        preNode = root;
//        helper(root.right);
//    }

    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        List<Integer> values = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        helper(root, nodes, values);
        Collections.sort(values);
        for (int i = 0;i < nodes.size();i++) {
            nodes.get(i).val = values.get(i);
        }
        return root;
    }

    public void helper(TreeNode root, List<TreeNode> nodes, List<Integer> values) {
        if (root == null) return;
        helper(root.left, nodes, values);
        values.add(root.val);
        nodes.add(root);
        helper(root.right, nodes, values);
    }
}
