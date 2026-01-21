package patterns.two_pointers.examples;

/// **Is Palindrome Valid**
///
/// A palindrome is a sequence of characters that reads the same forward and backward.
/// Given a string, determine if it’s a palindrome after removing all non-alphanumeric characters, A character is alphanumeric if it's either a letter or a number.
///
/// Example 1:
/// ````
/// Inputs = "a dogl a panic in a pagoda."
/// I Output: True
/// ````
///
/// Example 2:
/// ````
/// Input: s = "abcl23"
/// || Output False
/// ````
/// Constraints:
/// The string may include a combination of lowercase English letters, numbers, spaces, and
/// punctuations.
///
/// **Complexity Analysis**
/// Time complexity: The time complexity of is_palindrome_valid is O(n). where n denotes the
/// Jength of the string. This is because we perform approximately n iterations using the two-pointer
/// technique.
/// **Space complexity:** We only allocated a constant number of variables, so the space complexity is
/// 0(1).
///
public class IsPalindromeValid {
    public static boolean isPalindromeValid(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Pula caracteres não alfanuméricos pela esquerda
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Pula caracteres não alfanuméricos pela direita
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compara ignorando diferença entre maiúsculas e minúsculas
            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        System.out.println(isPalindromeValid("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindromeValid("race a car")); // false
    }
}
