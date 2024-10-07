# Add Two Numbers Problem

---
**Difficulty:** Medium

## Problem Statement

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contains a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except for the number 0 itself.

### Example

```plaintext
Input: l1 = [2, 4, 3], l2 = [5, 6, 4]
Output: [7, 0, 8]
```

### Approach

We will use a dummy head node to build the resulting linked list. The process involves traversing both linked lists, adding corresponding digits along with any carry from the previous addition.

### Steps

1. **Initialize** a `dummyHead` node to help simplify the code for adding new nodes to the result.
2. **Initialize** a pointer `tail` to track the last node in the resulting list.
3. **Initialize** a variable `carry` to handle any overflow from the addition of two digits.
4. **Iterate** through the linked lists until both are fully traversed:
    - Extract the current values from the two lists, treating any missing nodes as zeros.
    - Calculate the sum of the two current digits and the carry.
    - Determine the new digit to store in the result (using modulo 10).
    - Update the carry (using integer division by 10).
    - Create a new node with the calculated digit and attach it to the result list.
5. After processing both lists, check if there's any carry left to add as a new node.
6. Return the linked list starting from the node next to the dummy head.

### Complexity Analysis

- **Time Complexity:** O(max(m, n)), where m and n are the lengths of the two linked lists. We traverse both lists completely.
- **Space Complexity:** O(max(m, n)), which is the space used by the new linked list.

### Solution

```java
class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
```