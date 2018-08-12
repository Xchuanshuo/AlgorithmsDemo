package lintcode;

import java.awt.print.Pageable;
import java.util.*;

/**
 * @author Legend
 * @data by on 18-7-28.
 * @description alien-dictionary
 */
public class Test892 {

    public String alienOrder(String[] words) {
        // Write your code here
        Map<Character, HashSet<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String str: words) {
            for (char c: str.toCharArray()) {
                graph.put(c, new HashSet<>());
                inDegree.put(c, 0);
            }
        }
        for (int i=1;i<words.length;i++) {
            char[] word1 = words[i-1].toCharArray();
            char[] word2 = words[i].toCharArray();
            for (int j=0;j<Math.min(word1.length, word2.length);j++) {
                char c1 = word1[j];
                char c2 = word2[j];
                if (c1 != c2) {
                    if (graph.get(c1).add(c2)) {
                        inDegree.put(c2, inDegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry: inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()) {
            char cur = queue.poll();
            result.append(cur);
            for (char c: graph.get(cur)) {
                inDegree.put(c, inDegree.get(c)-1);
                if (inDegree.get(c) == 0) {
                    queue.offer(c);
                }
            }
        }
        if (result.length() == inDegree.size()) {
            return result.toString();
        }
        return "";
    }
}
