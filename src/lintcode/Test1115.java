package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 19-11-12.
 * @description average-of-levels-in-binary
 */
public class Test1115 {

    public List<Double> averageOfLevels(TreeNode root) {
        // write your code here
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double t = 0.0;
            for (int i = 0;i < size;i++) {
                TreeNode node = queue.poll();
                t += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(t / size);
        }
        return res;
    }
}
