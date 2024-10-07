package Problem21;

import SpecialClasses.ListNode;

// 21. Merge Two Sorted Lists
// Easy
public class MergeTwoSortedLists {
    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_GREEN = "\033[32m";
    public static final String ANSI_RED = "\033[31m";

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println("Input:");
        printList(l1);
        printList(l2);
        ListNode merged1 = mergeTwoLists(l1, l2);
        System.out.println("Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4");
        System.out.print("Result: ");
        printList(merged1);
        checkTestResult(merged1, new int[]{1, 1, 2, 3, 4, 4});
        System.out.println();
        System.out.println("Input:");
        System.out.println("null");
        System.out.println("null");
        ListNode merged2 = mergeTwoLists(null, null);
        System.out.println("Expected: (empty)");
        System.out.print("Result: ");
        printList(merged2);
        checkTestResult(merged2, new int[]{});
        System.out.println();
        ListNode l3 = new ListNode(0);
        System.out.println("Input:");
        System.out.println("null");
        printList(l3);
        ListNode merged3 = mergeTwoLists(null, l3);
        System.out.println("Expected: 0");
        System.out.print("Result: ");
        printList(merged3);
        checkTestResult(merged3, new int[]{0});
        System.out.println();
        ListNode l4 = new ListNode(2);
        l4.next = new ListNode(3);
        l4.next.next = new ListNode(4);
        ListNode l5 = new ListNode(1);
        l5.next = new ListNode(2);
        System.out.println("Input:");
        printList(l4);
        printList(l5);
        ListNode merged4 = mergeTwoLists(l4, l5);
        System.out.println("Expected: 1 -> 2 -> 2 -> 3 -> 4");
        System.out.print("Result: ");
        printList(merged4);
        checkTestResult(merged4, new int[]{1, 2, 2, 3, 4});
        System.out.println();
    }

    public static void printList(ListNode node) {
        if (node == null) {
            System.out.println("(empty)");
            return;
        }
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void checkTestResult(ListNode result, int[] expected) {
        ListNode current = result;
        for (int i = 0; i < expected.length; i++) {
            if (current == null || current.val != expected[i]) {
                System.out.println(ANSI_RED + "Test FAILED" + ANSI_RESET);
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println(ANSI_GREEN + "Test PASSED" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Test FAILED" + ANSI_RESET);
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val > list2.val) {
            ListNode aux = list1;
            list1 = list2;
            list2 = aux;
        }

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode previous = list1;

        while (head1 != null && head2 != null) {
            if (head1 == null) {
                previous.next = head2;
                head2 = null;
            }

            if (head1.val > head2.val) {
                previous.next = head2;
                previous = head2;
                head2 = head2.next;
                previous.next = head1;
            } else {
                previous = head1;
                head1 = head1.next;
            }
        }

        if (head2 != null) {
            previous.next = head2;
        }

        previous = null;
        head2 = null;
        head1 = null;
        list2 = null;

        return list1;
    }
}
