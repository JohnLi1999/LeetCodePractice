package medium._0022_Generate_Parentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*  https://leetcode.com/problems/generate-parentheses/
        Time Complexity: O(4^n / sqrt(n))
        Space Complexity: O(4^n / sqrt(n))
        See "0022. Generate Parentheses.png" for more explanation on Time and Space Complexity
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();

        // Backtracking with String
//        backtrack(0, 0, n, "", result);

        // Backtracking with StringBuilder
        backtrack(0, 0, n, 0, new StringBuilder(), result);

        return result;
    }

    // Backtracking with String
    private static void backtrack(int numOpen, int numClose, int n, String temp, List<String> result) {
        // Add the valid string into result list
        if (temp.length() == 2 * n) {
            result.add(temp);
            return;
        }

        // Add "(" to temp string as long as the number of open brackets is smaller than n
        if (numOpen < n) {
            backtrack(numOpen + 1, numClose, n, temp + "(", result);
        }

        // Add ")" to temp string as long as the number of close brackets is smaller than the number of open bracket
        if (numClose < numOpen) {
            backtrack(numOpen, numClose + 1, n, temp + ")", result);
        }
    }

    // Backtracking with StringBuilder
    private static void backtrack(int numOpen, int numClose, int n, int pos, StringBuilder temp, List<String> result) {
        // Validate current string. If it is invalid, then remove the last character
        if (numOpen > n || numClose > n || numClose > numOpen) {
            temp.delete(temp.length() - 1, temp.length());
            return;
        }

        // Add the open bracket and go to next position
        temp.append("(");
        backtrack(numOpen + 1, numClose, n, pos + 1, temp, result);

        // Clear the unnecessary characters in the  StringBuilder
        if (temp.length() > pos) {
            temp.delete(pos, temp.length());
        }

        // Add the close bracket
        temp.append(")");
        if (temp.length() == 2 * n) {
            // Add the valid string into result list
            result.add(temp.toString());
        } else {
            // Go to next position
            backtrack(numOpen, numClose + 1, n, pos + 1, temp, result);
        }
    }
}
