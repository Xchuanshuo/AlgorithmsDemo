package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-9-14.
 * @description gray-code
 */
public class Test411 {

    public List<Integer> grayCode(int n) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        for (int i=0;i< 1<<n;i++) {
            result.add(i ^ i>>1);
        }
        return result;
    }
}
