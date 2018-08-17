package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description shortest-palindrome
 * idea:
 *      这道题就是一个trick 一个字符串添加字符使它成为回文串 最差情况下
 *      就是原字符都不相等 添加的个数就是原字符串出掉首位后后面字符串的翻转
 *      于是首先就保存一份原字符串的翻转 然后判断原字符串的开头是否包含翻转了的字符串内
 *      某个位置往后的全部字符 包含就说明这两段整反序列都相等 所以这个位置往前的字符与
 *      原字符串一起构成回文序列 下面以abcd为例
 *      original:abcd 遍历整个字符串 知道遍历到reverse中b的位置为止
 *       reverse:dcba 它后面的字符a与original中开始的a相等 则所求的回文串就为dcbabcd
 */
public class Test678 {

    public String convertPalindrome(String str) {
        // Write your code here
        String reverseStr = new StringBuilder(str).reverse().toString();
        for (int i=0;i<str.length();i++) {
            if (str.startsWith(reverseStr.substring(i))) {
                return reverseStr.substring(0, i)+str;
            }
        }
        return "";
    }
}
