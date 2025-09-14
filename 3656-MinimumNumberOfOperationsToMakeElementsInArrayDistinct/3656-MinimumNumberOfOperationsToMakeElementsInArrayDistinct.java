// Last updated: 9/14/2025, 12:53:03 PM
class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0; // already distinct if size 0 or 1
        }

        int front = 0;      // Points to the "current front" of the subarray
        int operations = 0; // Count how many times we remove elements

        while (true) {
            // Check if the current subarray [front..end] is distinct
            if (isDistinct(nums, front)) {
                // Distinct => done
                return operations;
            }

            // Not distinct => remove 3 from the front
            // If fewer than 3 remain, remove them all (front = n)
            front += 3;
            if (front >= n) {
                // We've removed everything
                return operations + 1;
            }
            operations++;
        }
    }

    // Helper: checks if subarray [start..end] in nums has distinct elements
    private boolean isDistinct(int[] nums, int start) {
        Set<Integer> seen = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                return false;
            }
            seen.add(nums[i]);
        }
        return true;
    }
}