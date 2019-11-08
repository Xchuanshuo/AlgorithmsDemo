import java.util.*;

/**
 * @author Legend
 * @data by on 19-8-16.
 * @description
 */
public class Test {

    private static List<List<Integer>> results = new ArrayList<>();
    private static Set<String> set = new HashSet<>();

    public void calculateGroup(int min, int max, int sum, int m) {
        for (int i = min;i <= max;i++) {
            helper(i, sum, m, new ArrayList<>());
        }
    }

    private void helper(int n, int sum, int m,
                        List<Integer> tempList) {
        if (tempList.size() == n) {
            if (sum == 0) {
                List<Integer> newList = new ArrayList<>(tempList);
                String str = sortAndFormat(newList);
                if (!set.contains(str)) {
                    set.add(str);
                    results.add(new ArrayList<>(tempList));
                }
            }
            return;
        }
        for (int i = 1;i <= m;i++) {
            tempList.add(i);
            helper(n, sum - i, m, tempList);
            tempList.remove(tempList.size()-1);
        }
    }

    private String sortAndFormat(List<Integer> list) {
        Collections.sort(list);
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < list.size();i++) {
            if (list.get(i) == 0) continue;
            builder.append(list.get(i));
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Test test = new Test();
        // K = 10  N = 4  M = 5
        test.calculateGroup(10/5, 4, 10, 5);
        for (List<Integer> list : results) {
            System.out.println(list);
        }
    }
}
