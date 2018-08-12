package lintcode;

/**
 * @author Legend
 * @data by on 18-6-16.
 * @description
 */
public class Test191 {

    public int maxProduct(int[] nums) {
        // write your code here
        if (null == nums || nums.length == 0) return 0;
        int minPre=nums[0], maxPre=nums[0];
        int min=nums[0], max=nums[0];
        int res = Integer.MIN_VALUE;
        for (int i=1;i < nums.length;i++) {
            min = Math.min(nums[i], Math.min(minPre*nums[i], maxPre*nums[i]));
            max = Math.max(nums[i], Math.max(minPre*nums[i], maxPre*nums[i]));
            res = Math.max(res, max);
            minPre = min;
            maxPre = max;
        }
        return res;
    }

    public static void main(String[] args) {
        Test191 test = new Test191();
        int[] ints = {2,3,-2,4};
        System.out.println(test.maxProduct(ints));
    }
}
