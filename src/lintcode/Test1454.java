package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-4-14.
 * @description word-frequency-count
 */
public class Test1454 {

    public String[] getWords(String s, String[] excludeList) {
        // Write your code here
        Set<String> set = new HashSet<>(Arrays.asList(excludeList));
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        String[] words = s.split("[^a-zA-Z]");
        for (String word : words) {
            word = word.trim().toLowerCase();
            if (word.equals("") || set.contains(word)) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
            count = Math.max(count, map.get(word));
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == count) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
}
