package medium._0022_Generate_Parentheses.notes;

import java.util.ArrayList;
import java.util.List;

public class Closure_Number {
    /*  Dynamic Programming Approach. Useful Link for some explanation:
        https://leetcode.com/problems/generate-parentheses/discuss/10127/An-iterative-method

        Time Complexity: O(4^n / sqrt(n))
        Space Complexity: O(4^n / sqrt(n))
        See "0022. Generate Parentheses.png" for more explanation on Time and Space Complexity
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}