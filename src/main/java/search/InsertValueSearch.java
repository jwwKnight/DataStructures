package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 插值查找
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 22, 33, 44, 66, 89, 89, 89, 89, 225, 665};
        System.out.println(find(arr, 0, arr.length - 1, 1));
//        List<Integer> integers = find2(arr, 0, arr.length - 1, 89);
//        Collections.sort(integers);
//        System.out.println(integers);
    }

    public static int find(int[] arr, int left, int right, int findVal) {
        System.out.println("查找计数");
        // 修改1：改条件
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 修改2：改公式
        int midIndex = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[midIndex];
        if (midVal < findVal) {
            // 右递归
            return find(arr, midIndex + 1, right, findVal);
        } else if (midVal > findVal) {
            // 左递归
            return find(arr, left, midIndex - 1, findVal);
        } else {
            return midIndex;
        }
    }

}
