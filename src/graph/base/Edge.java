package graph.base;

/**
 * 边
 *
 * @author Legend
 * @create 2018-05-19 上午8:27
 **/

public class Edge<Weight extends Number & Comparable> implements Comparable<Edge<Weight>> {

    // 边的两个端点
    private int a, b;
    // 边的权重
    private Weight weight;

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> e) {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }

    public int v() { return a;}
    public int w() { return b;}
    public Weight wt() { return  weight;}

    // 给定一个顶点　返回另一个顶点
    public int other(int x) {
        assert x == a|| x ==b;
        return x == a ? b : a;
    }

    @Override
    public String toString() {
        return ""+a+"-"+b+": "+weight;
    }

    @Override
    public int compareTo(Edge<Weight> o) {
        if (weight.compareTo(o.wt()) < 0) {
            return -1;
        } else if (weight.compareTo(o.wt()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
