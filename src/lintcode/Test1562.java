package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-5-3.
 * @description number-of-restaurants
 * idea:
 *      题目的描述实在是坑... 进入正题 首先用最大堆 堆里面元素大于n时 就进行poll操作 这样保证了
 *      堆里面留着的是最近的n个餐厅 然后对n个餐厅按照 原来的位置index进行排序 即可得出最终结果
 */
public class Test1562 {

    public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        if (restaurant==null || restaurant.size() < n) return new ArrayList<>();
        Queue<Helper> pq = new PriorityQueue<>((o1, o2) -> dis(o2.x, o2.y) - dis(o1.x, o1.y));
        for (int i = 0;i < restaurant.size();i++) {
            pq.offer(new Helper(restaurant.get(i), i));
            if (pq.size() > n) pq.poll();
        }
        List<Helper> list = new ArrayList<>(pq);
        list.sort(Comparator.comparingInt(o -> o.index));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i < list.size();i++) {
            Helper helper = list.get(i);
            result.add(Arrays.asList(helper.x, helper.y));
        }
        return result;
    }

    class Helper {
        int x, y, index;
        Helper(List<Integer> list, int index) {
            this.x = list.get(0);
            this.y = list.get(1);
            this.index = index;
        }
    }

    private int dis(int x, int y) {
        return x*x + y*y;
    }

}
