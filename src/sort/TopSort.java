package sort;


import java.util.*;


// top排序 所有路径
public class TopSort {

    private static Set<Integer> res = new TreeSet<>();
    private static void solve(List<List<Integer>> graphs, int n, int t) {
        int[] degree = new int[n + 1];
        for (List<Integer> g : graphs) {
            for (int v : g) degree[v]++;
        }
        List<Integer> start = new LinkedList<>();
        for (int i = 1;i <= n;i++) {
            if (degree[i] == 0) {
                start.add(i);
            }
        }
        helper(graphs, degree, start, t, 1);
    }

    private static void helper(List<List<Integer>> graphs,
                               int[] d, List<Integer> next,
                               int t, int rank) {
        for (int i = 0;i < next.size();i++) {
            Integer v = next.get(i);
            List<Integer> temp = new ArrayList<>(next);
            int[] degree = Arrays.copyOfRange(d, 0, d.length);
            temp.remove(v);
            if (v == t) {
                if (res.contains(rank)) break;
                res.add(rank);
            }
            for (int w : graphs.get(v)) {
                degree[w]--;
                if (degree[w] == 0) temp.add(w);
            }
            helper(graphs, degree, temp, t, rank + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int t = scanner.nextInt();
            List<List<Integer>> graphs = new LinkedList<>();
            for (int i = 0;i <= n + 1;i++) {
                graphs.add(new LinkedList<>());
            }
            for (int i = 0;i < m;i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                graphs.get(v).add(w);
            }
            solve(graphs, n, t);
            for (int r : res) {
                System.out.print(r + " ");
            }
        }
    }
}
