package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-10-16.
 * @description continuous-subarray-sum-ii
 * idea:
 *      与Test402相比 边成了环形的数组 也就是说有两种情况
 *      1.最大子数组和在中间 无环 2.最大子数组和=左边连续子数组+右边连续子数组 带环
 *      求解第一种情况时 只要sum>0 就直接把右边界限往后移 当前最大
 *      大于已经保存的最大和时 更新边界范围 第二种情况就比较trick了 直接看起来不太好求
 *      换个思维 求出中间子数组最小的和curSum 用数组总和totalSum-curSum 看是否大于max
 *      大于则更新范围 [end+1, start-1] 再解释一下判断条件 要满足左边部分[ll,lr] 右边
 *      部分[rl,rr]的和最大 就要求中间的区间[lr,rl]最小(sum<0) 如果区间[lr,rl]不小于0
 *      就说明 中间还有某部分数的和sum至少是大于等于0 此时就不满足区间[lr,rl]为最小区间
 *      需要更新sum为当前添加进来的数
 */
public class Test403 {

    public List<Integer> continuousSubarraySumII(int[] A) {
        // write your code here
        int max=Integer.MIN_VALUE, start=0, end=0;
        int totalSum = 0, curSum = 0;
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        for (int i=0;i<A.length;i++) {
            totalSum += A[i];
            if (curSum < 0) {
                curSum = A[i];
                start = end = i;
            } else {
                curSum += A[i];
                end = i;
            }
            if (curSum > max) {
                max = curSum;
                result.set(0, start);
                result.set(1, end);
            }
        }
        start = end = 0;
        for (int i=0;i<A.length;i++) {
            if (curSum > 0) {
                curSum = A[i];
                start = end = i;
            } else {
                curSum += A[i];
                end = i;
            }
            if (start==0 && end==A.length-1) continue;
            if (totalSum - curSum > max) {
                max = totalSum - curSum;
                result.set(0, end+1%A.length);
                result.set(1, (start-1+A.length)%A.length);
            }
        }
        return result;
    }
}
