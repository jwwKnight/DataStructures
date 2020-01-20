package queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    /*
    数组模拟队列
     */

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);

        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("=====================|");
            System.out.println("s:展示");
            System.out.println("a:入列");
            System.out.println("g:出列");
            System.out.println("=====================");
            char next = sc.next().charAt(0);
            switch (next) {
                case 's':
                    aq.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入：");
                    aq.addQueue(sc.nextInt());
                    break;
                case 'g':
                    try {
                        System.out.println(aq.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("退出");
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }

    static class ArrayQueue {

        int maxSize;
        int front;//队列第一个元素的下标-1
        int rear;//队列最后一个元素的下标
        int[] arr;

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            front = -1;
            rear = -1;
        }

        public boolean isFull() {
            return rear == maxSize - 1;
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("满了");
                return;
            }
            rear++;
            arr[rear] = n;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("空的");
            }
            front++;
            return arr[front];
        }

        public void showQueue() {
            for (int i = front + 1; i <= rear; i++) {
                System.out.printf("a[%d]=%d\t", i, arr[i]);
            }
            System.out.println();
        }


    }

}
