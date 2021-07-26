package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Legend
 * @data by on 21-4-17.
 * @description https://leetcode-cn.com/problems/contains-duplicate-iii/
 * idea:
 *      解法1 维护一个大小为k的滑动窗口,则窗口内元素满足abs(i-j)<=k
 *      对于当前元素i 需要满足 abs(nums[i]-nums[j])<=t => 求出窗口内大于等于nums[i]-t的最小元素
 *      接着用当前元素与求出的元素相减求出绝对值看是否满足 <= t
 *
 *      解法2 利用桶排序的思想 首先不考虑条件abs(i-j)<=k, 要使元素abs(nums[i]-nums[j]) <= t
 *      只需要将每个元素分配到容量大小为(t+1)的桶, 如t=2时 每个桶分别为-3 - -1, 0-2, 2-5, 6-8
 *      对于当前元素, 如果在桶中已经存在其它元素，那么说明存在元素满足abs(nums[i]-nums[j])<=t条件
 *      若不存在该桶, 因为每个桶大小为t+1, 要满足条件, 元素只可能存在当前元素所在桶[左右相邻]的两个桶中
 *      直接比较两个桶中的元素是否满足条件即可
 *
 *      对于大小为k的窗口, 直接根据已经使用的桶数量进行处理 即当使用的桶的数量大于k时, 移除掉最左边元素所在的桶
 */
public class Test220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) return false;
        TreeSet<Long> set = new TreeSet<>();
        // 1 2 3 1
        for (int i = 0;i < nums.length;i++) {
            if (set.size() > k) {
                set.remove((long)nums[i-1-k]);
            }
            Long low = set.ceiling((long) (nums[i] - t));
            if (low != null && Math.abs(nums[i] - low) <= t) {
                return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) return false;
        Map<Long, Long> map = new HashMap<>();
        int w = t + 1;
        for (int i = 0;i < nums.length;i++) {
            if (map.size() > k) {
                map.remove(getId(nums[i-k-1], w));
            }
            long id = getId(nums[i], w);
            if (map.containsKey(id)) return true;
            if (map.containsKey(id + 1) && map.get(id + 1) - nums[i] <= t) {
                return true;
            }
            if (map.containsKey(id - 1) && nums[i] - map.get(id - 1) <= t) {
                return true;
            }
            map.put(id, (long) nums[i]);
        }
        return false;
    }

    private long getId(long num, long w) {
        if (num >= 0) return num / w;
        return (num + 1) / w - 1;
    }
}
