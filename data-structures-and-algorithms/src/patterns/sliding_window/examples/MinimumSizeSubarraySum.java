package patterns.sliding_window.examples;

/// Problem
///
/// Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray whose sum is greater than or equal to target.
/// If there is no such subarray, return 0.
///
/// Example
/// ````java
/// Input:
/// target = 7
/// nums = [2,3,1,2,4,3]
/// Output:
/// 2
/// Explanation:
/// [4,3] has sum = 7 and length = 2 (minimum possible)
/// ````
///
/// Complexity
/// - Time: O(n)
/// - Space: O(1)
/// Each element:
/// - Added once
/// - Removed once
///
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
