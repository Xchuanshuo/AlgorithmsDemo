package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-7-2.
 * @description merge-k-sorted-interval-lists
 */
public class Test577 {

    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        if (null==intervals || intervals.isEmpty()) {
            return new ArrayList<>();
        }
        return helper(intervals, 0, intervals.size()-1);
    }

    private List<Interval> helper(List<List<Interval>> intervals, int start, int end) {
        if (start==end) {
            return intervals.get(start);
        }
        int mid = start+(end-start)/2;
        List<Interval> left = helper(intervals, start, mid);
        List<Interval> right = helper(intervals, mid+1, end);
        return merge(left, right);
    }

    private List<Interval> merge(List<Interval> left, List<Interval> right) {
        List<Interval> result = new ArrayList<>();
        int i=0, j=0;
        while (i<left.size() && j<right.size()) {
            // 按大小顺序加入result
            if (left.get(i).start < right.get(j).start) {
                mergeInterval(result, left.get(i++));
            } else {
                mergeInterval(result, right.get(j++));
            }
        }
        while (i<left.size()) {
            mergeInterval(result, left.get(i++));
        }
        while (j<right.size()) {
            mergeInterval(result, right.get(j++));
        }
        return result;
    }

    private void mergeInterval(List<Interval> result, Interval interval) {
        if (result.isEmpty()) {
            result.add(interval);
            return;
        }
        Interval last = result.get(result.size()-1);
        if (last.end < interval.start) {
            result.add(interval);
        } else {
            last.end = Math.max(last.end, interval.end);
        }
    }
}
