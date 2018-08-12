package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-17.
 * @description
 */
public class Test4 {

    public int nthUglyNumber(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        list.add(1);
        // 分别对应２,３,５的情况
        int i=0, j=0, k=0;
        while (list.size()<n) {
            int l2 = list.get(i)*2;
            int l3 = list.get(j)*3;
            int l5 = list.get(k)*5;
            int temp = Math.min(Math.min(l2,l3),l5);
            list.add(temp);
            if (temp == l2) i++;
            if (temp == l3) j++;
            if (temp == l5) k++;
        }
        return list.get(n-1);
    }

    public static void main(String[] args) {

    }
}
