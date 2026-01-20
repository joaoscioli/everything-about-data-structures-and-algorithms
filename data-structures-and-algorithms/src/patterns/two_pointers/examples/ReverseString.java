package patterns.two_pointers.examples;

/// - Problems: Reverse String
/// - Pattern: Two Pointers
/// - Time Complexity: O(n)
/// - Space Complexity: O(1)

public class ReverseString {
    public void reverse(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

