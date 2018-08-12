package string;

/**
 * @author Legend
 * @data by on 18-6-6.
 * @description 键索引计数法
 */
public class KeyIndexCount {

    public static void main(String[] args) {
        Model[] models = new Model[20];
        for (int i=0;i < 20;i++) {
            int random = 5;
            models[i] = new Model(randomStr(random), (int)(Math.random()*random));
            System.out.println(models[i].toString());
        }
        int N = models.length;
        Model[] aux = new Model[N];
        int[] count = new int[6];

        // 计算出现频率
        for (int i=0;i < N;i++) {
            count[models[i].key()+1]++;
        }
        // 将频率转换为索引
        for (int r=0;r < 5;r++) {
            count[r+1] += count[r];
        }
        // 将元素分类
        for (int i=0;i < N;i++) {
            aux[count[models[i].key()]++] = models[i];
        }
        // 回写
        for (int i=0;i < N;i++) {
            models[i] = aux[i];
        }

        System.out.println("----------------------------------------------------");
        for (int i=0;i < N;i++) {
            System.out.println(models[i].toString());
        }
    }

    public static String randomStr(int length) {
        String[] strs = {"A", "B", "C", "D", "W", "G", "M", "U"};
        StringBuilder builder = new StringBuilder();
        for (int i=0;i < length;i++) {
            builder.append(strs[(int)(Math.random()*strs.length)]);
        }
        return builder.toString();
    }
}
