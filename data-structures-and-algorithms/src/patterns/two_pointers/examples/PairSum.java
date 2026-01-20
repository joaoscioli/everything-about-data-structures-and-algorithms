package patterns.two_pointers.examples;

import java.util.Arrays;

/// Pair Sum - Sorted
/// Given an array of integers sorted in ascending order and a target value, return the indexes
/// of any pair of numbers in the array that sum to the target. The order of the indexes in the
/// result doesn’t matter. If no pair is found, return an empty array.
///
/// **Example 1:**
/// ```` java
/// i Input nums = (-5, -2, 3, 4, 6], target = 7
/// Output: [2, 3]
/// Explanation: nums[2] + nums[3] = 3 + 4 = 7
/// ````
///
/// **Example 2:**
/// ```` java
/// Input nums - [1, 1, 1], target = 2
/// Output: [0, 1]
/// Explanation: other valid outputs could be [1, 0], [6, 2], [2^ 0], [1, 2] or/// [2, 1].
/// ````
///
/// Poor approach:
///- Time Complexity: O(n²)
///- Space Complexity: O(1)
/// Even though it's a sorted array, this version doesn't take advantage of the sorting.
/// ``` java
///  static int[] pair_sum_sorted_brute_force(int[]  nums, int target) {
///     int n = nums.length;
///
///     for (int i=0; i<n; i++) {
///         for (int j=i+1; j<n; j++) {
///             if (nums[i] + nums[j] == targt) {
///                 return new int[]{i, j};
///             }
///         }
///    }
/// return new int[]{};
/// }
/// ````
/// Time complexity: The time complexity of pair_sum_sorted is O(n) because we perform appr0Xj.
/// mately n iterations using the two-pointer technique in the worst case.
/// Space complexity: We only allocated a constant number of variables, so the space complexity it
/// o(i).
///
/// **Interview Tip:**
/// When interviewers pose a problem, they sometimes provide only the minimum amount of
/// information required for you to startsolving it. Consequently, it’s crucial to thoroughly evaluate
/// all that information to determine which details are essential forsolving the problem efficiently.
/// In this problem, the key to arriving at the optimal solution is recognizing that the input is sorted.

public class PairSum {
    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            // If the sum is smaller, move left pointer to increase the sum
            if (sum < target) {
                left++;
            }
            // If the sum is larger, move right pointer to decrease the sum
            else if (sum > target) {
                right--;
            }
            // Target pair found
            else {
                return new int[]{left, right};
            }
        }

        return new int[]{}; // no pair found
    }


    void main() {
        int[] nums = new int[]{-5, -2, 3, 4, 6};
        int target = 7;
        int[] result = pairSumSorted(nums, target);
        IO.println(Arrays.toString(result));
    }
}