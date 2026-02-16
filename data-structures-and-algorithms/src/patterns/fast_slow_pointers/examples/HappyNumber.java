package patterns.fast_slow_pointers.examples;

/// Happy Number
/// In number theory, a happy number is defined as a number that, when repeatedly subjected
/// to the process of squaring its digits and summing those squares, eventually leads to 1 [1).
/// An unhappy number wilt never reach 1 during this process, and will get stuck in an infinite
/// loop.
/// Given an integer, determine if it’s a happy number.
///
/// Example:
/// ````java
/// Input: n = 23
/// Output: True
/// Explanation: 2^2 + 3^2 = 1^3 => 1^2 + 3^2 = 10 =» 1^2 + 0^2 = 1
/// ````
///
/// Complexity Analysis
/// Time complexity: The time complexity of happy_number is O(log(n)). The full analysis of thistime
/// complexity is quite complicated and beyond the scope of interviews. For interested readers, please
/// see the reference below for a detailed analysis [2].
/// Space complexity: The space complexity is 0(1).
public class HappyNumber {

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (true) {
            slow = getNextNum(slow);                 // move 1 passo
            fast = getNextNum(getNextNum(fast));     // move 2 passos

            // Se chegar em 1, é um happy number
            if (fast == 1) {
                return true;
            }

            // Se slow == fast, existe um ciclo (não chega em 1)
            if (slow == fast) {
                return false;
            }
        }
    }

    private static int getNextNum(int x) {
        int nextNum = 0;

        while (x > 0) {
            int digit = x % 10;     // pega o último dígito
            x /= 10;                // remove o último dígito
            nextNum += digit * digit;
        }

        return nextNum;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int n = 23;
        System.out.println(isHappy(n)); // true
    }
}

