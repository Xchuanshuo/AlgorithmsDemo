package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-7-29.
 * @description https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/
 */
public class Test1104 {

    public List<Integer> pathInZigZagTree(int label) {
        int h = 1;
        while ((int)Math.pow(2, h) - 1 < label) h++;
        List<Integer> result = new ArrayList<>();
        result.add(label);
        while (h > 1) {
            int pe = (int)Math.pow(2, h - 1) - 1;
            int ps = (int)Math.pow(2, h - 2);
            int parent = pe - (label/2 - ps);
            result.add(parent);
            h--; label = parent;
        }
        Collections.sort(result);
        return result;
    }
}
