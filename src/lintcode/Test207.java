package lintcode;

import tree.segmenttree.SegmentTree;

/**
 * @author Legend
 * @data by on 18-6-23.
 * @description
 */
public class Test207 {

    private SegmentTree<Integer> segmentTree;

    public Test207(int[] A) {
        // do intialization if necessary
        Integer[] nums = new Integer[A.length];
        for (int i=0;i<A.length;i++) {
            nums[i] = A[i];
        }
        segmentTree = new SegmentTree<>(nums, (a, b)-> a+b);
    }

    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return segmentTree.query(start, end);
    }

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        // write your code here
        segmentTree.set(index, value);
    }
}
