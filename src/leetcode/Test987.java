package leetcode;

import lintcode.TreeNode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-31.
 * @description https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class Test987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        Queue<TreeNode> q = new LinkedList<>();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeMap<Integer, List<Integer>> t = new TreeMap<>();
            for (int i = 0;i < size;i++) {
                TreeNode cur = q.poll();
                int y = map.get(cur);
                if (!t.containsKey(y)) t.put(y, new ArrayList<>());
                t.get(y).add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                    map.put(cur.left, y - 1);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    map.put(cur.right, y + 1);
                }
            }
            for (Map.Entry<Integer, List<Integer>> cur : t.entrySet()) {
                int key = cur.getKey();
                List<Integer> val = cur.getValue();
                Collections.sort(val);
                if (!treeMap.containsKey(key)) treeMap.put(key, new ArrayList<>());
                treeMap.get(key).addAll(val);
            }
        }
        return new ArrayList<>(treeMap.values());
    }
}
