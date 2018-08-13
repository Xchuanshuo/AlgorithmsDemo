package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-9.
 * @description longest-ab-substring
 * idea:
 *      用res表示AB数量差为0时字符串得长度
 *      用一个Map 保存每次遍历时的AB数量差对应的索引
 *      这样 当遍历到后面的字符时 数量差已经存在 就说明
 *      中间有AB数量相等 就计算当前索引和之前保存索引的差值
 *      结果就是这一段内AB子串的长度 然后去与res比较取较大值
 */
public class Test1443 {

    public int getAns1(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        Map<Integer, Integer> maps = new HashMap<>();
        int v = 0;
        int[] l = new int[c.length];
        for (int i=0;i < c.length;i++) {
            if (c[i] == 'A') {
                v++;
            } else {
                v--;
            }
            l[i] = v;
            if (!maps.containsKey(v)) {
                maps.put(v, 0);
            }
            if (i > maps.get(v)) {
                maps.put(v, i);
            }
        }
        int res = 0;
        for (int i=0;i < c.length-1;i++) {
            int target = l[i];
            if (c[i] == 'A') {
                target--;
            } else {
                target++;
            }
            if (!maps.containsKey(c[i])) {
                maps.put(target, 0);
            }
            if (maps.get(target) > i) {
                res = Math.max(maps.get(target) - i + 1, res);
            }
        }
        return res;
    }

    public int getAns2(String s) {
        int a=0, b=0;
        char[] c = s.toCharArray();
        int[] numA = new int[c.length+1];
        int[] numB = new int[c.length+1];
        for (int i=0;i < c.length;i++) {
            if (c[i] == 'A') a++; else b++;
            numA[i+1] = a;
            numB[i+1] = b;
        }
        if (a==0 || b==0) return 0;
        int res = Math.min(a, b)*2;
        for (int i=0;res>0 && i+res <= c.length;i++, res-=2) {
                a = numA[i+res] - numA[i];
                b = numB[i+res] - numB[i];
                if (a == b) return res;
        }
        return 0;
    }

    public int getAns(String s) {
        char[] c = s.toCharArray();
        Map<Integer, Integer> maps = new HashMap<>();
        int v = 0, res = 0;
        for (int i=0;i < c.length;i++) {
            if (c[i] == 'A') v++; else v--;
            if (v == 0) res=i+1;
            if (maps.containsKey(v)) {
                res = Math.max(res, i-maps.get(v));
            } else {
                maps.put(v, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test1443 test1 = new Test1443();
        System.out.println(test1.getAns("AAABABAB"));
    }

}
