package lintcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-7-2.
 * @description number-of-airplanes-in-the-sky
 */
public class Test391 {

    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (null==airplanes || airplanes.size()==0) return 0;
        int[] starts = new int[airplanes.size()];
        int[] ends = new int[airplanes.size()];
        for (int i=0;i<airplanes.size();i++) {
            starts[i] = airplanes.get(i).start;
            ends[i] = airplanes.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int count=0, result=0;
        int i=0, j=0;
        while (i<airplanes.size() && j<airplanes.size()) {
            if (starts[i]<ends[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
