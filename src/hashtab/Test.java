package hashtab;

import java.util.HashMap;

/**
 * @author Legend
 * @data by on 18-6-26.
 * @description
 */
public class Test {

    private int hash(int key, int capacity) {

        System.out.println(key & 0x7fffffff);
        return (key%capacity+capacity) % capacity;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.hash(-7,10));
    }
}
