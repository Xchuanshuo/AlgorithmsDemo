package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Legend
 * @data by on 18-6-17.
 * @description
 */
public class BSTTest {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
//        for (int num: nums) {
//            bst.add(num);
//        }
//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        bst.levelOrder();
//        System.out.println(bst.toString());
        Random random = new Random();
        int n = 10000000;
        for (int i=0;i < n;i++) {
            bst.add(random.nextInt(10000));
        }
        List<Integer> list = new ArrayList<>();
        while(!bst.isEmpty()) {
            list.add(bst.removeMax());
        }
        System.out.println(list);
    }
}
