package lintcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-7-14.
 * @description 555 counting-bloom-filter
 */
public class CountingBloomFilter {

    class HashFunction {
        int capacity, seed;
        public HashFunction(int capacity, int seed) {
            this.capacity = capacity;
            this.seed = seed;
        }
        public int hash(String value) {
            int result = 0;
            int n = value.length();
            for (int i=0;i<n;i++) {
                result += seed*result + value.charAt(i);
                result %= capacity;
            }
            return result;
        }
    }

    private int[] bits;
    private int k;
    private List<HashFunction> list;

    public CountingBloomFilter(int k) {
        // initialize your data structure here
        this.k = k;
        list = new ArrayList<>();
        for (int i=0;i<k;i++) {
            list.add(new HashFunction(100000+i, 2*i+3));
        }
        bits = new int[100000+k];
    }

    public void add(String word) {
        // Write your code here
        for (int i=0;i<k;i++) {
            int position = list.get(i).hash(word);
            bits[position]++;
        }
    }

    public void remove(String word) {
        // Write your code here
        for (int i=0;i<k;i++) {
            int position = list.get(i).hash(word);
            bits[position]--;
        }
    }

    public boolean contains(String word) {
        // Write your code here
        for (int i=0;i<k;i++) {
            int position = list.get(i).hash(word);
            if (bits[position]<=0) return false;
        }
        return true;
    }
}