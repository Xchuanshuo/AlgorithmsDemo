package lintcode;

/**
 * @author Legend
 * @data by on 18-7-12.
 * @description complete-binary-tree
 */
public class Test467 {

    class Helper {
        int depth;
        boolean isComplete;
        boolean isFull;
        public Helper(int depth, boolean isComplete, boolean isFull) {
            this.depth = depth;
            this.isComplete = isComplete;
            this.isFull = isFull;
        }
    }

    public boolean isComplete(TreeNode root) {
        // write your code here
        Helper result = helper(root);
        return result.isComplete;
    }

    private Helper helper(TreeNode root) {
        if (null == root) {
            return new Helper(0, true, true);
        }
        Helper left = helper(root.left);
        Helper right = helper(root.right);
        if (!left.isComplete) {
            return new Helper(-1, false ,false);
        }
        if (left.depth == right.depth) {
            if (!left.isFull || !right.isComplete) {
                return new Helper(-1, false, false);
            }
            return new Helper(left.depth+1, true, right.isFull);
        }
        if (left.depth == right.depth+1) {
            if (!left.isComplete || !right.isFull) {
                return new Helper(-1, false, false);
            }
            return new Helper(left.depth+1, true, false);
        }
        return new Helper(-1, false, false);
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
