package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-6-22.
 * @description https://leetcode-cn.com/problems/binary-watch/
 */
public class Test401 {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int i = 0;i <= 11;i++) {
            for (int j = 0;j <= 59;j++) {
                int val = Integer.bitCount(i) + Integer.bitCount(j);
                if (val == turnedOn) {
                    result.add(i + ":" + String.format("%02d", j));
                }
            }
        }
        return result;
    }
}
