package lintcode;

/**
 * @author Legend
 * @data by on 19-5-5.
 * @description number-of-longest-increasing-subsequence
 * idea:
 *      dp 与LIS(Test76)相比，这里要求的是最大长度上升序列的个数 不变的 肯定要
 *      先找到最大的上升子序列长度是多少 现在问题就在于 怎么求这个长度的个数呢?
 *      这里用len[i]表示以nums[i]结尾时最大长度, count[i]表示以nums[i]
 *      结尾时 最大长度的子序列的个数. 显然 如果位置i当前的最大长度更新了(j位置)
 *      , 那么count对应位置的数量也需要重置，重置为多少呢？ 重置为更新过来的位置
 *      的数量即可 长度变了，意味着之前的序列每个数加上当前的一个数构成新的序列 个数就还是没变！
 *      如果长度没更新, 就要前面位置的个数+当前位置的个数 状态转移方程
 *      len[i] = (len[j]+1, len[i]) [0< j < i, nums[i] > nums[j])
 *      count[i] = count[j](len[i]<len[j]+1) || count[i] += count[j](len[i] = len[j]+1)
 */
public class Test1093 {

    public int findNumberOfLIS(int[] nums) {
        // Write your code here
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        int maxLen = 0, result = 0;
        for (int i = 0;i < n;i++) {
            len[i] = count[i] = 1;
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        count[i] += count[j];
                    } else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (maxLen < len[i]) {
                maxLen = len[i];
                result = count[i];
            } else if (maxLen == len[i]) {
                result += count[i];
            }
        }
        return result;
    }
}
