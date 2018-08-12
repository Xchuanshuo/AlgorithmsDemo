package map;

/**
 * @author Legend
 * @data by on 18-6-18.
 * @description 基于二分搜索树的Map
 */
public class LinkedListMapTest {

    public static void main(String[] args) {
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        linkedListMap.add("AAA", 10);
        linkedListMap.add("BBB", 20);
        linkedListMap.add("CCC", 30);
        System.out.println(linkedListMap.get("AAA"));
    }
}
