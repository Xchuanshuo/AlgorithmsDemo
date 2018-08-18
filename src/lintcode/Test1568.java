package lintcode;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description poison-test
 * idea:
 *      题目描述一大堆　提炼出来其实很简单　假设我们一开始就知道目标　就直接把它去掉
 *      剩下的就按半分　直到没有分的为止　
 */
public class Test1568 {

    public int getAns(int n) {
        // Write your code here
        if (n<2) return 0;
        return Integer.toBinaryString(n-1).length();
    }
}
