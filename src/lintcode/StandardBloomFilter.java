package lintcode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-7-14.
 * @description 556 standard-bloom-filter
 */

public class StandardBloomFilter {

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
                result += result*seed + value.charAt(i);
                result %= capacity;
            }
            return result;
        }
    }

    private int k;
    private BitSet bitSet;
    private List<HashFunction> list;

    public StandardBloomFilter(int k) {
        // do intialization if necessary
        this.k = k;
        list = new ArrayList<>();
        for (int i=0;i<k;i++) {
            list.add(new HashFunction(100000+i, 2*i+3));
        }
        bitSet = new BitSet(100000+k);
    }

    public void add(String word) {
        // write your code here
        for (int i=0;i<k;i++) {
            int position = list.get(i).hash(word);
            bitSet.set(position);
        }
    }

    public boolean contains(String word) {
        // write your code here
        for (int i=0;i<k;i++) {
            int position = list.get(i).hash(word);
            if (!bitSet.get(position)) return false;
        }
        return true;
    }
}