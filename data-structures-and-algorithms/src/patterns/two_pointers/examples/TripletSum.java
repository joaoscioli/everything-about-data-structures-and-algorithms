package patterns.two_pointers.examples;

import java.util.*;

/// **Triplet Sum**
/// Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0. The
/// solution must not contain duplicate triplets (e.g.. [1, 2, 3] and [2, 3, 1] are considered
/// duplicate triplets). If no such triplets are found, return an empty array.
/// Each triplet can be arranged in any order, and the output can be returned in any order.
/// Example:
/// Input nums = [0, -1, 2, -3, 1]
/// , Output: [[-3, 1, 2], [-1, 0, 1]]
///
/// Poor approach:
/// ````
///     public static List<List<Integer>> tripletSumBruteForce(int[] nums) {
///         int n = nums.length;
///
///         //Set para evitar triplets duplicados
///         Set<List<Integer>> triplets = new HashSet<>();
///
///         // Itera sobre todas as combinações possiveis de triplets
///         for (int i = 0; i < n; i++) {
///             for (int j = i+1; j < n; j++) {
///                 for (int k = j + 1; k < n; k++) {
///                     if (nums[i] + nums[j] + nums[k] == 0) {
///                         // Cria o triplet
///                         List<Integer> triplet = Arrays.asList(
///                                 nums[i],
///                                 nums[j],
///                                 nums[k]
///                         );
///
///                         // Ordena para garantir unicidade no Set
///                         Collections.sort(triplet);
///                         triplets.add(triplet);
///                     }
///                 }
///             }
///         }
///         // Convert o Set para List
///         return new ArrayList<>(triplets);
///     }
/// ````
///
/// Time complexity:
/// Time complexity: The time complexity of triplet_sum is O(n^2). Here’s why:
/// • We first sort the array, which takes O(n log(n)) time.
/// • Then, for each of then elements in the array, we call pair_sum_sorted_all_pairs at most
/// once, which runs in O(n) time.
/// Therefore, the overall time complexity is O(nlog(n)) + O(n2) = O(n2).
///
/// **Space complexity:** The space complexity isO(n) due to the space taken up by Python’s sorting algorithm. It’s important to note that this complexity does not include the output array triplets because we're only concerned with the additional space used by the algorithm, not the space needed
/// for the output itself.
///
/// **Interview Tip:**
/// If the interviewer asks what the space complexity would be if we included the output array, it would
/// be O(n^2). This is because the pair_sum_sorted_all_pairs function, in the worst case, can add
/// approximately n pairs to the output. Since this function is called approximately n times, the overall
/// space complexity would be O(n^2).
///
import java.util.*;

public class TripletSum {

    public static List<List<Integer>> tripletSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        // Ordena o array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // Otimização: se nums[i] > 0, não há como somar 0
            if (nums[i] > 0) {
                break;
            }

            // Evita triplets duplicados (skip do 'a')
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Procura pares que somam -nums[i]
            List<List<Integer>> pairs =
                    pairSumSortedAllPairs(nums, i + 1, -nums[i]);

            for (List<Integer> pair : pairs) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.addAll(pair);
                triplets.add(triplet);
            }
        }

        return triplets;
    }

    private static List<List<Integer>> pairSumSortedAllPairs(
            int[] nums, int start, int target) {

        List<List<Integer>> pairs = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                pairs.add(Arrays.asList(nums[left], nums[right]));
                left++;

                // Evita pares duplicados (skip do 'b')
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(tripletSum(nums));
    }
}
