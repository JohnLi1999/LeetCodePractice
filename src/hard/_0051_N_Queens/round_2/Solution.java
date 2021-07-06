package hard._0051_N_Queens.round_2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<String>> lists = s.solveNQueens(4);
        lists.forEach(list -> {
            list.forEach(str -> {
                char[] arr = str.toCharArray();
                for (char c : arr) {
                    System.out.print(c + " ");
                }
                System.out.println();
            });
            System.out.println();
        });
    }

    private final List<List<Integer>> results = new ArrayList<>();
    private final List<Integer> result = new ArrayList<>();
    private final Set<Integer> cols = new HashSet<>();
    private final Set<Integer> diagonals = new HashSet<>();
    private final Set<Integer> antiDiagonals = new HashSet<>();

    /*  Use backtracking
        Time complexity: O(n^4) -- my guess
            Wrong above, should be O(n!)
        Space complexity: O(n^2)
            The results list needs O(n^2) space
     */
    public List<List<String>> solveNQueens(int n) {
        /*
            Diagonal: top left -> bottom right (row - col)
                 0  1  2
              0  0 -1 -2
              1  1  0 -1
              2  2  1  0

            Anti-diagonal: top right -> bottom left (row + col)
                 0  1  2
              0  0  1  2
              1  1  2  3
              2  2  3  4
         */
        /* We only need to check
            col,
            diagonal,
            anti-diagonal
         */

        helper(0, n);
        return printResult(results);
    }

    public void helper(int row, int n) {
        // End of the game
        if (row == n) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) ||
                diagonals.contains(row - col) ||
                antiDiagonals.contains(row + col)) {
                continue;
            }

            result.add(col);
            cols.add(col);
            diagonals.add(row - col);
            antiDiagonals.add(row + col);

            helper(row + 1, n);

            result.remove(result.size() - 1);
            cols.remove(col);
            diagonals.remove(row - col);
            antiDiagonals.remove(row + col);
        }
    }

    public List<List<String>> printResult(List<List<Integer>> results) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list;
        StringBuilder sb;

        for (List<Integer> result : results) {
            list = new ArrayList<>();
            for (int pos : result) {
                sb = new StringBuilder();
                for (int i = 0; i < result.size(); i++) {
                    if (i == pos) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            lists.add(list);
        }

        return lists;
    }
}
