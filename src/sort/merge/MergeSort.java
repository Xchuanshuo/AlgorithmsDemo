package sort.merge;

import sort.Sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 20-2-21.
 * @description
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;

    protected void merge(T[] nums, int l, int m, int r) {
        int i = l, j = m + 1;
        for (int k = l;k <= r;k++) {
            aux[k] = nums[k];
        }
        int k = l;
        while (i <= m && j <= r) {
            if (less(aux[i], aux[j])) {
                nums[k++] = aux[i++];
            } else {
                nums[k++] = aux[j++];
            }
        }
        while (i <= m) nums[k++] = aux[i++];
        while (j <= r) nums[k++] = aux[j++];
    }
}
