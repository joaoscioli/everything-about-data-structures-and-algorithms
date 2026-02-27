package patterns.sliding_window.examples;


/// Problem
/// Given an integer array nums and an integer k, return the maximum sum of any contiguous subarray of size k.
/// Example:
/// ````java
/// Input:
/// nums = [2, 1, 5, 1, 3, 2]
/// k = 3
/// Output:
/// 9
/// Explanation:
/// Subarrays of size 3:
/// [2,1,5] = 8
/// [1,5,1] = 7
/// [5,1,3] = 9  ← max
/// [1,3,2] = 6
/// ````
///
/// Complexity
/// - Time: O(n)
/// - Space: O(1)
/// Each element is added once and removed once.
///

public class MaximumSumSubarraySizeK {
    public int maxSumSubarray(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // Slide window
        for (int right = k; right < nums.length; right++) {
            windowSum += nums[right];          // add new element
            windowSum -= nums[right - k];      // remove left element
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
