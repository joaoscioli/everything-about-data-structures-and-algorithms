package patterns.two_pointers.examples;

import java.util.*;


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
