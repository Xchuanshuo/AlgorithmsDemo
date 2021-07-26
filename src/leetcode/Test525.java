package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-4-21.
 * @description 525. 连续数组
 * idea:
 *      将全部0变成-1 问题转换为 求连续和为0的最大子数组
 *      使用map保存前缀和为某个值的最小位置 如果当前和在map中存在,
 *      说明当前到这最小位置的中间的和为0
 */
public class Test525 {

    public int findMaxLength(int[] nums) {
        for (int i = 0;i < nums.length;i++) if (nums[i] == 0) nums[i] = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, res = 0;
        for (int i =  0;i < nums.length;i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }

}
