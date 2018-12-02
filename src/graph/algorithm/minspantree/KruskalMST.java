package graph.algorithm.minspantree;

import graph.base.Edge;
import graph.base.WeightGraph;
import unionfind.UF;
import unionfind.UnionFind3;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-12-2.
 * @description
 */
public class KruskalMST<Weight extends Number & Comparable> {

    private Vector<Edge<Weight>> mst;
    private Number mstWeight = 0;

    public KruskalMST(WeightGraph graph) {
        mst = new Vector<>();
        // 将图中的所有边放入最小堆中
        Queue<Edge<Weight>> pq = new PriorityQueue<>();
        for (int i=0;i<graph.V();i++) {
            for (Object item: graph.adj(i)) {
                Edge<Weight> e = (Edge<Weight>) item;
                if (e.v() <= e.w()) {
                    pq.offer(e);
                }
            }
        }
        UF uf = new UnionFind3(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V()-1) {
            Edge<Weight> e = pq.poll();
            // 如果该边的两个端点是连通的 说明加入这条边将产生环 扔掉这一条边
            if (uf.isConnected(e.v(), e.w())) continue;
            mst.add(e);
            uf.unionElements(e.v(), e.w());
        }

        for (int i=0;i<mst.size();i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    public Vector<Edge<Weight>> getMst() {
        return mst;
    }

    public Number result() {
        return mstWeight;
    }
}
