package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-8-11.
 * @description minimumstring
 */
public class Test1560 {

    public String MinimumString(char[] s, int k) {
        // Write your code here
        int n = s.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(s[a]==s[b]?a-b:s[a]-s[b]));
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<k;i++) pq.offer(i);
        for (int start=0, end=k;end<n;end++) {
            pq.offer(end);
            if (pq.peek()>start) pq.poll();
            int cur = pq.poll();
            builder.append(s[cur]);
            start = cur+1;
        }
        return builder.toString();
    }
}
