package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-3.
 * @description ask-for-cooling-time
 * idea:
 *      正常情况下每个技能需要1秒释放时间 使用map来保存上次释放该技能时的总
 *      时间 如果之前释放的时间+冷却时间>当前时间 就说明技能还在冷却期 此时
 *      直接等待(更新)当前时间为冷却后的时间 然后继续正常释放技能 同样使用
 *      map保存 直到技能全部释放完
 */
public class Test1467 {

    public int askForCoolingTime(int[] arr, int n) {
        // Write your code here
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int i=0;i<arr.length;i++) {
            if (map.containsKey(arr[i])) {
                if (map.get(arr[i])+n > result) {
                    result = map.get(arr[i]) + n;
                }
            }
            result++;
            map.put(arr[i], result);
        }
        return result;
    }
}
