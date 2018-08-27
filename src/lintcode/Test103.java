package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-27.
 * @description largest-divisible-subset
 * idea:
 *      dp 这道题和LIS有点像 这里求最大整除子集 因为较大的数肯定是能整除较小的数的
 *      所以先进行排序 这样只要当前数能被整除 那么比它小的数也能被整除 所以用dp[i]表示
 *      0..i个位置最大的整除子集的长度 当到达一个位置i时 我们总是需要看看前面的0..i个位置
 *      哪些是能被整除的 然后更新dp[i] 可能会出现一些情况 如 1 2 4 8 9 72这几个数 当我们
 *      到达dp[5] 也就是72的位置时 往前遍历 发现9能被72整除 而dp[4]=2 所以此时更新
 *      dp[5]=max(1, 2+1)=3 但继续往前遍历 发现8也能被72整除 且dp[3]=4>dp[5] 所以更新
 *      dp[5]=4+1=5 状态转移方程就是dp[i]=max(dp[i], dp[j]+1) 但这里不是求长度 是求具体的
 *      子集 所以还需要开辟一个数组parent来即录i的前驱的位置 如72的前驱是8所在的位置 以此类推 记录
 *      所有的前驱这里还需要注意 初始条件每个元素默认都是没有前驱的 所以初始化为-1
 **/
public class Test103 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        int maxsize=0, index=-1;
        for (int i=0;i<n;i++) {
            dp[i] = 1;
            parent[i] = -1;
            for (int j=0;j<i;j++) {
                if (nums[i]%nums[j]==0 && dp[i]<dp[j]+1) {
                    dp[i] = dp[j]+1;
                    parent[i] = j;
                }
            }
            if (dp[i]>maxsize) {
                maxsize = dp[i];
                index = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while (index != -1) {
            result.add(nums[index]);
            index = parent[index];
        }
        return result;
    }
}
