package Problem5;

import java.util.Arrays;

// 5. Longest Palindromic Substring
// Medium
public class LongestPalindrome {
    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_GREEN = "\033[32m";
    public static final String ANSI_RED = "\033[31m";

    public static void main(String[] args) {
        /*
        System.out.println("** TEST CASE 1 **");
        String s1 = "babad";
        System.out.println("Input:");
        System.out.println(s1);
        System.out.println("Output:");
        System.out.println(longestPalindrome(s1));
        System.out.println();

        System.out.println("** TEST CASE 2 **");
        String s2 = "cbbd";
        System.out.println("Input:");
        System.out.println(s2);
        System.out.println("Output:");
        System.out.println(longestPalindrome(s2));
        System.out.println();
        */
        runTests();
    }

    public static void runTests() {
        testLongestPalindrome("babad", "bab", "aba");
        testLongestPalindrome("cbbd", "bb");
        testLongestPalindrome("a", "a");
        testLongestPalindrome("racecar", "racecar");
        testLongestPalindrome("abcd", "a", "b", "c", "d");
        testLongestPalindrome("", "");
        testLongestPalindrome("aaaa", "aaaa");
    }

    public static void testLongestPalindrome(String input, String... expected) {
        String result = longestPalindrome(input);
        System.out.println("Input: " + input);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Result: " + result);

        boolean passed = Arrays.asList(expected).contains(result);
        if (passed) {
            System.out.println(ANSI_GREEN + "Test PASSED\n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Test FAILED\n" + ANSI_RESET);
        }
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
