package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-9-30.
 * @description flip-game
 */
public class Test914 {

    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (s==null || s.length()==0) {
            return result;
        }
        for (int i=0;i<s.length()-1;i++) {
            if (s.charAt(i)=='+' && s.charAt(i+1)=='+') {
                result.add(s.substring(0, i)+"--"+s.substring(i+2, s.length()));
            }
        }
        return result;
    }
}
