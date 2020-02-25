package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-7-13.
 * @description Serialize and Deserialize Binary Tree
 */
public class Test7 {

    public String serialize(TreeNode root) {
        if (root==null) {
            return "{}";
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        for (int i=0;i<list.size();i++) {
            TreeNode node = list.get(i);
            if (null == node) continue;
            list.add(node.left);
            list.add(node.right);
        }
        while (list.get(list.size()-1) == null) {
            list.remove(list.size()-1);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("{"+list.get(0).val);
        for (int i=1;i<list.size();i++) {
            if (list.get(i) == null) {
                builder.append(",#");
            } else {
                builder.append(","+list.get(i).val);
            }
        }
        builder.append("}");
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("{}")) return null;
        String[] strings = data.substring(1, data.length()-1).split(",");
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        list.add(root);
        boolean isLeftChild = true;
        int level = 0;
        for (int i=0;i < strings.length;i++) {
            if (!strings[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(strings[i]));
                if (isLeftChild) {
                    list.get(level).left = node;
                } else {
                    list.get(level).right = node;
                }
                list.add(node);
            }
            if (!isLeftChild) level++;
            isLeftChild = !isLeftChild;
        }
        return root;
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
