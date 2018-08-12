package tree.heap;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Legend
 * @data by on 18-6-19.
 * @description
 */
public class Test {

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num: testData) {
                maxHeap.add(num);
            }
        }
        int arr[] = new int[testData.length];
        for (int i=0;i < testData.length;i++) {
            arr[i] = maxHeap.extractMax();
//            System.out.print(arr[i]+" ");
        }
        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int n = 10000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i=0;i < n;i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println(testHeap(testData, true));
//        System.out.println(testHeap(testData, false));
//        int[] arr = new int[n];
//        for (int i=0;i < n;i++) {
//            arr[i] = maxHeap.extractMax();
//            //System.out.print(arr[i]+" ");
//        }
    }
}
