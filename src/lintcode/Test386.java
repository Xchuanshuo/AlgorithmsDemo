package lintcode;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-27.
 * @description longest-substring-with-at-most-k-distinct-characters
 */
public class Test386 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int result=0, left=0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right=0;right<s.length();right++) {
            map.put(s.charAt(right), right);
            while (map.size()>k) {
                char leftChar = s.charAt(left);
                if (map.get(leftChar)==left) {
                    map.remove(leftChar);
                }
                left++;
            }
            int length = right-left+1;
            result = Math.max(result, length);
        }
        return result;
    }

    public static void main(String[] args) {
        Test386 test = new Test386();
        System.out.println(test.lengthOfLongestSubstringKDistinct("eceba", 3));
    }
}
