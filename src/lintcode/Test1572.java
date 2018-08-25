package lintcode;

/**
 * @author Legend
 * @data by on 18-8-25.
 * @description asking-for-the-longest-01-substring
 * idea:
 *      也是挺trick的一道题 可以断开同时翻转就相当于拼接两段同样的字符串 以1001为例
 *      拼接两段就是10011001 它就包含了原字符串每个字符都断开进行翻转的情况
 *      1|001->1|100、10|01->0110、100|1->0011 每个都包含拼接后的字符串里面
 *      发现这个规律 问题就简单了
 */
public class Test1572 {

    public int askingForTheLongest01Substring(String str) {
        // Write your code here
        int n = str.length(), result=0, count=0;
        for (int i=0;i<2*n;i++) {
            if (i>0 && str.charAt((i-1)%n) != str.charAt(i%n)) {
                count++;
            } else {
                count = 1;
            }
            result = Math.max(result, Math.min(count, n));
        }
        return result;
    }
}
