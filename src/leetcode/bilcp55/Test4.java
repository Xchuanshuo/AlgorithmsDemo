package leetcode.bilcp55;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-6-26.
 * @description
 */
public class Test4 {

    class MovieRentingSystem {

        Map<Integer, TreeSet<int[]>> unRentMap = new HashMap<>();
        TreeSet<int[]> rentedSet;
        Map<String, int[]> map = new HashMap<>();
        public MovieRentingSystem(int n, int[][] entries) {
            rentedSet = new TreeSet<>((o1, o2) -> {
                if (o1[2] == o2[2]) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            });
            for (int[] e : entries) {
                if (!unRentMap.containsKey(e[1])) {
                    unRentMap.put(e[1], new TreeSet<>((o1, o2) -> {
                        if (o1[2] == o2[2]) {
                            return o1[0] - o2[0];
                        }
                        return o1[2] - o2[2];
                    }));
                }
                String key = e[0] + "_" + e[1];
                map.put(key, e);
                unRentMap.get(e[1]).add(e);
            }
        }

        public List<Integer> search(int movie) {
            TreeSet<int[]> movieSet = unRentMap.get(movie);
            List<Integer> list = new LinkedList<>();
            if (movieSet == null) return list;
            Iterator<int[]> iterator = movieSet.iterator();
            for (int i = 0;i < 5;i++) {
                if (!iterator.hasNext()) break;
                int[] cur = iterator.next();
                list.add(cur[0]);
            }
            return list;
        }

        public void rent(int shop, int movie) {
            int[] key = map.get(shop + "_" + movie);
            TreeSet<int[]> movieSet = unRentMap.get(movie);
            movieSet.remove(key);
            rentedSet.add(key);
        }

        public void drop(int shop, int movie) {
            int[] key = map.get(shop + "_" + movie);
            TreeSet<int[]> movieSet = unRentMap.get(movie);
            if (movieSet == null) return;
            movieSet.add(key);
            rentedSet.remove(key);
        }

        public List<List<Integer>> report() {
            Iterator<int[]> iterator = rentedSet.iterator();
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0;i < 5;i++) {
                if (!iterator.hasNext()) break;
                int[] cur = iterator.next();
                result.add(Arrays.asList(cur[0], cur[1]));
            }
            return result;
        }
    }
}
