package sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        //插入排序
        int[] arr = {10, -1, 3, -2, 9};
        sortStart(arr);

    }

    public static void sortStart(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            // 本轮要插入的数（无序表的第一个）
            int val = arr[i];
            // 从后往前开始比较的下标（有序表的最后一个）
            int index = i - 1;
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            // 这里+1是因为上面最后一次循环时，把index--了,其实最后一次是不需要--的
            arr[index+1] = val;
//            System.out.println("第" + i + "轮排序的结果是：" + Arrays.toString(arr));

        }

    }
}
