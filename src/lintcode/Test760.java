package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 19-11-10.
 * @description binary-tree-right-side-view
 * idea:
 *      1. bfs 使用队列 取每一层的最后一个节点的值
 *      2. dfs 使用先序遍历, 每次更新当前list中当前位置的值，
 *       因为先序遍历是最后遍历右侧节点，所以右侧的一定会替换掉左侧的
 */
public class Test760 {

    public List<Integer> rightSideView(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = null;
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                curNode = queue.poll();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            res.add(curNode.val);
        }
        return res;
    }

//    public List<Integer> rightSideView(TreeNode root) {
//        // write your code here
//        List<Integer> res = new ArrayList<>();
//        helper(root, 0, res);
//        return res;
//    }
//
//    public void helper(TreeNode root, int level, List<Integer> list) {
//        if (root == null) return;
//        if (level == list.size()) {
//            list.add(root.val);
//        } else {
//            list.set(level, root.val);
//        }
//        helper(root.left, level + 1, list);
//        helper(root.right, level + 1, list);
//    }
}
