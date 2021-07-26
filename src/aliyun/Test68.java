package aliyun;

import java.util.HashMap;

/**
 * @author Legend
 * @data by on 21-4-5.
 * @description https://developer.aliyun.com/coding/68
 */
public class Test68 {

    public static int solution(int l, int r) {
        while ((l | (l+1)) < r) {
            l |= l+1;
        }
        return l;
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int res = solution(1, 1000_0000);
        System.out.println((System.currentTimeMillis() - time) + "ms");
        System.out.println(res);
    }

}
