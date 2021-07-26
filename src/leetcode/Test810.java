package leetcode;

/**
 * @author Legend
 * @data by on 21-5-22.
 * @description https://leetcode-cn.com/problems/chalkboard-xor-game/
 */
public class Test810 {

    public boolean xorGame(int[] nums) {
        int n = nums.length;
        int total = 0 ;
        for (int num : nums) total ^= num;
        return total == 0 || n%2==0 ;
    }
}
