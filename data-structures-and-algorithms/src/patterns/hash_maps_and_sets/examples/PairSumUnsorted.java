package patterns.hash_maps_and_sets.examples;

import java.util.HashMap;
import java.util.Map;

/// Pair Sum - Unsorted
/// Given an array of integers, return the indexes of any two numbers that add up to a target
/// The order of the indexes in the result doesn't matter. If no pair is found, return an empty
/// array.
/// **Example:**
/// ````java
/// i, Input: nums = f-lj 3, 4, 2], target = 3
/// Output: [&t 2]
/// Explanation: nums[0] + nums[2] = -1 + 4 = 3
/// ````
/// Constraints:
/// • The same index cannot be used twice in the result
///
/// Poor approach:
/// ````
/// public static int[] pairSumUnsortedTwoPass(int[] nums, int target) {
///         Map<Integer, Integer> numMap = new HashMap<>();
///
///         // First pass: store number -> index
///         for (int i = 0; i < nums.length; i++) {
///             numMap.put(nums[i], i);
///         }
///
///         // Second pass: check complements
///         for (int i = 0; i < nums.length; i++) {
///             int complement = target - nums[i];
///
///             if (numMap.containsKey(complement) && numMap.get(complement) != i) {
///                 return new int[]{i, numMap.get(complement)};
///             }
///         }
///         return new int[]{}; // no solution
/// }
/// ````
///
/// **Complexity Analysis**
/// **Time complexity:** The time complexity of pair_sum_unsorted is O(n) because we iterate through
/// each element in the nums array once and perform constant-time hash map operations during each
/// iteration.
/// **Space complexity:** The space complexity is O(n) since the hash map can grow up to n. in size.
///

public class PairSumUnsorted {

    public static int[] pairSumUnsorted(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int complement = target - x;

            if (hashmap.containsKey(complement)) {
                return new int[]{hashmap.get(complement), i};
            }
            hashmap.put(x, i);
        }
        return new int[]{}; // no solution
    }

    void main() {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = pairSumUnsorted(nums, target);
        System.out.println(result.length > 0
                ? result[0] + ", " + result[1]
                : "No pair found");
    }
}
