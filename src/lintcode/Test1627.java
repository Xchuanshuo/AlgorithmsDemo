package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-4-22.
 * @description word-segmentation
 */
public class Test1627 {

    public String[] wordSegmentation(String s, int k) {
        // Write your code here
        if (s == null || s.length() == 0) return new String[]{};
        String[] strings = s.split(" ");
        String pre = "";
        List<String> list = new ArrayList<>();
        for (String cur : strings) {
            int len = pre.length() + cur.length() + 1;
            if (len < k) {
                pre += " " + cur;
            } else if (len == k) {
                list.add(pre + " " + cur);
                pre = "";
            } else {
                if (pre.length() > 0) {
                    list.add(pre);
                    pre = cur;
                } else {
                    list.add(cur);
                }
            }
            pre = pre.trim();
        }
        if (pre.length() > 0) list.add(pre);
        return list.toArray(new String[]{});
    }
}
