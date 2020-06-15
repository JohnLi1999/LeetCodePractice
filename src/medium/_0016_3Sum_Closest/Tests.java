package medium._0016_3Sum_Closest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static medium._0016_3Sum_Closest.Solution.threeSumClosest;

class Tests {

    @Test
    void test1() {
        int[] input = {-1, 2, 1, -4};
        int target = 1;
        int expectedResult = 2;
        assertEquals(expectedResult, threeSumClosest(input, target));
    }

    @Test
    void test2() {
        int[] input = {1, 2, 5, 10, 11};
        int target = 12;
        int expectedResult = 13;
        assertEquals(expectedResult, threeSumClosest(input, target));
    }

    @Test
    void test3() {
        int[] input = {0, 1, 2};
        int target = 3;
        int expectedResult = 3;
        assertEquals(expectedResult, threeSumClosest(input, target));
    }
}