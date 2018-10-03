package graph.algorithm.astart;

/**
 * @author Legend
 * @data by on 18-10-3.
 * @description
 */
public class MapInfo {

    public int[][] maps;
    public int width;
    public int height;
    public Node start;
    public Node end;

    public MapInfo(int[][] maps, Node start, Node end) {
        this.maps = maps;
        this.width = maps[0].length;
        this.height = maps.length;
        this.start = start;
        this.end = end;
    }
}
