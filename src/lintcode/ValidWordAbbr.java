package lintcode;

import java.util.HashSet;
import java.util.Set;

public class ValidWordAbbr {
    /*
    * @param dictionary: a list of words
    */
    private Set<String> set;
    public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        set = new HashSet<>();
        for (String str: dictionary) {
            StringBuilder builder = new StringBuilder();
            if (str.length()>2) {
                builder.append(str.charAt(0));
                builder.append(str.length()-2);
                builder.append(str.charAt(str.length()-1));
            } else {
                builder.append(str);
            }
            String cur = builder.toString();
            if (!set.contains(cur)) {
                set.add(cur);
            }
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        StringBuilder builder = new StringBuilder();
        if (word.length()>2) {
            builder.append(word.charAt(0));
            builder.append(word.length()-2);
            builder.append(word.charAt(word.length()-1));
        } else {
            builder.append(word);
        }
        String cur = builder.toString();
        if (set.contains(cur)) {
            return false;
        }
        return true;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */