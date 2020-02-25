package sort;

import java.util.Random;

public class SortTimeCalculator {
    // 排序时间测试区
    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random r = new Random(100000);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        long s = System.currentTimeMillis();

//        BubbleSort.sortStart(arr);//14s
//        SelectSort.sortStart(arr);//3s
        InsertSort.sortStart(arr);//0.7s
//        ShellSort.shellSort2(arr);//19ms

        long e = System.currentTimeMillis();
        System.out.println("耗时： " + (e - s) + " 毫秒");
    }
}
