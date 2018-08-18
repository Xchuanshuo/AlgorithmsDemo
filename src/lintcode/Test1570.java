package lintcode;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description binary-stream
 */
public class Test1570 {

    public int[] getOutput(String s) {
        // Write your code her
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i=0;i<s.length();i++) {
            sum = (sum<<1) + s.charAt(i)-'0';
            sum %= 3;
            if (sum==0) list.add(i+1);
        }
        int[] result = new int[list.size()];
        for (int i=0;i<result.length;i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Test1570 test = new Test1570();
        int[] result = test.getOutput("11011");
        for (int i: result) {
            System.out.print(i+", ");
        }
    }
}
