package lintcode;

/**
 * @author Legend
 * @data by on 18-12-7.
 * @description gas-station
 */
public class Test187 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        int index = 0, sum = 0, total = 0;
        for (int i=0;i<gas.length;i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i+1;
            }
        }
        return total<0?-1:index;
    }
}
