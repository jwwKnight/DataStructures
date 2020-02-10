package recursion;

public class Queen8 {

    //定义个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，比如arr[8] = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];

    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        //测试一把，8皇后是否
        // 正确
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d个解法\n", count);
        System.out.printf("一共判断冲突次数为%d次", judgeCount);

    }

    //编写一个方法，放置第n个皇后
    //特别注意，check每一次递归时，都有一套for循环，因此会有回溯
    public void check(int n) {
        if (n == max) { //n=8，表示8个皇后已经放好
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后放到改行第一列。
            array[n] = i;
            //判断，当放置第n个皇后到i列时，是否冲突
            if (judeg(n)) {  //不冲突
                //接着放n+1个皇后，即开始递归
                check(n + 1);
            }

            //如果冲突，继续执行 array[n] = i;即将第n个皇后，放置在本行后一个位置


        }


    }

    /**
     * 查看当我们第n个皇后时，就去检测该皇后是否和前面已经摆放的皇后冲突
     *
     * @param n 第n个皇后
     * @return
     */
    private boolean judeg(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //说明
            //1. array[i] == array[n] 表示判断第n个皇后
            // 2. Math.abs(n-i) == Math.abs(array[n]-array[i])判断第n个皇后是否和第i个皇后在同一斜线
            // n = 1 放置第2列  n=1 array[1] = 1  从0开始
            //Math.abs(n-i) = 1， Math.abs(array[n]-array[i])= Math.abs（1-0） = 1
            /*
            其实就是看看两个皇后行的差值和列的差值是不是相同，差值相同说明是在同一斜线
             */
            //3. 判断是否在同一行，没有必要，n每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}

