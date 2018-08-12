package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-7-15.
 * @description binary-tree-vertical-order-traversal
 */
public class Test651 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.offer(root);
        colQueue.offer(0);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int col = colQueue.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>(Arrays.asList(curr.val)));
            } else {
                map.get(col).add(curr.val);
            }
            if (curr.left != null) {
                queue.offer(curr.left);
                colQueue.offer(col-1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                colQueue.offer(col+1);
            }
        }
        for (int n: map.keySet()) {
            result.add(map.get(n));
        }
        return result;
    }

    class TreeNode {
       public int val;
       public TreeNode left, right;
       public TreeNode(int val) {
           this.val = val;
           this.left = this.right = null;
       }
    }
}
