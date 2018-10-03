package graph.base;

/**
 * 加权有向边
 *
 * @author Legend
 * @create 2018-05-19 上午8:05
 **/

public class DirectedEdge {

    // 边的起点
    private final int v;
    // 边的终点
    private final int w;
    // 边的权重
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    // 指向这条边的顶点
    public int from() {
        return v;
    }

    // 这条边指向的顶点
    public int to() {
        return w;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}

