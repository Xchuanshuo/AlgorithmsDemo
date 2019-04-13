package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 19-4-13.
 * @description rectangle
 * idea:
 *      使用一个hash表保存点xy坐标构成的字符串 选择两个点计算斜率 满足斜率为1或-1
 *      则表明两点是矩形的对角线两端点 然后再去表hash表, 看构成矩形的另外两个点是否存在
 */
public class Test820 {

    public String rectangle(Point[] pointSet) {
        if (pointSet == null || pointSet.length == 0) {
            return "NO";
        }
        Set<String> set = new HashSet<>();
        for (Point point : pointSet) {
            set.add(point.x + "-" + point.y);
        }
        for (int i = 0;i < pointSet.length;i++) {
            for (int j = i+1;j < pointSet.length;j++) {
                int dx = pointSet[j].x - pointSet[i].x;
                if (dx != 0) {
                    int k = Math.abs((pointSet[j].y - pointSet[i].y) / dx);
                    if (k == 1) {
                        if (set.contains(pointSet[i].x+"-"+pointSet[j].y)
                                && set.contains(pointSet[j].x+"-"+pointSet[i].y)) {
                            return "YES";
                        }
                    }
                }
            }
        }
        return "NO";
    }
}
