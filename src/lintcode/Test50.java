package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-10-7.
 * @description product-of-array-exclude-itself
 *
 */
public class Test50 {

    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> result = new ArrayList<>();
        for (int i=0;i < nums.size();i++) {
            long temp = 1;
            for  (int j=0;j < nums.size();j++) {
                if ( i!=j) {
                    temp *= nums.get(j);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
