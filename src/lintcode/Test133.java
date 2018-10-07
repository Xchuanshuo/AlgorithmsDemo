package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-14.
 * @description
 */
public class Test133 {

    public List<String> longestWords(String[] dictionary) {
        // write your code here
        Map<Integer, ArrayList<String>> maps = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i=0;i < dictionary.length;i++) {
            String cur = dictionary[i];
            if (maps.containsKey(cur.length())) {
                maps.put(cur.length(), maps.get(cur.length())).add(cur);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(cur);
                maps.put(cur.length(), list);
            }
            max = Math.max(max, cur.length());
        }

        return maps.get(max);
    }

    public static void main(String[] args) {
        String[] dictionary = {
                "dog",
                "google",
                "facebook",
                "internationalization",
                "blabla"
        };
        Test133 test = new Test133();
        List<String> list = test.longestWords(dictionary);
        for (String str: list) {
            System.out.print(str+" ");
        }
    }
}
