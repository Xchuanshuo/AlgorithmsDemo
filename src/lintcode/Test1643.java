package lintcode;

/**
 * @author Legend
 * @data by on 18-12-5.
 * @description pick-fruits
 */
public class Test1643 {

    public int pickFruits(int[] arr) {
        // Write your code here.
        int p1=0,p2=0,p3=0;
        int max = Integer.MIN_VALUE;
        for (int i=1;i<arr.length;i++) {
            if (arr[i]==arr[p1] || arr[i]==arr[p2]) {
                if (arr[i] != arr[i-1]) p3 = i;
            } else {
                if (p1 != p2) p1 = p3;
                p2 = p3 = i;
            }
            max = Math.max(max, i-p1+1);
        }
        return max;
    }
}
