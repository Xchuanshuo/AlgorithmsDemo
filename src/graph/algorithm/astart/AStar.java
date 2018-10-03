package graph.algorithm.astart;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-10-3.
 * @description A*算法
 */
public class AStar {

    // 障碍物
    public static final int BAR = 1;
    // 路径
    public static final int PATH = 2;
    // 直走需要的代价
    public static final int DIRECT_VALUE = 10;
    // 斜走需要的代价
    public static final int OBLIQUE_VALUE = 14;

    Queue<Node> openList = new PriorityQueue<>();
    List<Node> closeList = new ArrayList<>();

    public void start(MapInfo mapInfo) {
        if (mapInfo == null) return;
        openList.clear();
        closeList.clear();
        // 开始搜索
        openList.add(mapInfo.start);
        moveNodes(mapInfo);
    }

    private void moveNodes(MapInfo mapInfo) {
        while (!openList.isEmpty()) {
            Node current = openList.poll();
            closeList.add(current);
            addNeighborNodeInOpen(mapInfo, current);
        }
        if (isInClose(mapInfo.end.point)) {
            drawPath(mapInfo.maps, mapInfo.end);
        }
    }

    /**
     *  在二维数组中绘制路径
     * @param maps
     * @param end
     */
    private void drawPath(int[][] maps, Node end) {
        if (end==null || maps==null) return;
        System.out.println("总代价："+end.G);
        while (end != null) {
            System.out.println("代价: "+end.G);
            Point p = end.point;
            maps[p.y][p.x] = PATH;
            end = end.parent;
        }
    }

    // 添加相邻节点到open表
    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current) {
        int x = current.point.x;
        int y = current.point.y;
        // 左
        addNeighborNodeInOpen(mapInfo, current, x-1, y, DIRECT_VALUE);
        // 上
        addNeighborNodeInOpen(mapInfo, current, x, y-1, DIRECT_VALUE);
        // 右
        addNeighborNodeInOpen(mapInfo, current, x+1, y, DIRECT_VALUE);
        // 下
        addNeighborNodeInOpen(mapInfo, current, x, y+1, DIRECT_VALUE);
        // 左上
        addNeighborNodeInOpen(mapInfo, current, x-1, y-1, OBLIQUE_VALUE);
        // 右上
        addNeighborNodeInOpen(mapInfo, current, x+1, y-1, OBLIQUE_VALUE);
        // 右下
        addNeighborNodeInOpen(mapInfo, current, x+1, y+1, OBLIQUE_VALUE);
        // 左下
        addNeighborNodeInOpen(mapInfo, current, x-1, y+1, OBLIQUE_VALUE);
    }

    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current, int x, int y, int value) {
        if (canAddNodeToOpen(mapInfo, x, y)) {
            Node end = mapInfo.end;
            Point point = new Point(x, y);
            int G = current.G + value;
            Node child = findNodeInOpen(point);
            if (child == null) {
                int H = calH(end.point, point);
                if (isEndNode(end.point, point)) {
                    child = end;
                    child.parent = current;
                    child.G = G;
                    child.H = H;
                } else {
                    child = new Node(point, current, G, H);
                }
                openList.add(child);
            } else if (child.G > G) {
                child.G = G;
                child.parent = current;
                openList.add(child);
            }
        }
    }

    /**
     * 从Open列表中查找节点
     * @param point
     * @return
     */
    private Node findNodeInOpen(Point point) {
        if (point==null || openList.isEmpty()) return null;
        for (Node node: openList) {
            if (node.point.equals(point)) {
                return node;
            }
        }
        return null;
    }

    /**
     * 计算point到end的曼哈顿距离
     * @param end
     * @param point
     * @return
     */
    private int calH(Point end, Point point) {
        return Math.abs(end.x - point.x) + Math.abs(end.y - point.y);
    }

    private boolean isEndNode(Point end, Point point) {
        return point!=null && end.equals(point);
    }

    /**
     * 判断节点是否能放入到open表中
     * @param mapInfo
     * @param x
     * @param y
     * @return
     */
    private boolean canAddNodeToOpen(MapInfo mapInfo, int x, int y) {
        if (x<0 || x>=mapInfo.width || y<0 || y>=mapInfo.height) return false;
        if (mapInfo.maps[y][x] == BAR) return false;
        if (isInClose(x, y)) return false;
        return true;
    }

    /**
     * 判断坐标是否在
     * close表中
     * @param point
     * @return
     */
    private boolean isInClose(Point point) {
        return point!=null && isInClose(point.x, point.y);
    }

    private boolean isInClose(int x, int y) {
        if (closeList.isEmpty()) return false;
        for (Node node: closeList) {
            if (node.point.x==x && node.point.y==y) {
                return true;
            }
        }
        return false;
    }
}
