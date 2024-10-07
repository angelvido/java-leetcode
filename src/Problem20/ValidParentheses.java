package Problem20;

import java.util.Stack;

// 20. Valid Parentheses
// Easy
public class ValidParentheses {
    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_GREEN = "\033[32m";
    public static final String ANSI_RED = "\033[31m";

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        ValidParentheses vp = new ValidParentheses();
        test(vp.isValid("()"), true, "()");
        test(vp.isValid("()[]{}"), true, "()[]{}");
        test(vp.isValid("(]"), false, "(]");
        test(vp.isValid("([])"), true, "([])");
    }

    public static void test(boolean result, boolean expected, String parentheses) {
        System.out.println("Input: " + parentheses);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        if (result == expected) {
            System.out.println(ANSI_GREEN + "Test PASSED\n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Test FAILED\n" + ANSI_RESET);
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (c == ')' && open != '(') return false;
                if (c == ']' && open != '[') return false;
                if (c == '}' && open != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
