package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-10-16.
 * @description 桶排序
 */
public class BucketSort {

    public static List<Double> bucketSort(double[] arr) {
        double max = arr[0], min=arr[0];
        for (int i=1;i<arr.length;i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // 桶的取值区间
        double diff = max - min;
        // 桶的数量
        int bucketNum = arr.length;
        List<List<Double>> list = new ArrayList<>();
        for (int i=0;i<bucketNum;i++) {
            list.add(new ArrayList<>());
        }
        // 把元素装入到不同的桶里面
        for (int i=0;i<arr.length;i++) {
            int pos = (int) ((arr[i]-min)*(bucketNum-1)/diff);
            list.get(pos).add(arr[i]);
        }
        // 对每个桶进行排序
        for (int i=0;i<bucketNum;i++) {
            Collections.sort(list.get(i));
        }
        List<Double> result = new ArrayList<>();
        for (List<Double> bucket: list) {
            for (double num: bucket) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int length = (int) 1e5;
        double[] arr = new double[length];
        for (int i=0;i<length;i++) {
            arr[i] = Math.random()*length;
        }
        System.out.println(bucketSort(arr));
    }
}