package stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(5);
        as.push(1);
        as.push(2);
//        as.show();
        as.push(3);
        System.out.println(as.peek());
        System.out.println(as.peek());
        as.push(4);
        as.push(5);
        System.out.println(as.peek());
        System.out.println(as.peek());
//        as.show();
//        System.out.println("===============");
//        System.out.println(as.pop());
//        System.out.println(as.pop());
//        as.show();
//        System.out.println(as.pop());
//        System.out.println(as.pop());
//        System.out.println("===============");
//        as.show();
//        System.out.println(as.pop());
    }
}

// 数组模拟栈
class ArrayStack {
    int maxSize;
    int top;
    int[] data;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        data = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈满了");
        }
        top++;
        data[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空了");
        }
        return data[top--];
    }

    public void show() {
        int temp = top;
        for (int i = top; i >= 0; i--) {
            System.out.println(pop());
        }
        top = temp;
    }

    public int peek() {
        int value = pop();
        top++;
        return value;
    }

}
