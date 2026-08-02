import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequency = new HashMap<>();
        prefixFrequency.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            count += prefixFrequency.getOrDefault(prefixSum - k, 0);
            prefixFrequency.merge(prefixSum, 1, Integer::sum);
        }

        return count;
    }
}
