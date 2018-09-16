package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-9-17.
 * @description tower-of-hanoi
 * idea:
 *      经典的问题 回溯
 */
public class Test169 {

    private List<String> result;
    public List<String> towerOfHanoi(int n) {
        // write your code here
        result = new ArrayList<>();
        move('A', 'B', 'C', n);
        return result;
    }

    private void move(char first, char second, char third, int n) {
        if (n == 1) {
            result.add("from "+first+" to "+third);
            return;
        }
        move(first, third, second, n-1);
        result.add("from "+first+" to "+third);
        move(second, first, third, n-1);
    }
}
