package lintcode;

/**
 * @author Legend
 * @data by on 18-10-2.
 * @description judge-the-last-number
 * idea:
 *      如果为1就跳两位 为0就跳一位 到最后时 如果跳出去就说明结尾肯定
 *      是两位的 如果没有跳出去 就说明长度为1位.
 */
public class Test1459 {

    public int judgeTheLastNumber(String str) {
        // Write your code here
        int k = 0;
        while (k < str.length()-1) {
            if (str.charAt(k) == '1') {
                k += 2;
            } else {
                k++;
            }
        }
        return k>=str.length()?2: 1;
    }

}
