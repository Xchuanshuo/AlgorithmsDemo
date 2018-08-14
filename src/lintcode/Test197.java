package lintcode;

/**
 * @author Legend
 * @data by on 18-8-14.
 * @description permutation-index
 * idea:
 *      这个题目与求第k个排列刚好是个逆过程，这里有一个重要的trick
 *      就是求解时从后向前遍历 这样避免了阶乘的重复计算
 *      以 [1, 3, 4, 2]为例 从最后开始遍历 2的位置后面没有比2小的数
 *      所以为0 然后是4 后面有1个比2小的数 所以排列数为1*1!
 *      继续遍历到3 后面仍然只有一个 则排列数为1*2! 最后是1 没有比1小的数
 *      所以0*3! 最终结果就是0*4!+1*3!+1*2!+0*1!=3
 *      而编号是从1开始的 所以结果就是3+1=4
 */
public class Test197 {

    public long permutationIndex(int[] A) {
        // write your code here
        if (A==null || A.length==0) return 0;
        long result = 1, fac = 1;
        for (int i=A.length-1;i>=0;i--) {
            int count = 0;
            for (int j=i;j<A.length;j++) {
                if (A[j]<A[i]) count++;
            }
            result += count*fac;
            fac *= A.length-i;
        }
        return result;
    }
}
