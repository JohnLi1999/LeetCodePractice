package medium._0039_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*  https://leetcode.com/problems/combination-sum/
    Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
    Time Complexity: O(N^{T/M + 1})
    Space Complexity: O(T/M)
 */
public class Solution_My_Way {
    private int[] candidates;
    private int target;
    private int upLimit = -1;

    private List<List<Integer>> result = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;

        Arrays.sort(this.candidates);
        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] <= target) {
                upLimit = i;
                break;
            }
        }

        backtrack(0);
        return result;
    }

    // Faster
    private void backtrack(int index) {
        for (int i = index; i <= upLimit; i++) {
            int num = candidates[i];
            sum += num;
            list.add(num);

            if (sum < target) {
                backtrack(i);
            } else {
                if (sum == target) {
                    result.add(new ArrayList<>(list));
                }

                sum -= list.remove(list.size() - 1);
                break;
            }
        }

        if (list.size() > 0) {
            sum -= list.remove(list.size() - 1);
        }
    }

    // More concise
//    private void backtrack(int index) {
//        for (int i = index; i <= upLimit; i++) {
//            int num = candidates[i];
//            sum += num;
//            list.add(num);
//
//            if (sum < target) {
//                backtrack(i);
//            } else if (sum == target) {
//                result.add(new ArrayList<>(list));
//            }
//
//            sum -= list.remove(list.size() - 1);
//        }
//    }
}
