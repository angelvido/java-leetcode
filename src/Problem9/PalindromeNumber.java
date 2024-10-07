package Problem9;

// 9. Palindrome Number
// Easy
public class PalindromeNumber {
    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_GREEN = "\033[32m";
    public static final String ANSI_RED = "\033[31m";

    public static void main(String[] args) {
        /*
        System.out.println("** TEST CASE 1 **");
        int x = 121;
        System.out.println("Input:");
        System.out.println(x);
        System.out.println("Output:");
        System.out.println(isPalindrome(x));
        System.out.println();

        System.out.println("** TEST CASE 2 **");
        x = -121;
        System.out.println("Input:");
        System.out.println(x);
        System.out.println("Output:");
        System.out.println(isPalindrome(x));
        System.out.println();

        System.out.println("** TEST CASE 3 **");
        x = 10;
        System.out.println("Input:");
        System.out.println(x);
        System.out.println("Output:");
        System.out.println(isPalindrome(x));
        System.out.println();
        */
        runTests();
    }

    public static void runTests() {
        testPalindrome(121, true);
        testPalindrome(-121, false);
        testPalindrome(10, false);
        testPalindrome(12321, true);
        testPalindrome(7, true);
        testPalindrome(1001, true);
    }

    public static void testPalindrome(int input, boolean expected) {
        boolean result = isPalindrome(input);
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        if (result == expected) {
            System.out.println(ANSI_GREEN + "Test PASSED\n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Test FAILED\n" + ANSI_RESET);
        }
    }

    public static boolean isPalindrome(int x) {
        int aux1 = 0;
        int aux2 = x;

        while (aux2 != 0) {
            aux1 = aux1 * 10 + aux2 % 10;
            aux2 = aux2 / 10;
        }

        if (x < 0) {
            return false;
        } else return x == aux1;
    }
}
