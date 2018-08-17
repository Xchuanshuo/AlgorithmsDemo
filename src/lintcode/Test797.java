package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description reach-a-number
 * idea:
 *      这里需要数学方法 可以看看这个链接 写的非常明确了
 *      https://www.lintcode.com/problem/reach-a-number/note/144337
 */
public class Test797 {

    public int reachNumber(int target) {
        // Write your code here
        target = Math.abs(target);
        int result = 0, n = 0;
        while (result<target) {
            n++;
            result += n;
        }
        if (result==target) return n;
        int dif = result - target;
        if ((dif&1) == 0) return n;
        return n + ((n&1) == 0?1 : 2);
    }
}
