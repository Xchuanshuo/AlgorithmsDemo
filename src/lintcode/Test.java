package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-8.
 * @description
 */
public class Test {

    public int longestCommonSubstring(String A, String B) {
        int m = A.length(),n = B.length();
        int res = 0;
        int[] arr = new int[n+1];
        for (int i=0;i < m;i++) {
            for (int j=n;j>0;j--) {
                if (A.charAt(i) == B.charAt(j-1)) {
                    arr[j] = arr[j-1]+1;
                    res = Math.max(res, arr[j]);
                }
            }
        }
        return res;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        int def[] = new int[0];
        if (nums1.length == 0 || nums2.length == 0) {
            return def;
        }
        Map<Integer, Integer> maps = new HashMap<>();
        int count = 0;
        for (int i=0;i < nums1.length;i++) {
            if (maps.containsKey(nums1[i])) {
                maps.put(nums1[i], maps.get(nums1[i])+1);
            } else {
                maps.put(nums1[i], 1);
                count++;
            }
        }
        int res[] = new int[count];
        for (int i=0,j=0;i < nums2.length;i++) {
            if (maps.containsKey(nums2[i])) {
                res[j++] = nums2[i];
                maps.remove(nums2[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Test test = new Test();
        //System.out.println(test.longestCommonSubstring("abac","cab"));
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2};
        int res[] = test.intersection(nums1, nums2);
        System.out.println(res.length);
        System.out.println(res[0]);
    }

//    public static void main(String[] args) {
//        ListNode one = new ListNode(5);
//        one.next = new ListNode(10);
//        ListNode.nextNode(one);
//        System.out.println(one.val);
//        ListNode.changeVal(one);
//        System.out.println(one.val);
//    }
}
