package Problem2;

import SpecialClasses.ListNode;

// 2. Add Two Numbers
// Medium
public class AddTwoNumbers {
    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_GREEN = "\033[32m";
    public static final String ANSI_RED = "\033[31m";

    public static void main(String[] args) {
        /*
        System.out.println("** TEST CASE 1 **");
        ListNode l11 = new ListNode(2);
        l11.next = new ListNode(4);
        l11.next.next = new ListNode(3);

        ListNode l21 = new ListNode(5);
        l21.next = new ListNode(6);
        l21.next.next = new ListNode(4);

        System.out.println("Input:");
        printList(l11);
        printList(l21);
        System.out.println("Output:");
        printList(addTwoNumbers(l11, l21));
        System.out.println();

        System.out.println("** TEST CASE 2 **");
        ListNode l12 = new ListNode(0);

        ListNode l22 = new ListNode(0);

        System.out.println("Input:");
        printList(l12);
        printList(l22);
        System.out.println("Output:");
        printList(addTwoNumbers(l12, l22));
        System.out.println();

        System.out.println("** TEST CASE 3 **");
        ListNode l13 = new ListNode(9);
        l13.next = new ListNode(9);
        l13.next.next = new ListNode(9);
        l13.next.next.next = new ListNode(9);
        l13.next.next.next.next = new ListNode(9);
        l13.next.next.next.next.next = new ListNode(9);
        l13.next.next.next.next.next.next = new ListNode(9);

        ListNode l23 = new ListNode(9);
        l23.next = new ListNode(9);
        l23.next.next = new ListNode(9);
        l23.next.next.next = new ListNode(9);

        System.out.println("Input:");
        printList(l13);
        printList(l23);
        System.out.println("Output:");
        printList(addTwoNumbers(l13, l23));
        System.out.println();
        */
        runTests();
    }

    public static void runTests() {
        ListNode l11 = new ListNode(2);
        l11.next = new ListNode(4);
        l11.next.next = new ListNode(3);

        ListNode l21 = new ListNode(5);
        l21.next = new ListNode(6);
        l21.next.next = new ListNode(4);

        testAddTwoNumbers(l11, l21, new int[]{7, 0, 8});

        ListNode l12 = new ListNode(0);
        ListNode l22 = new ListNode(0);
        testAddTwoNumbers(l12, l22, new int[]{0});

        ListNode l13 = new ListNode(9);
        l13.next = new ListNode(9);
        l13.next.next = new ListNode(9);
        l13.next.next.next = new ListNode(9);
        l13.next.next.next.next = new ListNode(9);
        l13.next.next.next.next.next = new ListNode(9);
        l13.next.next.next.next.next.next = new ListNode(9);

        ListNode l23 = new ListNode(9);
        l23.next = new ListNode(9);
        l23.next.next = new ListNode(9);
        l23.next.next.next = new ListNode(9);

        testAddTwoNumbers(l13, l23, new int[]{8, 9, 9, 9, 0, 0, 0, 1});
    }

    public static void testAddTwoNumbers(ListNode l1, ListNode l2, int[] expected) {
        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Input List 1: ");
        printList(l1);
        System.out.println("Input List 2: ");
        printList(l2);
        System.out.println("Expected Output: ");
        printArray(expected);
        System.out.println("Actual Output: ");
        printList(result);

        if (listEquals(result, expected)) {
            System.out.println(ANSI_GREEN + "Test PASSED\n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Test FAILED\n" + ANSI_RESET);
        }
    }

    public static boolean listEquals(ListNode result, int[] expected) {
        int i = 0;
        while (result != null) {
            if (i >= expected.length || result.val != expected[i]) {
                return false;
            }
            result = result.next;
            i++;
        }
        return i == expected.length;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(digit);
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}
