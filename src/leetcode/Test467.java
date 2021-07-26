package leetcode;

/**
 * @author Legend
 * @data by on 21-5-4.
 * @description https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string/
 * idea:
 *      记录以每个字符结尾的字符串个数, 假设字符串中有k满足环绕字符串的 连续的字母 以该字符串结尾的
 *      序列就有多少个 即 前k-1个字符每个字符开始+当前字符, 都能构成一个新的字符串, 最后 + 当前字符
 *      可以构成1个长度为1的序列, 总共是k-1+1=k个, 因为可能存在重复字符, 对于同一个字符结尾的 只需要
 *      取连续最长的字符串即可, 比它短的字符串一定包含在较长的里面了
 */
public class Test467 {

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] chars = p.toCharArray();
        int cnt = 1;
        for (int i = 0;i < chars.length;i++) {
            if (i > 0 && isNext(chars[i-1], chars[i])) {
                cnt++;
            } else {
                cnt = 1;
            }
            dp[chars[i]-'a'] = Math.max(dp[chars[i] - 'a'], cnt);
        }
        int res = 0;
        for (int d : dp) res += d;
        return res;
    }

    private boolean isNext(char c1, char c2) {
        if (c1 == 'z') return c2 == 'a';
        return c1 + 1 == c2;
    }
}
