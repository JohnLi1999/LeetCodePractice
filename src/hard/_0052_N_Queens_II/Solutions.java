package hard._0052_N_Queens_II;

import java.util.HashSet;
import java.util.Set;

public class Solutions {
    /*  https://leetcode.com/problems/n-queens-ii/
        Time complexity: O(N!)
            There is N possibilities to put the first queen,
            not more than N (N - 2) to put the second one,
            not more than N(N - 2)(N - 4) for the third one etc.
            In total that results in O(N!) time complexity.
        Space complexity: O(N)
            To keep an information about diagonals and rows.
     */

    private static int SIZE;
    private static Set<Integer> column = new HashSet<>();
    private static Set<Integer> diagonal = new HashSet<>();
    private static Set<Integer> anti_diagonal = new HashSet<>();

    public static int totalNQueens(int n) {
        SIZE = n;

        return backtrack(0, 0);
    }

    private static int backtrack(int row, int count) {
        for (int col = 0; col < SIZE; col++) {
            if (column.contains(col) || diagonal.contains(row - col) || anti_diagonal.contains(row + col)) {
                continue;
            }

            column.add(col);
            diagonal.add(row - col);
            anti_diagonal.add(row + col);

            if (row == SIZE - 1) {
                count++;
            } else {
                count = backtrack(row + 1, count);
            }

            column.remove(col);
            diagonal.remove(row - col);
            anti_diagonal.remove(row + col);
        }

        return count;
    }
}
