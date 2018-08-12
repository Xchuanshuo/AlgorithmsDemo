package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-8-11.
 * @description permutation-sequence
 *  idea：
 *      总排列数是n! 每个数为首位时对应的排列数为factorial=(n-1)!
 *      所以按顺序排列 首先把k-1(数组从索引0开始)要取的第一位数是 k/factorial
 *      确定第一位数之后 第二位数 对应的排列数为factorial=(n-2)!
 *      所以此时要把k=k%(n-1)!后再 第二位数为k/factorial....
 *      以此类推 直到factorial=0！求出了最终解
 *      实现的时候需要注意：每添加一个元素 也要把这个移除
 */
public class Test388 {

    public String getPermutation(int n, int k) {
        // write your code here
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=1;i<=9;i++) list.add(i);
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i=1;i<n;i++) {
            factorial[i] = factorial[i-1] * i;
        }
        StringBuilder builder = new StringBuilder();
        k--;
        for (int i=n;i>0;i--) {
            // 当前排列所对应的位置
            int j = k/factorial[i-1];
            k %= factorial[i-1];
            builder.append(list.remove(j));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Test388 test = new Test388();
        System.out.println(test.getPermutation(3,4));
    }
}
