package lintcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-15.
 * @description maximum-binary-tree
 */
public class Test1106 {

    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        // Write your code here
        Deque<TreeNode> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!deque.isEmpty() && deque.peek().val < nums[i]) {
                curr.left = deque.pop();
            }
            if(!deque.isEmpty()) {
                deque.peek().right = curr;
            }
            deque.push(curr);
        }
        return deque.isEmpty() ? null : deque.removeLast();
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        // Write your code here
        return build(nums, 0, nums.length-1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        int index = helper(nums, l, r);
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, l, index-1);
        root.right = build(nums, index+1, r);
        return root;
    }

    private int helper(int[] nums, int l, int r) {
        int index = l;
        for (int i = l+1;i <= r;i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        Test1106 test = new Test1106();
        System.out.println(test.constructMaximumBinaryTree1(nums));
    }
}
