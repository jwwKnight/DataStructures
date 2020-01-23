package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// 逆波兰表达式（即后缀表达式）计算器
public class PolandNotation {
    public static void main(String[] args) {
        PolandCalculator polandCalculator = new PolandCalculator();
//        int calculate = polandCalculator.calculate("3 4 + 5 * 6 -");
//        System.out.println(calculate);
        List<String> strings = polandCalculator.transferList("(3+4)*5-6");
        System.out.println(strings);
    }


}

class PolandCalculator {

    // expression = "3 4 + 5 * 6 -"

    /**
     * 计算后缀表达式结果
     *
     * @param expression 后缀表达式
     * @return
     */
    public int calculate(String expression) {
        String[] split = expression.split(" ");
        ArrayList<String> arrayList = new ArrayList<String>(split.length);
        Collections.addAll(arrayList, split);
        Stack<String> stack = new Stack<String>();

        for (String s : arrayList) {
            if (s.matches("\\d+")) {
                // 数字
                stack.push(s);
            } else {
                // 符号
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if ("+".equals(s)) {
                    result = num1 + num2;
                } else if ("-".equals(s)) {
                    result = num1 - num2;
                } else if ("*".equals(s)) {
                    result = num1 * num2;
                } else if ("/".equals(s)) {
                    result = num1 / num2;
                } else {
                    throw new RuntimeException("符号错误");
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 中缀表达式转list
     *
     * @param expression 中缀表达式
     * @return
     */
    public List<String> transferList(String expression) {
        // expression=（3+4）*5-6
        List<String> arrList = new ArrayList<String>();
        String s = "";//拼接多位数
        char ch;//expression遍历出的字符
        int j = 0;//遍历expression的下标
        while (j < expression.length()) {
            if ((ch = expression.charAt(j)) < 48 || (ch = expression.charAt(j)) > 57) {
                // 符号
                arrList.add(String.valueOf(ch));
                j++;
            } else {
                s = "";
                // 数字
                while (j < expression.length() && (ch = expression.charAt(j)) >= 48 && (ch = expression.charAt(j)) <= 57) {
                    s += String.valueOf(ch);
                    j++;
                }
                arrList.add(s);
            }
        }
        return arrList;
    }

}
