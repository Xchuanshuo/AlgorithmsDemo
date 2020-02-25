package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 19-11-13.
 * @description serialize-and-deserialize-bst
 */
public class Test1235 {

    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#");
            } else {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodeVal  = data.split("\\s+");
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodeVal[idx++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (idx < nodeVal.length) {
            TreeNode cur = queue.poll();
            if (nodeVal[idx].equals("#")) {
                cur.left = null;
                idx++;
            } else {
                cur.left = new TreeNode(Integer.parseInt(nodeVal[idx++]));
                queue.offer(cur.left);
            }
            if (nodeVal[idx].equals("#")) {
                cur.right = null;
                idx++;
            } else {
                cur.right = new TreeNode(Integer.parseInt(nodeVal[idx++]));
                queue.offer(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Test1235 test = new Test1235();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        String str = test.serialize(root);
        System.out.println(str);
        test.deserialize(str);
    }
}
