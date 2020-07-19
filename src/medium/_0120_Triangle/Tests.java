package medium._0120_Triangle;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Bottom_Up solution_bottom_up = new Solution_Bottom_Up();
    Solution_Top_Down solution_top_down = new Solution_Top_Down();
    Solution_BruteForce solution_bruteForce = new Solution_BruteForce();

    @Test
    void test1() {
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        int expectedResult = 11;
        assertEquals(expectedResult, solution_bottom_up.minimumTotal(triangle));
        assertEquals(expectedResult, solution_top_down.minimumTotal(triangle));
        assertEquals(expectedResult, solution_bruteForce.minimumTotal(triangle));
    }

    @Test
    void test2() {
        List<List<Integer>> triangle = List.of(
                List.of(-1),
                List.of(2, 3),
                List.of(1, -1, -3)
        );
        int expectedResult = -1;
        assertEquals(expectedResult, solution_bottom_up.minimumTotal(triangle));
        assertEquals(expectedResult, solution_top_down.minimumTotal(triangle));
        assertEquals(expectedResult, solution_bruteForce.minimumTotal(triangle));
    }
}