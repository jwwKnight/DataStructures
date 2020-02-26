package sort;

import java.util.Random;

public class SortTimeCalculator {
    // 排序时间测试区
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random r = new Random(1000000);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(r.nextInt());
        }
        long s = System.currentTimeMillis();

//        BubbleSort.sortStart(arr);//14s
//        SelectSort.sortStart(arr);//3s
        InsertSort.sortStart(arr);//0.7s 84234ms
//        ShellSort.shellSort2(arr);//19ms 165ms
//        bucketSort.sortStart(arr);//14ms 79ms

        long e = System.currentTimeMillis();
        System.out.println("耗时： " + (e - s) + " 毫秒");
    }
}
