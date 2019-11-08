package lintcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Legend
 * @data by on 19-11-7.
 * @description binary-tree-level-sum
 */
public class Test482 {

    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null) return 0;
        if (level == 1) return root.val;
        return levelSum(root.left, level - 1) + levelSum(root.right, level - 1);
    }
}
