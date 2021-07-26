package leetcode.twolcp52;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class Test5742 {

    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        Arrays.sort(strs, Comparator.comparingInt(s2 -> s2.charAt(s2.length() - 1)));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str, 0, str.length() - 1).append(" ");
        }
        return sb.toString().trim();
    }
}
