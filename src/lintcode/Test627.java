package lintcode;

/**
 * @author Legend
 * @data by on 18-8-16.
 * @description longest-palindrome
 * idea:
 *      构成回文串 条件就是 除了为奇数个时中间的数外 每个字符数目相等
 *      首先统计每个字符出现的个数 接着遍历字符出现的次数
 *      所以如果当前是偶数个数 直接加到结果中去 如果是奇数个数
 *      且遍历到的字符个数为奇数的话 就把最大长度+1
 */
public class Test627 {

    public int longestPalindrome(String s) {
        // write your code here
        int[] count = new int[128];
        for (char c: s.toCharArray()) count[c]++;
        int result = 0;
        for (int i: count) {
            result += i/2*2;
            if (result%2==0 && i%2==1) {
                result++;
            }
        }
        return result;
    }
}
