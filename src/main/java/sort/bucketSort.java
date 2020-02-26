package sort;

import java.util.Arrays;

/**
 * 桶排序
 * <p>
 * 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
 */
public class bucketSort {

    public static void main(String[] args) {

        int[] arr = {8, 53, 48, 317, 54, 65, 1, 99, 653};
        sortStart(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sortStart(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        // 每个桶的index记录
        int[] indexArr = new int[10];

        // 1.找最大的位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 最大位数 即为 轮数
        int maxLength = (max + "").length();

        // 2.进行 maxLength 轮排序
        int n = 1;
        for (int i = 0; i < maxLength; i++, n *= 10) {
            // 2.1 数字放桶里
            for (int j = 0; j < arr.length; j++) {
                int k = (arr[j] / n) % 10;
                // 放在第k个桶的最下面
//                System.out.println(k);
                int i1 = indexArr[k];
                int i2 = bucket[k][indexArr[k]];
                bucket[k][indexArr[k]] = arr[j];
                indexArr[k]++;
            }
            // 2.2 取出来，放回原数组
            int g = 0;
            for (int j = 0; j < bucket.length; j++) {
                for (int k = 0; k < indexArr[j]; k++) {
                    arr[g] = bucket[j][k];
                    g++;
                }
                // 清空index记录
                indexArr[j] = 0;
            }
        }

    }


}
