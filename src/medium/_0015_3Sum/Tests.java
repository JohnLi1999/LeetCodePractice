package medium._0015_3Sum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static medium._0015_3Sum.Solution.threeSum;

class Tests {

    @Test
    void test1() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expectedResult = List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );
        assertEquals(expectedResult, threeSum(input));
    }

    @Test
    void test2() {
        int[] input = {0, 0, 0};
        List<List<Integer>> expectedResult = List.of(
                List.of(0, 0, 0)
        );
        assertEquals(expectedResult, threeSum(input));
    }
}