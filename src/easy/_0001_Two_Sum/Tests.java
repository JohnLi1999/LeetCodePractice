package easy._0001_Two_Sum;

import org.junit.jupiter.api.Test;

import static easy._0001_Two_Sum.Solution.twoSum;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = new int[] {0, 1};

        assertArrayEquals(expectedResult, twoSum(nums, target));
    }
}