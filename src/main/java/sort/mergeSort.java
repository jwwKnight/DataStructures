package sort;

import java.util.Arrays;

/**
 * 归并排序
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略
 * （分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 */
public class mergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 2, 5, 3, 4, 1};
        int[] temp = new int[arr.length];

        sortStart(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortStart(int[] arr, int left, int right, int[] temp) {
        // right 就是递归传进来的mid，当left=mid时，分到说明已经只剩一个数了，不能再分了，就开始进行排序
        while (left < right) {
            int mid = (left + right) / 2;
            // 左边递归
            sortStart(arr, left, mid, temp);
            // 右边递归
            sortStart(arr, mid + 1, right, temp);
            // 左右两边都排序结束，开始合并左右两边
//            System.out.println("left=" + left + " right=" + right);
            merge(arr, left, right, mid, temp);
        }
    }

    /**
     * arr分段比较，比较结果移到temp，
     * 把还剩数的一边移到temp,
     * temp复制到原arr,
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    private static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        System.out.println("left=" + left + " right=" + right);
        // 1.arr分段比较
        int i = left;
        int j = mid + 1;
        int tempIndex = 0;
        // 如果一边没有数了就退出
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[tempIndex] = arr[i];
                i++;
                tempIndex++;
            } else {
                temp[tempIndex] = arr[j];
                j++;
                tempIndex++;
            }
        }

        // 2.把还剩数的一边移到temp
        while (i <= mid) {
            temp[tempIndex] = arr[i];
            i++;
            tempIndex++;
        }

        while (j <= right) {
            temp[tempIndex] = arr[j];
            j++;
            tempIndex++;
        }

        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[tempIndex++];
        }

//        // 3.temp复制到原arr
//        tempIndex = 0;
//        int tempLeft = left;
////        System.out.println("tempLeft=" + tempLeft + " right=" + right);
//        while (tempLeft <= right) {
//            arr[tempLeft] = temp[tempIndex];
//            tempLeft++;
//            tempIndex++;
//        }
    }
}
