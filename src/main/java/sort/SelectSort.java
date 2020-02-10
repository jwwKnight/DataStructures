package sort;

import java.util.Arrays;

public class SelectSort {
    // 选择排序
    public static void main(String[] args) {
        int[] arr = {10, 99, 5, 6,-5,88,65,71,-88};
        sortStart(arr);
    }

    public static void sortStart(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 找最小的
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //换位子
            if(minIndex ==i){
                continue;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

//            System.out.println("第次排序" + (i + 1) + "排序的结果是" + Arrays.toString(arr));
        }
    }
}
