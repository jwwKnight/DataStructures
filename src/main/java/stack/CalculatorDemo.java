package stack;

import java.util.HashMap;
import java.util.Map;

// 使用栈实现计算器
public class CalculatorDemo {
    // 3+2*6-2 = 13
    // 5*5+6-3 = 28
    // 7*2*2-5+1-5+3-4 = 18
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int result = c.calculator("7*2*2-5+1-5+3-4");
        System.out.println(result);
    }
}

class Calculator {

    private Map<Character, Integer> oprPriority = new HashMap<Character, Integer>();

    {
        oprPriority.put('+', 1);
        oprPriority.put('-', 1);
        oprPriority.put('*', 0);
        oprPriority.put('/', 0);
    }

    private ArrayStack numStack = new ArrayStack(50);
    private ArrayStack oprStack = new ArrayStack(50);

    int index = 0;

    //  计算
    public int calculator(String expression) {
        while (true) {
            if (index >= expression.length()) {
                break;
            }
            char ch = expression.charAt(index);
            if (isOpr(ch)) {
                // 如果是符号
                if (oprStack.isEmpty()) {
                    // 如果符号栈空则直接入栈
                    oprStack.push(ch);
                    index++;
                    continue;
                }
                if (isPrior(ch)) {
                    // 如果优先级更高则直接入栈
                    oprStack.push(ch);
                } else {
                    // 如果优先级相同或低于则取出numStack前两个和oprStack第一个进行计算，结果入numStack，再把符号入栈
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    char opr = (char) oprStack.pop();
                    int result = cal(num1, num2, opr);
                    numStack.push(result);
                    oprStack.push(ch);
                }
            } else {
                // 如果是数字
                numStack.push(ch - 48);
            }
            index++;
        }
        // expression解析结束，把stack里的运算完成
        while (!oprStack.isEmpty()) {
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            char opr = (char) oprStack.pop();
            int result = cal(num1, num2, opr);
            numStack.push(result);
        }

        // 最后剩下的就是结果
        return numStack.pop();
    }

    // 判断是不是符号
    private boolean isOpr(char opr) {
        return oprPriority.containsKey(opr);
    }

    // 与oprStack的top比较优先级,true为更高，false为相同或更低
    private boolean isPrior(char opr) {
        Integer pri1 = oprPriority.get(opr);
        Integer pri2 = oprPriority.get((char) oprStack.peek());
        return pri1 < pri2;
    }

    // 计算两个数的计算结果
    private int cal(int num1, int num2, char opr) {
        int result = 0;
        switch (opr) {
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new RuntimeException("符号错误");
        }
        return result;
    }


}


