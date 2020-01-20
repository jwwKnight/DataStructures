package queue;

import java.util.Scanner;

public class CircleQueueDemo {

    /*
    数组模拟环形队列
     */

    public static void main(String[] args) {
        CircleQueue aq = new CircleQueue(4);

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

    static class CircleQueue {

        int maxSize;
        int front;//队列第一个元素的下标
        int rear;//队列最后一个元素的下一位置
        int[] arr;

        public CircleQueue(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            front = 0;
            rear = 0;
        }

        public boolean isFull() {
            //尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定(!!!)
            return (rear + 1) % maxSize == front;
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public void addQueue(int n) {
            soutFS();
            if (isFull()) {
                System.out.println("满了");
                return;
            }
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }

        public int getQueue() {
            soutFS();
            if (isEmpty()) {
                throw new RuntimeException("空的");
            }
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        public void showQueue() {
            soutFS();
            for (int i = front; i < front + size(); i++) {
                System.out.printf("a[%d]=%d\t", i % maxSize, arr[i % maxSize]);
            }
            System.out.println();
        }

        //计算队列有多个元素
        public int size() {
            return (rear + maxSize - front) % maxSize;
        }

        private void soutFS() {
//            System.out.printf("front = %d,rear = %d\n", front, rear);
        }
    }

}
