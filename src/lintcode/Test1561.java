package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 19-5-2.
 * @description bst-node-distance
 * idea:
 *      先构建一颗BST 从root开始找节点 重点是找距离时如果node1和node2在root同一侧 距离就是两个距离的差了
 *      那么怎么判断两个节点是不是在同一侧? 可能左侧 可能在右侧, 如果在某个节点左右节点 那么距离差又为0(实际为1)，这样得
 *      写一堆判断的代码， 更好的做法是找节点计算距离时 找到一个根节点使要找的点node1和node2分别为该节点的左右
 *      子树上(或者node1和node2中有一个节点为该根节点) 然后直接从该根节点去查找
 */
public class Test1561 {

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private TreeNode buildTree(int[] numbers) {
        TreeNode root = new TreeNode(0);
        for (int i = 0;i < numbers.length;i++) {
            insert(root, numbers[i]);
        }
        return root;
    }

    private boolean check(int[] numbers, int node1, int node2) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) set.add(number);
        return set.contains(node1) && set.contains(node2);
    }

    private int distance(TreeNode root, int val) {
        int distance = 0;
        while (root.val != val) {
            distance++;
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return distance;
    }

    public int bstDistance(int[] numbers, int node1, int node2) {
        if (numbers == null || numbers.length == 0) return -1;
        if (!check(numbers, node1, node2)) return -1;
        TreeNode root = buildTree(numbers);
        while (node1 < root.val && node2 < root.val || node1 > root.val && node2 > root.val) {
            if (node1 < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return distance(root, node1) + distance(root, node2);
    }

    public static void main(String[] args) {
        Test1561 test = new Test1561();
        int[] numbers = {2, 1, 3};
        test.bstDistance(numbers, 1, 3);
    }
}
