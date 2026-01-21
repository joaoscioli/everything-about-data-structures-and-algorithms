package patterns.two_pointers.examples;

/// You are given an array of numbers, each representing the height of a vertical line on a graph.
/// A container can be formed with any pair of these lines, along with the x-axis of the graph.
/// Return the amount of water which the largest container can hold.
///
/// **Example**
/// ````
/// Input: heights = [2, 7, 8, 3, 7, 6]
/// Output: 24
/// ````
///
/// Poor approach:
/// ````java
/// public static int largestContainerBruteForce(int[] heights) {
///     int n = heights.length;
///     int maxWater = 0;
///
///     // Testa todos os pares de linhas
///     for (int i = 0; i< n; i++) {
///         for (int j = i + 1; j< n; j++) {
///             int water = Math.min(heights[i], heights[j]) * (j - i);
///             maxWater = Math.max(maxWater, water);
///         }
///     }
///     return maxWater;
/// }
/// ````
///
/// **Tip**
/// Based on the decisions taken in the example, we can summarize the logic:
/// 1. If the left line is smaller, move the left pointer inward.
/// 2. If the right line is smaller, move the right pointer inward.
/// 3. If both lines have the same height, move both pointers inward.
///
/// **Time complexity:** The time complexity of largest_container is O(n) because we perform approximately n
/// iterations using the two-pointer technique.
/// **Space complexity:** We only allocated a constant number of variables, so the space complexity is
/// 0(1).
public class LargestContainer {

    public static int largestContainer(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {

            // Calcula a água entre as duas linhas atuais
            int water = Math.min(heights[left], heights[right]) * (right - left);
            maxWater = Math.max(maxWater, water);

            // Move o ponteiro da menor altura
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                // Se forem iguais, move ambos
                left++;
                right--;
            }
        }

        return maxWater;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(largestContainer(heights)); // 49
    }
}
