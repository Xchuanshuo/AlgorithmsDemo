package graph.algorithm.astart;

/**
 * @author Legend
 * @data by on 18-10-3.
 * @description
 */
public class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Point) {
            Point point = (Point) obj;
            return x==point.x && y==point.y;
        }
        return false;
    }
}
