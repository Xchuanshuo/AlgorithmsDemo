package lintcode;

import tree.heap.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Legend
 * @data by on 19-11-9.
 * @description construct-binary-tree-from-preorder-and-postorder-traversal
 * idea:
 *      重点是确定左右子树的长度, 然后去pre和post数组中切割 并递归处理
 */
public class Test1593 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // write your code here
        int n = pre.length, len = 0;
        if (n == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (n == 1) return root;
        for (int i = 0;i < post.length;i++) {
            if (post[i] == pre[1]) {
                len = i + 1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, 1 + len),
                Arrays.copyOfRange(post, 0, len));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, 1 + len , n),
                Arrays.copyOfRange(post, len, n - 1));
        return root;
    }
}
