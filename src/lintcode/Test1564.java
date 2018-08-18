package lintcode;

import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description interval-search
 */
public class Test1564 {

    public String isInterval(List<List<Integer>> intervalList, int number) {
        // Write your code here
        for (List<Integer> list: intervalList) {
            if (number>=list.get(0) && number<=list.get(1)) return "True";
        }
        return "False";
    }
}
