package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    // 冒泡排序
    public static void main(String[] args) {
//        int[] arr = {10, -1, 3, -2, 9};
        int[] arr = new int[100000];
        Random r = new Random(100000);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }

        long s = System.currentTimeMillis();
        sortStart(arr);
        long e = System.currentTimeMillis();
        System.out.println("耗时： " + (e - s)+ " 毫秒");

    }

    public static void sortStart(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean falg = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    falg = true;
                }
            }
            if (!falg) {
                break;
            }
        }
    }
}
