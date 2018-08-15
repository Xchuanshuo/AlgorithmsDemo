package lintcode;

/**
 * @author Legend
 * @data by on 18-8-15.
 * @description jump-game-ii
 * idea:
 *      同样是贪心算法 这是这里需要记录步数 思路没多大差别
 *      需要注意 循环里面每次都要更新start和end
 *      总的时间复杂度实际为O(N)
 */
public class Test117 {

    public int jump(int[] A) {
        // write your code here
        if (null==A || A.length==0) return -1;
        int start=0, end=0, result=0;
        while (end<A.length-1) {
            result++;
            int farthest = end;
            for (int i=start;i<=end;i++) {
                if (A[i]+i > farthest) {
                    farthest = A[i]+i;
                }
            }
            start = end+1;
            end = farthest;
        }
        return result;
    }
}
