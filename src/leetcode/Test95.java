package leetcode;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-4-16.
 * @description https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * idea:
 *      递归 对于区间(1-n) 枚举以节点任意节点i为根的所有二叉树
 *      分别处理区间(1,i-1),(i+1,n) 以i为节点的二叉树数量
 *      则是两边区间可以组成的所有二叉树的乘积
 */
public class Test95 {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> nodes = new LinkedList<>();
        if (l > r) {
            nodes.add(null);
            return nodes;
        }
        for (int i = l;i <= r;i++) {
            List<TreeNode> leftNodes = helper(l, i - 1);
            List<TreeNode> rightNodes = helper(i+1, r);
            TreeNode cur = new TreeNode(i);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    cur.left = left;
                    cur.right = right;
                    nodes.add(cur);
                    cur = new TreeNode(i);
                }
            }
        }
        return nodes;
    }
}
