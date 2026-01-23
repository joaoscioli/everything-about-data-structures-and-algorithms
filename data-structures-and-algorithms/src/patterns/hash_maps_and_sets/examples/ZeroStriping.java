package patterns.hash_maps_and_sets.examples;

import java.util.HashSet;
import java.util.Set;

/// Zero Striping
/// For each zero in an m x n matrix, set its entire row and column to zero in place.
/// **Example:**
/// ```text
/// [1,2,3,4,5]
/// [6,0,8,9,10]
/// [11,12,13,14,15]
/// [16,17,18,19,0]
/// To
/// [1,0,3,4,0]
/// [0,0,0,0,0]
/// [11,0,13,14,0]
/// [0,0,0,0,0]
/// ```
///
/// Poor approach:
/// ````java
/// public static void zeroStripingHashSets(int[][] matrix) {
///         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
///             return;
///         }
///
///         int m = matrix.length;
///         int n = matrix[0].length;
///
///         Set<Integer> zeroRows = new HashSet<>();
///         Set<Integer> zeroCols = new HashSet<>();
///         // Pass 1: identificar linhas e colunas com zero
///         for (intr = 0; r < m; r++) {
///             for (intc = 0; c < n; c++) {
///                 if (matrix[r][c] == 0) {
///                     zeroRows.add(r);
///                     zeroCols.add(c);///                 }
///             }
///         }
///
///        // Pass 2: zerar células
///         for (it r = 0; r < m; r++) {
///             for (int c = 0; c < n; c++) {
///                 if (zeroRows.contains(r) || zeroCols.contains(c)) {
///                     matrix[r][c] = 0;
///                 }
///             }
///         }
/// ````
///
/// **In-place zero-marking strategy**
/// Let’s summarize the above approach into the following steps:
/// 1. Use a flag to indicate if the first row initially contains any zero.
/// 2. Use a flag to indicate if the first column initially contains any zero.
/// 3. Traverse the submatrix, setting zeros in the first row and column to serve as markers for rows
/// and columns that contain zeros.
/// 4. Apply zeros based on markers: iterate through the submatrix that starts from the second row
/// and second column. For each cell, check if its corresponding marker in the first row or column
/// is marked with a zero. If so, set that element to zero.
/// 5. Ifthe first row was initially marked as containing a zero, set all elements in the first row to zero.
/// 6. If the first column was initially marked as having a zero, set all elements in the first column to
/// zero.
///
///
/// **Complexity Analysis**
/// Time complexity: The time complexity of zero_striping is O(m • n). Here s why.
/// - Checking the first row for zeros takes O(m) time, and checking the first column takes 0(n) time.
/// - Then, we perform two passes of the entire matrix, one to mark Os and another to update the
/// matrix based on those markers. Each pass takes O(m • n) time.
/// -  Finally, we iterate through the first row and first column up to once each, which takes 0(m)
/// and 0(n) time, respectively.
/// Therefore, the overall time complexity is O(m)+O(n)+O(m*n)=O(m*n).
/// **Space complexity:** The space complexity is 0(1) because we use the first row and column as markers to track which
/// rows and columns contain zeros, instead of using auxiliary ata s rue ures.
public class ZeroStriping {
    public static void zeroStriping(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Verifica primeira linha
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Verifica primeira coluna
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Usa primeira linha e coluna como marcadores
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        // Atualiza submatriz com base nos marcadores
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Zera primeira linha se necessário
        if (firstRowHasZero) {
            for (int c = 0; c < n; c++) {
                matrix[0][c] = 0;
            }
        }

        // Zera primeira coluna se necessário
        if (firstColHasZero) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
