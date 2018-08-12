package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-27.
 * @description heapify
 */
public class Test130 {

    private static List<Integer> data = new ArrayList<>();

    public void heapify(int[] A) {
        // write your code here
        for (int i=0;i<A.length;i++) {
            add(A[i]);
        }
    }

    private void add(int i) {
        data.add(i);
        shiftUp(data.size()-1);
    }

    private int parent(int index) {
        if (index==0) {
            throw new IllegalArgumentException("The index does't have parent!");
        }
        return (index-1)/2;
    }

    private void shiftUp(int k) {
        while (k>0 && data.get(parent(k))>data.get(k)) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    private void shiftDown(int k) {
        while (leftChild(k)<data.size()) {
            int j = leftChild(k);
            if (j+1<data.size() && data.get(j+1)<data.get(j)) {
                j++;
            }
            if (data.get(k)<data.get(j)) break;
            swap(k, j);
            k = j;
        }
    }

    private int leftChild(int k) {
        return 2*k+1;
    }

    private void swap(int a, int b) {
        int temp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, temp);
    }

    public static void main(String[] args) {
        int[] A = {12, 13 ,15, 8};
        Test130 test = new Test130();
        test.heapify(A);
        System.out.println(data);
    }
}
