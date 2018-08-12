package graph.base;

/**
 * @author Legend
 * @create 2018-05-19 上午8:40
 **/

public interface WeightGraph<Weight extends Number & Comparable> {
    public int V();
    public int E();
    public void addEdge(Edge<Weight> e);
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Edge<Weight>> adj(int v);
}
