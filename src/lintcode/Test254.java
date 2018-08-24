package lintcode;

/**
 * @author Legend
 * @data by on 18-8-21.
 * @description drop-eggs
 * idea:
 *      这道题确实挺难想的 要从1..n层里面去找分界层k 又要是最坏情况下 并且保证2个鸡蛋
 *      能找出 这里重点就是需要找一个搜索的步长 也就是说我们根据每次搜索的位置跨越一个步长
 *      如果刚好到某个位置时鸡蛋破了 那么另一个鸡蛋就需要从这个位置上一步长的位置开始
 *      搜索 直到找到分界层k为止 那么我们该如何使最坏情况下搜索的次数最少呢？
 *      举个例子以n=100为例 假设我们的步长是10 k=10，我们直接从第1层开始 找到这个k需要
 *      测试9次，但如果是最坏情况下 k=100,那么我们一个鸡蛋从10..100就需要10步 然后另一个
 *      鸡蛋再从90开始 一共需要9步 最终才能找到k 这里一共就用了19步 那么有没有更快的方式呢？
 *      答案肯定是有的. 我们先假设最坏情况下需要x次 且初始步长为x 那么走到x步位置发现鸡蛋没有破
 *      下一次应该走到哪个位置？假设走到2x位置 此时鸡蛋破了 那么接下来要用另一个鸡蛋去从x+1位置开始
 *      查找 此时总共需要2x-(x+1)=x-1步 而我们之前还在位置1和x位置测试过 所以总共是x-1+2=x+1步
 *      显然与假设不符和 其实这也就是上面举例的步长为10的情况　那么我们下一次应该走多少步呢 答案就是x-1步
 *      其实有一个明显的规律 就是之前步长固定不变的时候　每次多往下走一步 那么次数必定会是一步的距离+前面
 *      已走的距离 所以我们要做的实际上就是把每次 把前面已走的步数抵消掉 因此每一次都是往之前步长的基础上
 *      减去1　道理基本就是这样了　但如果写成代码的话　因为我们假设的ｘ正是我们所求的 所以倒过来求
 *      就行了 每走一步 步长进行一次递增　加上之前走到的楼层　直到大于楼层n为止　
 */
public class Test254 {

    public int dropEggs(int n) {
        // write your code here
        long sum = 0;
        int i = 0;
        while (sum<n) {
            sum += i++;
        }
        return i-1;
    }
}