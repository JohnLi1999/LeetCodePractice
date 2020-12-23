package medium._0039_Combination_Sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*  Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
    Time Complexity: O(N^{T/M + 1})
    Space Complexity: O(T/M)
 */
public class Solution_Better {
    private List<List<Integer>> results = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;

        LinkedList<Integer> solution = new LinkedList<>();
        backtracking(0, target, solution);
        return results;
    }

    private void backtracking(int start, int target, LinkedList<Integer> solution) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            results.add(new LinkedList<>(solution));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            solution.add(candidates[i]);
            backtracking(i, target - candidates[i], solution);
            solution.removeLast();
        }
    }
}
