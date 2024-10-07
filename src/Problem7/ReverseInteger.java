package Problem7;

// 7. Reverse Integer
// Medium
public class ReverseInteger {
    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_GREEN = "\033[32m";
    public static final String ANSI_RED = "\033[31m";

    public static void main(String[] args) {
        /*
        System.out.println("** TEST CASE 1 **");
        int x = 123;
        System.out.println("Input:");
        System.out.println(x);
        System.out.println("Output:");
        System.out.println(reverse(x));
        System.out.println();

        System.out.println("** TEST CASE 2 **");
        x = -123;
        System.out.println("Input:");
        System.out.println(x);
        System.out.println("Output:");
        System.out.println(reverse(x));
        System.out.println();

        System.out.println("** TEST CASE 3 **");
        x = 120;
        System.out.println("Input:");
        System.out.println(x);
        System.out.println("Output:");
        System.out.println(reverse(x));
        System.out.println();
        */
        runTests();
    }

    public static void runTests() {
        testReverse(123, 321);
        testReverse(-123, -321);
        testReverse(120, 21);
        testReverse(1534236469, 0);
        testReverse(-2147483648, 0);
    }

    public static void testReverse(int input, int expected) {
        int result = reverse(input);
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        if (result == expected) {
            System.out.println(ANSI_GREEN + "Test PASSED\n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Test FAILED\n" + ANSI_RESET);
        }
    }

    public static int reverse(int x) {
        int y = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            int newResult = y * 10 +lastDigit;
            if ((newResult - lastDigit) / 10 != y) {
                return 0;
            }
            y = newResult;
            x /= 10;
        }

        return y;
    }
}
