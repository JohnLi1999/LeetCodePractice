package medium._0039_Combination_Sum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Way solutionMyWay = new Solution_My_Way();
    Solution_Better solution_better = new Solution_Better();

    @Test
    void test1() {
        int[] candidates = new int[] {2, 3, 6, 7};
        int target = 10;
        List<List<Integer>> result = List.of(
                List.of(2, 2, 2, 2, 2),
                List.of(2, 2, 3, 3),
                List.of(2, 2, 6),
                List.of(3, 7)
        );
        assertEquals(result, solutionMyWay.combinationSum(candidates, target));
        assertEquals(result, solution_better.combinationSum(candidates, target));
    }

    @Test
    void test2() {
        int[] candidates = new int[] {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = List.of(
                List.of(2, 2, 3),
                List.of(7)
        );
        assertEquals(result, solutionMyWay.combinationSum(candidates, target));
        assertEquals(result, solution_better.combinationSum(candidates, target));
    }

    @Test
    void test3() {
        int[] candidates = new int[] {2, 3, 5};
        int target = 8;
        List<List<Integer>> result = List.of(
                List.of(2, 2, 2, 2),
                List.of(2, 3, 3),
                List.of(3, 5)
        );
        assertEquals(result, solutionMyWay.combinationSum(candidates, target));
        assertEquals(result, solution_better.combinationSum(candidates, target));
    }
}