package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-8-6.
 * @description movie-network
 */
public class Test808 {

    private Set<Integer> set = new HashSet<>();
    private PriorityQueue<Movie> priorityQueue = new PriorityQueue<>((a, b)->(b.rating-a.rating));
    public int[] topKMovie(int[] rating, int[][] G, int S, int K) {
        // Write your code here
        dfs(rating, G, S, S);
        int[] result = new int[Math.min(K, priorityQueue.size())];
        for (int i=0;i<result.length;i++) {
            result[i] = priorityQueue.poll().id;
        }
        return result;
    }

    private void dfs(int[] rating, int[][] G, int v, int s) {
        set.add(v);
        if (v != s) priorityQueue.offer(new Movie(rating[v], v));
        for (int i: G[v]) {
            if (!set.contains(i)) dfs(rating, G, i, s);
        }
    }

    class Movie {
        int rating;
        int id;
        Movie(int rating, int id) {
            this.rating = rating;
            this.id = id;
        }
    }

    private static boolean isPrime(int num) {
        if (num == 2) return true;
        if (num<=1 || num%2 == 0) return false;
        for (int i=3;i<=Math.sqrt(num);i+=2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static int tab[]={2, 3, 5, 7};
    static long qpow(int a, int b, int r)  //(a^b)%r  快速幂取模
    {
        long ret = 1, tmp = a;
        while(b==1)
        {
            if ((b&1)==1)
                ret = ret*tmp%r;
            tmp = tmp*tmp%r;
            b >>= 1;
        }
        return ret;
    }
    static boolean Miller_Rabbin(int n, int a)//米勒拉宾素数测试
    {
        int r = 0, s = n-1, j;
        long k;
        if(n%a == 0)    return false;
        while((s&1) == 0)
        {
            s >>= 1;
            r++;
        }
        k = qpow(a, s, n);
        if(k == 1)  return true;
        for (j = 0; j < r; j++, k=k*k%n)
            if (k == n-1)
                return true;
        return false;
    }
    static boolean Isprime(int n)//判断是否是素数
    {
        for (int i = 0; i < 4; i++)
        {
            if (n == tab[i])
                return true;
            if (!Miller_Rabbin(n, tab[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int n = 30000000;
        List<Integer> list = new ArrayList<>();
        for (int i=2;i<n;i++) {
            if (Isprime(i)) {
                list.add(i);
            }
        }
        long endTime = System.currentTimeMillis()-startTime;
        System.out.println(list);
        System.out.println("cost time: "+endTime);
        System.out.println(2797832%2);
    }
}
