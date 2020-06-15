package medium._0018_4Sum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static medium._0018_4Sum.Solution.fourSum;

class Tests {

    @Test
    void test1() {
        int[] input = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> expectedResult = List.of(
                List.of(-2, -1, 1, 2),
                List.of(-2,  0, 0, 2),
                List.of(-1,  0, 0, 1)
        );
        assertEquals(expectedResult, fourSum(input, target));
    }
}