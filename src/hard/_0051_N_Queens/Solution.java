package hard._0051_N_Queens;

import java.util.*;

public class Solution {
    /*  https://leetcode.com/problems/n-queens/
        Time complexity: O(N!)
            There is N possibilities to put the first queen,
            not more than N (N - 2) to put the second one,
            not more than N(N - 2)(N - 4) for the third one etc.
            In total that results in O(N!) time complexity.
        Space complexity: O(N)
            To keep an information about diagonals and rows.
     */

    private static int SIZE;
    private static int[] queens;
    private static Set<Integer> column = new HashSet<>();
    private static Set<Integer> diagonal = new HashSet<>();
    private static Set<Integer> anti_diagonal = new HashSet<>();
    private static List<List<String>> result = new LinkedList<>();

    public static List<List<String>> solveNQueens(int n) {
        SIZE = n;
        queens = new int[SIZE];

        backtrack(0);
        return result;
    }

    private static void backtrack(int row) {
        // If we successfully find N positions, we can add it to the result list
        if (row >= SIZE) {
            addResult(queens);
            return;
        }

        // Iterate all the columns in the current row
        for (int col = 0; col < SIZE; col++) {
            if (column.contains(col) || diagonal.contains(row - col) || anti_diagonal.contains(row + col)) {
                continue;
            }

            // Place the queen in the available place at (row, column)
            queens[row] = col;
            // Exclude the corresponding columns, diagonals, and anti-diagonals from further consideration
            column.add(col);
            diagonal.add(row - col);
            anti_diagonal.add(row + col);

            // Proceed to the next row
            backtrack(row + 1);

            /* If we get here, that means we are in the backtrack
               So we need to remove the queen from the current (row, column) and release the restricted positions
               NOTE: we don't need to change anything in the queen array
                     since the it will be overwritten in the next turn */
            column.remove(col);
            diagonal.remove(row - col);
            anti_diagonal.remove(row + col);
        }
    }

    private static void addResult(int[] queens) {
        // Convert the queen's positions to strings, and add them into the result list
        List<String> list = new LinkedList<>();
        for (int pos : queens) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < queens.length; i++) {
                if (i == pos) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        result.add(list);
    }
}


