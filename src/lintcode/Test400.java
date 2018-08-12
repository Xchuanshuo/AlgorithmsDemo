package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Legend
 * @data by on 18-6-13.
 * @description
 */
public class Test400 {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int minNum=-1, maxNum=-1, n=nums.length;
        for (int i=0; i<n; ++i) {
            minNum = min(nums[i], minNum);
            maxNum = max(nums[i], maxNum);
        }
        if (maxNum==minNum) return 0;
        double average = (maxNum-minNum)*1.0/(n-1);
        if (average == 0) average++;
        int[] localMin = new int[n];
        int[] localMax = new int[n];
        //　赋初值
        for (int i=0;i < n;i++) {
            localMin[i] = -1;
            localMax[i] = -1;
        }
        // 对存在的数赋值
        for (int i=0;i < n;i++) {
            int t = (int)((nums[i]-minNum)/average);
            localMin[t] = min(localMin[t], nums[i]);
            localMax[t] = max(localMax[t], nums[i]);
        }
        int res= (int)average, left=0, right=1;
        while (left < n-1) {
            while (right<n && localMin[right]==-1) ++right;
            if (right>=n) break;
            res = max(res, localMin[right]-localMax[left]);
            left = right++;
        }
        return res;
    }

    public int max(int a, int b) {
       if (a == -1) {
           return b;
       }
       if (b == -1)
           return a;
       if (a < b) return b; else return a;
    }

    public int min(int a, int b) {
        if (a == -1) {
            return b;
        }
        if (b == -1)
            return a;
        if (a < b) return a; else return b;
    }

    public static void main(String[] args) {
        Test400 test = new Test400();
        int[] nums = {
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(test.maximumGap(nums));
    }
}
