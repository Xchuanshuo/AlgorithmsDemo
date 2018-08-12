package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-6-29.
 * @description name-deduplication
 */
public class Test487 {

    public List<String> nameDeduplication(String[] names) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (null == names || names.length==0) {
            return result;
        }
        Set<String> set = new HashSet<>();
        for (int i=0;i<names.length;i++) {
            String str = names[i].toLowerCase();
            if (set.contains(str)) {
                continue;
            } else {
                set.add(str);
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test487 test = new Test487();
        String[] names = {"James",
                "james",
                "Bill Gates",
                "bill Gates",
                "Hello World",
                "HELLO WORLD",
                "Helloworld"};
        System.out.println(test.nameDeduplication(names));
    }
}
