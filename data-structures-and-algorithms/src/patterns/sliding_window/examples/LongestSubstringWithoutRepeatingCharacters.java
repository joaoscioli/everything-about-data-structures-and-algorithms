package patterns.sliding_window.examples;

import java.util.HashSet;
import java.util.Set;

///
///
///
/// Problem
/// Given a string s, return the length of the longest substring without repeating characters.
/// Example 1
/// ````java
/// Input:  s = "abcabcbb"
/// Output: 3
/// Explanation: "abc"
/// ````
/// Example 2
/// ````java
/// Input:  s = "bbbbb"
/// Output: 1
/// Explanation: "b"
/// ````
/// Example 3
/// ````java
/// Input:  s = "pwwkew"
/// Output: 3
/// Explanation: "wke"
/// ````
///
/// Complexity
/// - Time: O(n)
/// - Space: O(k) → at most number of distinct characters
/// Each character:
/// - Enters window once
/// - Leaves window once
/// Amortized O(n).
///
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
