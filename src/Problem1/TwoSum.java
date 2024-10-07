package Problem1;

import java.util.Arrays;
import java.util.HashMap;

// 1. Two Sum
// Easy
public class TwoSum {
    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_GREEN = "\033[32m";
    public static final String ANSI_RED = "\033[31m";

    public static void main(String[] args) {
        /*
        System.out.println("** TEST CASE 1 **");
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println("Input:");
        System.out.println(Arrays.toString(nums) + ", " + target);
        System.out.println("Output:");
        System.out.println(Arrays.toString(Arrays.stream(twoSum(nums, target)).toArray()));
        System.out.println();

        System.out.println("** TEST CASE 2 **");
        nums = new int[]{3,2,4};
        target = 6;
        System.out.println("Input:");
        System.out.println(Arrays.toString(nums) + ", " + target);
        System.out.println("Output:");
        System.out.println(Arrays.toString(Arrays.stream(twoSum(nums, target)).toArray()));
        System.out.println();

        System.out.println("** TEST CASE 3 **");
        nums = new int[]{3,3};
        target = 6;
        System.out.println("Input:");
        System.out.println(Arrays.toString(nums) + ", " + target);
        System.out.println("Output:");
        System.out.println(Arrays.toString(Arrays.stream(twoSum(nums, target)).toArray()));
        System.out.println();
        */
        runTests();
    }

    public static void runTests() {
        testTwoSum(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1});
        testTwoSum(new int[]{3, 2, 4}, 6, new int[]{1, 2});
        testTwoSum(new int[]{3, 3}, 6, new int[]{0, 1});
    }

    public static void testTwoSum(int[] nums, int target, int[] expected) {
        int[] result = twoSum(nums, target);
        System.out.println("Input: " + Arrays.toString(nums) + ", Target: " + target);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Result: " + Arrays.toString(result));
        if (Arrays.equals(result, expected)) {
            System.out.println(ANSI_GREEN + "Test PASSED\n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Test FAILED\n" + ANSI_RESET);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


}