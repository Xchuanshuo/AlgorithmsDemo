package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-25.
 * @description count-of-smaller-number
 */
public class Test248 {

    class SegmentTreeNode {
        int start, end, count;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }

    }
    private SegmentTreeNode root;

    // 构建线段树
    public SegmentTreeNode buildSegmentTree(int start, int end) {
        if (start>end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start != end) {
            int mid = start+(end-start)/2;
            root.left = buildSegmentTree(start, mid);
            root.right = buildSegmentTree(mid+1, end);
        } else {
            root.count = 0;
        }
        return root;
    }

    // 查询线段树
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (start==root.start && end==root.end) {
            return root.count;
        }
        int mid = root.start+(root.end-root.start)/2;
        int leftCount = 0, rightCount=0;
        if (start<mid) {
            if (mid<=end) {
                //　未完全包含在左子树
                leftCount = querySegmentTree(root.left, start, mid);
            } else {
                // 完全包含在左子树
                leftCount = querySegmentTree(root.left, start, end);
            }
        }
        if (mid<=end) {
            if (start<mid) {
                // 未完全包含在右子树
                rightCount = querySegmentTree(root.right, mid+1, end);
            } else {
                // 完全包含在右子树
                rightCount = querySegmentTree(root.right, start, end);
            }
        }
        return leftCount+rightCount;
    }

    // 修改线段树
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if (root.start==index && root.end==index) {
            root.count += value;
            return;
        }
        int mid = root.start+(root.end-root.start)/2;
        if (mid>=index && index>=root.start) {
            modifySegmentTree(root.left, index, value);
        }
        if (mid<index && index<=root.end) {
            modifySegmentTree(root.right, index, value);
        }
        root.count = root.left.count+root.right.count;
    }

    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        root = buildSegmentTree(0, 10);
        List<Integer> result = new ArrayList<>();
        int res;
        for (int i=0;i<A.length;i++) {
            // 默认构建的线段树count都为0 如果数组中存在该元素就将count更新为1
            modifySegmentTree(root, A[i], 1);
        }
        for (int i=0;i<queries.length;i++) {
            res = 0;
            if (queries[i]>0) {
                res = querySegmentTree(root, 0, queries[i]-1);
            }
            result.add(res);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,2,7,8,5};
        int[] nums = {1, 8, 5};
        Test248 test = new Test248();
        System.out.println(test.countOfSmallerNumber(A, nums));
    }
}
