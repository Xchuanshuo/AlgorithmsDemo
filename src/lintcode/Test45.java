package lintcode;

/**
 * @author Legend
 * @data by on 18-6-16.
 * @description
 */
public class Test45 {

    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int[] leftMins = new int[nums.length];
        int[] leftMaxs = new int[nums.length];
        int[] rightMins = new int[nums.length];
        int[] rightMaxs = new int[nums.length];
        leftMins[0] = nums[0];
        leftMaxs[0] = nums[0];
        rightMins[nums.length-1] = nums[nums.length-1];
        rightMaxs[nums.length-1] = nums[nums.length-1];
        int leftSum = nums[0], rightSum = nums[nums.length-1];
        int leftMin=0, leftMax=0, rightMin=0, rightMax=0;
        for (int i=1;i < nums.length;i++) {
            leftMin = Math.min(leftMin, leftSum);
            leftMax = Math.max(leftMax, leftSum);
            leftSum += nums[i];
            leftMins[i] = Math.min(leftMins[i-1], leftSum-leftMax);
            leftMaxs[i] = Math.max(leftMaxs[i-1], leftSum-leftMin);
        }

        for (int i=nums.length-2;i>=0;i--) {
            rightMin = Math.min(rightMin, rightSum);
            rightMax = Math.max(rightMax, rightSum);
            rightSum += nums[i];
            rightMins[i] = Math.min(rightMins[i+1], rightSum-rightMax);
            rightMaxs[i] = Math.max(rightMaxs[i+1], rightSum-rightMin);
        }
        int result = Integer.MIN_VALUE;
        for (int i=0;i < nums.length-1;i++) {
            result = Math.max(result, Math.max(Math.abs(rightMaxs[i+1]-leftMins[i])
                                    ,Math.abs(leftMaxs[i]-rightMins[i+1])));
        }
        return result;
    }

    public static void main(String[] args) {
        Test45 test = new Test45();
        int[] ints = {100,-2,-3,-100,-1,-50};
        System.out.println(test.maxDiffSubArrays(ints));
    }
}
