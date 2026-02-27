package patterns.sliding_window.examples;

/// Problem
/// Given an array of positive integers nums and an integer k, return the number of contiguous subarrays where the product of all elements is strictly less than k.
/// Example
/// ````java
/// Input:
/// nums = [10, 5, 2, 6]
/// k = 100
/// Output:
/// 8
/// Explanation:
/// Valid subarrays:
/// [10]
/// [5]
/// [2]
/// [6]
/// [10,5]
/// [5,2]
/// [2,6]
/// [5,2,6]
/// ````
///
/// Complexity
/// - Time: O(n)
/// - Space: O(1)
/// Each element:
/// - Enters once
/// - Leaves once
///
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
