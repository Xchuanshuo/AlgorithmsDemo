package acwing;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-22.
 * @description https://www.acwing.com/problem/content/description/3778/
 */
public class Test3775 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int t = 0;t < T;t++) {
                int n = scanner.nextInt();
                int[] arr = new int[n+1];
                boolean[] visited = new boolean[n+1];
                List<Integer> idxList = new ArrayList<>();
                for (int i = 1;i <= n;i++) {
                    int cur = scanner.nextInt();
                    if (cur == 0) idxList.add(i);
                    arr[i] = cur;
                    visited[cur] = true;
                }
                Set<Integer> valSet = new HashSet<>();
                for (int i = 1;i <= n;i++) {
                    if (!visited[i]) valSet.add(i);
                }
                solve(idxList, valSet, arr);
            }
        }
    }

    private static void solve(List<Integer> idxList, Set<Integer> valSet, int[] arr) {
        int n = arr.length;
        List<Integer> remainsIdx = new ArrayList<>();
        for (int idx : idxList) {
            if (valSet.contains(idx)) {
                arr[idx] = idx;
                valSet.remove(idx);
            } else {
                remainsIdx.add(idx);
            }
        }
        List<Integer> remains = new LinkedList<>(valSet);
        for (int idx : remainsIdx) {
            arr[idx] = remains.remove(0);
        }
        for (int i = 1;i < idxList.size();i++) {
            swap(arr, idxList.get(i), idxList.get(i - 1));
        }
        for (int i = 1;i < n;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
