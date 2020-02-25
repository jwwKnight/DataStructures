package sort;

import java.util.Arrays;

//希尔排序移位法,组内使用插入排序
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
    }

    public static void shellSort2(int[] arr) {
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {//gap为分组间隔
            for (int i = gap; i < arr.length; i++) {
                int j = i;//定义保存待排元素的索引
                int temp = arr[j];//定义临时变量保存待排元素的值
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];//满足条件就交换
                    j = j - gap;//j=j-gap这条语句表示找到了与待排元素进行交换的组内元素索引，组内元素间隔相等
//                    count++;
                }
                //退出while循环就表示找到了插入待排元素的索引
                arr[j] = temp;
            }
//            System.out.println(Arrays.toString(arr));
        }
//        System.out.println(count);
    }
}
