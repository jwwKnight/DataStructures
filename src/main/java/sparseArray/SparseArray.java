package sparseArray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) throws IOException {

        System.out.println("==============原始数组==================");
        int[][] srcArray = new int[11][11];
        srcArray[1][2] = 1;
        srcArray[2][3] = 2;

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf("%d\t", srcArray[i][j]);
                if (srcArray[i][j] != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println("=====================================");

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (srcArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = srcArray[i][j];
                }
            }
        }

        System.out.println("==============稀疏数组==================");
        for (int i = 0; i < sum + 1; i++) {
            System.out.printf("%d\t%d\t%d", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
            System.out.println();
        }
        System.out.println("=====================================");


        //存盘
        File file = new File("d:/sparseArr.data");
        RandomAccessFile raf1 = new RandomAccessFile(file, "rws");

        for (int i = 0; i < sparseArray.length; i++) {
            raf1.writeInt(sparseArray[i][0]);
            raf1.writeInt(sparseArray[i][1]);
            raf1.writeInt(sparseArray[i][2]);
        }
        raf1.close();

        //读盘
        RandomAccessFile raf2 = new RandomAccessFile(file, "rw");
        int i1 = raf2.readInt();
        int i2 = raf2.readInt();
        int i3 = raf2.readInt();

        int[][] newsparseArray = new int[i1][i2];
        newsparseArray[0][0] = i1;
        newsparseArray[0][1] = i2;
        newsparseArray[0][2] = i3;
        for (int i = 1; i <= i3; i++) {
            newsparseArray[i][0] = raf2.readInt();
            newsparseArray[i][1] = raf2.readInt();
            newsparseArray[i][2] = raf2.readInt();
        }

        System.out.println("==============读盘稀疏数组==================");
        for (int i = 0; i < sum + 1; i++) {
            System.out.printf("%d\t%d\t%d", newsparseArray[i][0], newsparseArray[i][1], newsparseArray[i][2]);
            System.out.println();
        }
        System.out.println("=====================================");


        System.out.println("==============恢复原数组==================");
        int[][] newArr = new int[newsparseArray[0][0]][newsparseArray[0][1]];
        for (int i = 1; i < newsparseArray.length; i++) {
            newArr[newsparseArray[i][0]][newsparseArray[i][1]] = newsparseArray[i][2];
        }
        for (int i = 0; i < newsparseArray[0][0]; i++) {
            for (int j = 0; j < newsparseArray[0][1]; j++) {
                System.out.printf("%d\t", newArr[i][j]);
            }
            System.out.println();
        }

    }

}
