package graph.algorithm.astart.test;

import graph.algorithm.astart.AStar;
import graph.algorithm.astart.MapInfo;
import graph.algorithm.astart.Node;

/**
 * @author Legend
 * @data by on 18-10-3.
 * @description
 */
public class Test {

    public static void main(String[] args) {
        int[][] maps = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }};
        MapInfo mapInfo = new MapInfo(maps, new Node(0, 0), new Node(10, 6));
        new AStar().start(mapInfo);
        printMap(maps);
    }

    public static void printMap(int[][] maps) {
        for (int i=0;i<maps.length;i++) {
            for (int j=0;j<maps[i].length;j++) {
                System.out.print(maps[i][j]+" ");
            }
            System.out.println();
        }
    }
}
