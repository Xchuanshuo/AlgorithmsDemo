package graph.algorithm.minspantree;

import graph.base.Edge;
import graph.base.IndexMinHeap;
import graph.base.ReadWeightedGraph;
import graph.base.WeightGraph;

import java.util.Vector;

/**
 * @author Legend
 * @data by on 18-12-2.
 * @description 使用优化的Prime算法求图的最小生成树
 */
public class PrimMST<Weight extends Number & Comparable> {

    private WeightGraph G;
    private IndexMinHeap<Weight> ipq;
    // 访问的点所对应的边
    private Edge<Weight>[] edgeTo;
    private boolean[] marked;
    private Vector<Edge<Weight>> mst;
    private Number mstWeight = 0;

    public PrimMST(WeightGraph graph) {
        G = graph;
        assert (graph.E() >= 1);
        ipq = new IndexMinHeap<>(graph.V());
        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        mst = new Vector<>();

        visit(0);
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            assert (edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }
        for (int i=0;i<mst.size();i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;

        for (Object item: G.adj(v)) {
            Edge<Weight> e = (Edge<Weight>) item;
            int w = e.other(v);
            if (!marked[w]) {
                if (edgeTo[w] == null) {
                    edgeTo[w] = e;
                    ipq.insert(w, e.wt());
                } else if (e.wt().compareTo(edgeTo[w].wt()) < 0) {
                    edgeTo[w] = e;
                    ipq.change(w, e.wt());
                }
            }
        }
    }

    public Vector<Edge<Weight>> getMst() {
        return mst;
    }

    public Number result() {
        return mstWeight;
    }
}
