import java.util.ArrayList;
import java.util.Stack;

// 20.有效的括号
class Solution20 {

    public static void main(String[] args) {

        System.out.println(isValid("[[]]{}"));
    }

    public static boolean isValid(String s) {

        //  定义一个栈，存放右括
        Stack<Character> stack = new Stack<>();

        //  循环遍历
        //  如果遍历到左括号，则在栈中加入一个相应的右括号
        //  如果遍历到右括号，则判断栈是否为空或者该右括号是否与栈顶括号是否一致
        //   1.如果栈为空，则遍历到的右括号无法被匹配，返回false
        //   2.如果遍历到的右括号与栈顶括号不匹配，返回false
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        //  如果 stack 为空，表示匹配完毕。 如果 stack 不为空，表示括号有多余，
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        //  如果 s 空字符串，返回true
        if (s.length() == 0) return true;

        //  如果 s 长度为 1 或者 第一个字符是右括号，无法匹配，返回false
        if (s.length() == 1 || s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;

        //  将传入的参数 s 转换为 字符数组 str
        char[] str = s.toCharArray();

        //  定义left列表，放所有的左括号
        ArrayList<Character> left = new ArrayList<>();

        //  1 用for循环遍历字符数组str，如果是左括号，加入到left列表中
        //  2 如果是右括号，进行判断是否与left列表中的左括号匹配，
        //    如果匹配，则将已经匹配的左括号从left列表中移除。
        //  3 如果都能匹配，则left列表为空。
        for (char c : str) {
            if (c == '(' || c == '[' || c == '{') {
                left.add(c);
                continue;
            }
            if (left.size() > 0) {
                if (c == ')' && left.get(left.size() - 1) == '(') {
                    System.out.println("1");
                    left.remove(left.size() - 1);
                } else if (c == ']' && left.get(left.size() - 1) == '[') {
                    System.out.println("2");
                    left.remove(left.size() - 1);
                } else if (c == '}' && left.get(left.size() - 1) == '{') {
                    System.out.println("3");
                    left.remove(left.size() - 1);
                }
            }
        }

        // 返回 left.isEmpty()
        return left.isEmpty();
    }
}
