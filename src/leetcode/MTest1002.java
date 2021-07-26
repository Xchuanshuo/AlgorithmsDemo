package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-18.
 * @description
 */
public class MTest1002 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long hash = cal(str);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> cur : map.values()) {
            Collections.sort(cur);
            result.add(cur);
        }
        return result;
    }

    private static long cal(String str) {
        char[] chs = str.toCharArray();
        int[] arr = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        long val = 1L;
        for (char c : chs) {
            val *= arr[c - 'a'];
        }
        return val;
    }
    public static void main(String[] args) {
        System.out.println(cal("lei"));
        System.out.println(cal("val"));
    }
}
