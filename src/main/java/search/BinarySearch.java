package search;

import javafx.beans.binding.When;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 22, 33, 44, 66, 89, 89, 89, 89, 225, 665};
//        System.out.println(find(arr, 0, arr.length - 1, 89));
        List<Integer> integers = find2(arr, 0, arr.length - 1, 89);
        Collections.sort(integers);
        System.out.println(integers);
    }

    public static int find(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int midIndex = (left + right) / 2;
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

    /**
     * 优化版本，可以查多个相同值的索引
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static List<Integer> find2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int midIndex = (left + right) / 2;
        int midVal = arr[midIndex];
        if (midVal < findVal) {
            // 右递归
            return find2(arr, midIndex + 1, right, findVal);
        } else if (midVal > findVal) {
            // 左递归
            return find2(arr, left, midIndex - 1, findVal);
        } else {
            List<Integer> result = new ArrayList<Integer>();
            // 因为相同的值都是连在一起的，所以只要把找到的值左右两边都扫描一下就行
            int temp = midIndex - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                result.add(temp);
                temp--;
            }
            temp = midIndex + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                result.add(temp);
                temp++;
            }
            // 别忘了本身找到的这个数
            result.add(midIndex);
            return result;
        }
    }
}
