package graph.algorithm.astart;

/**
 * @author Legend
 * @data by on 18-10-3.
 * @description
 */
public class Node implements Comparable<Node> {

    public Point point;
    // 父亲节点
    public Node parent;
    // 准确值 起点到当前节点的代价
    public int G = 0;
    // 估值 当前节点到目标节点的估计代价
    public int H = 0;

    public Node(int x, int y) {
        this.point = new Point(x, y);
    }

    public Node(Point point, Node parent, int g, int h) {
        this.point = point;
        this.parent = parent;
        G = g;
        H = h;
    }

    @Override
    public int compareTo(Node o) {
        if (o == null) return -1;
        if (G+H > o.G + o.H) return 1;
        else if (G+H < o.G + o.H) return -1;
        return 0;
    }
}
