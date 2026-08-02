import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.merge(c, 1, Integer::sum);
        }

        for (char c : t.toCharArray()) {
            Integer count = frequency.get(c);
            if (count == null) {
                return false;
            }
            if (count == 1) {
                frequency.remove(c);
            } else {
                frequency.put(c, count - 1);
            }
        }

        return frequency.isEmpty();
    }
}
