package graph.algorithm.minspantree.test;

import graph.algorithm.minspantree.LazyPrimMST;
import graph.algorithm.minspantree.PrimMST;
import graph.base.Edge;
import graph.base.ReadWeightedGraph;
import graph.base.SparseWeightedGraph;

import java.util.Vector;

/**
 * @author Legend
 * @data by on 18-12-2.
 * @description
 */
public class PrimMSTTest {

    public static void main(String[] args) {
        String fileName = "/home/legend/Projects/IdeaProjects/AlgorithmsDemo/src/graph/largeEWG.txt";
        int V = 1000000;
        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, fileName);
        long start = System.currentTimeMillis();
        System.out.println("Test Prim MST:");
        PrimMST<Double> primMST = new PrimMST<>(g);
        Vector<Edge<Double>> mst = primMST.getMst();
        for (int i=0;i<mst.size();i++) {
            System.out.println(mst.elementAt(i));
        }
        System.out.println("The MST weight is: " + primMST.result());
        long endTime = System.currentTimeMillis();
        System.out.println("The Prim cost: "+(endTime-start)+"ms");
        System.out.println();
    }
}
