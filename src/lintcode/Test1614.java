package lintcode;

import java.util.List;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-20.
 * @description highest-growth-stock
 */
public class Test1614 {

    public String highestGrowth(List<List<String>> Stock) {
        Helper max = new Helper("", -1);
        for (List<String> s : Stock) {
            double start = Double.parseDouble(s.get(1));
            double end = Double.parseDouble(s.get(2));
            Helper helper = new Helper(s.get(0), end/start);
            if (helper.rate > max.rate) {
                max = helper;
            }
        }
        return max.id;
    }

    class Helper {
        double rate;
        String id;
        Helper(String id, double rate) {
            this.id = id;
            this.rate = rate;
        }
    }
}
