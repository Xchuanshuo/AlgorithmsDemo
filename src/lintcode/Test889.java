package lintcode;

/**
 * @author Legend
 * @data by on 18-9-5.
 * @description sentence-screen-fitting
 * idea:
 *      用三个指针分别去记录行、列以及当前遍历到数组的位置 能刚好组成一行的条件是
 *      遍历数组后总长度刚好为列长度 也就是在可以加一些空格的情况下 满足这个条件
 */
public class Test889 {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        // Write your code here
        int r = 0, c = 0,p = 0;
        int result = 0;
        while (r < rows) {
            while (c < cols) {
                String cur = sentence[p];
                if (c+cur.length()<=cols) {
                    p++;
                    c = c + cur.length();
                } else {
                    break;
                }
                c++;
                if (p == sentence.length) {
                    result++;
                    p = 0;
                }
            }
            c = 0;
            r++;
        }
        return result;
    }
}
