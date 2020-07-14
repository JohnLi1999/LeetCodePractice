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

        // Backtracking_MyWay with String
//        backtrack(0, 0, n, "", result);

        // Backtracking_MyWay with StringBuilder
        backtrack(0, 0, n, 0, new StringBuilder(), result);

        return result;
    }

    // Backtracking_MyWay with String
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

    // Backtracking_MyWay with StringBuilder
    private static void backtrack(int numOpen, int numClose, int n, int pos, StringBuilder temp, List<String> result) {
        // Add the valid string into result list
        if (temp.length() == 2 * n) {
            result.add(temp.toString());
            return;
        }

        // Add one more "(" if the number of open brackets is smaller than n
        if (numOpen < n) {
            backtrack(numOpen + 1, numClose, n, pos + 1, temp.append("("), result);
        }

        // Clear the unnecessary characters in the StringBuilder
        if (temp.length() > pos) {
            temp.delete(pos, temp.length());
        }

        // Add one more ")" if the number of close brackets is smaller than the number of open brackets
        if (numClose < numOpen) {
            backtrack(numOpen, numClose + 1, n, pos + 1, temp.append(")"), result);
        }
    }
}
