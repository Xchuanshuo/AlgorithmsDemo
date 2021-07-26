package aliyun;


import java.util.*;

/**
 * @author Legend
 * @data by on 21-4-8.
 * @description https://developer.aliyun.com/coding/85
 */
public class Test85 {

    public int solution(int n, int[] a) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0;i < a.length;i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], new LinkedList<>());
            }
            map.get(a[i]).add(i);
        }
        int[] state = new int[n];
        int res = 0;
        Arrays.sort(a);
        for (int i = 0;i < a.length;i++) {
            int idx = map.get(a[i]).remove(0);
            if (idx + 1 < n && state[idx+1] != -1) {
                res = Math.max(res, a[i]);
            } else if (idx + 2 < n && state[idx+2] != -1) {
                res = Math.max(res, a[i]);
            }
            state[idx] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] a = {10, 3, 5, 10};
        Test85 test85 = new Test85();
        int res = test85.solution(n, a);
        System.out.println(res);
    }
}
