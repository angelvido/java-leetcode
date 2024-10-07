# Two Sum Problem

---
**Difficulty:** Easy

## Problem Statement

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to the target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.

### Example

```plaintext
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
````

### Approach

We can solve this problem efficiently using a hash map (or dictionary). The key idea is to traverse the list while keeping track of the numbers we have seen so far and their corresponding indices. As we iterate through the list, for each number, we check if the difference between the target and the current number exists in the hash map. If it does, we have found our answer. Otherwise, we store the current number and its index in the hash map.

### Steps

1. **Initialize** an empty hash map to store the numbers we have encountered and their indices.
2. **Iterate** through the array of numbers.
3. For each number, **calculate** the difference needed to reach the target.
4. **Check** if this difference exists in the hash map:
   - If it exists, **return** the index of the difference and the current index.
   - If it does not exist, **store** the current number along with its index in the hash map.
5. If no solution is found by the end of the iteration, **return** an empty array.

### Complexity Analysis

- **Time Complexity:** O(n), where n is the number of element in the `nums` array. We transverse the array once, performing constant time operations for each element.
- **Space Complexity:** O(n), for storing the elements in the hash map.

### Solution

```java
class Solution{
    public int[] twoSum(int[] nums, int target) {
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
```