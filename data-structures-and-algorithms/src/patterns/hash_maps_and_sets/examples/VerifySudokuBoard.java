package patterns.hash_maps_and_sets.examples;

import java.util.HashSet;
import java.util.Set;

/// **Verify Sudoku Board**
/// Given a partially completed 9x9 Sudoku board, determine if the current state of the board
/// adheres to the rules of the game:
/// - Each row and column must contain unique numbers between 1 and 9, or be empty
/// (represented as 0).
/// - Each of the nine 3x3 subgrids that compose the grid must contain unique numbers
/// > between 1 and 9, or be empty.
/// Note: You are asked to determine whether the current state of the board is valid given
/// these rules, not whether the board is solvable.
///
/// **Example:**
/// Sudoku Game:
/// ````java
/// [3,0,6,0,5,8,4,0,0]
/// [5,2,0,0,0,0,0,0,0]
/// [0,8,7,0,0,0,0,3,1]
/// [1,0,2,5,0,0,3,2,0]
/// [9,0,0,8,6,3,0,0,5]
/// [0,5,0,0,9,0,6,0,0]
/// [0,3,0,0,0,8,2,5,0]
/// [0,1,0,0,0,0,0,7,4]
/// [0,0,5,2,0,6,0,0,0]
/// Output: false
/// ````
/// Constraints:
/// - Assume each integer on the board falls in the range of [0,9].
///
/// Complexity Analysis
/// In this problem, the length of the board is fixed at 9, effectively reducing all approaches to a time
/// and space complexity of 0(1). However, to better understand the efficiency of our algorithm in a
/// broader context, let's use n to denote the board’s length, allowing us to evaluate the algorithm’s
/// performance against arbitrary board sizes.
/// Time complexity: The time complexity of verify_sudoku_board is 0(n2) because we iterate
/// through each cell in the board once, and perform constant-time hash set operations.
/// Space complexity: The space complexity is 0(n2) due to the row_sets, column_sets, and
/// subgrid_5ets arrays. Each array contains n hash sets, and each hash set is capable of growing to
/// a size of n
public class VerifySudokuBoard {

    public static boolean verifySudokuBoard(int[][] board) {
        // Sets para linhas e colunas
        Set<Integer>[] rowSets = new HashSet[9];
        Set<Integer>[] columnSets = new HashSet[9];

        // Sets para subgrids 3x3
        Set<Integer>[][] subgridSets = new HashSet[3][3];

        // Inicialização
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            columnSets[i] = new HashSet<>();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            subgridSets[i][j] = new HashSet<>();
            }
        }

        // Percorre o tabuleiro
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int num = board[r][c];
                if (num == 0) continue; // ignora células vazias

                // Verifica linha, coluna e subgrid
                if (rowSets[r].contains(num)) return false;
                if (columnSets[c].contains(num)) return false;
                if (subgridSets[r / 3][c / 3].contains(num)) return false;

                // Marca como visto
                rowSets[r].add(num);
                columnSets[c].add(num);
                subgridSets[r / 3][c / 3].add(num);
            }
        }

        return true;
    }

    // Exemplo rápido
    public static void main(String[] args) {
    int[][] board = {
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}
    };

    System.out.println(verifySudokuBoard(board)); // true
    }
}

