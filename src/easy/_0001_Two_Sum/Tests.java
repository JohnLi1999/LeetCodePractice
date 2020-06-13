package easy._0001_Two_Sum;

import org.junit.jupiter.api.Test;

import static easy._0001_Two_Sum.Solution.twoSum;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    int[] nums = null;
    int target = 0;
    int[] expectedResult = null;

    @Test
    void test1() {
        nums = new int[] {2, 7, 11, 15};
        target = 9;
        expectedResult = new int[] {0, 1};

        assertArrayEquals(expectedResult, twoSum(nums, target));
    }
}