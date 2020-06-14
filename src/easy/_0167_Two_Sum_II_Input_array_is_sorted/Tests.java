package easy._0167_Two_Sum_II_Input_array_is_sorted;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0167_Two_Sum_II_Input_array_is_sorted.Solution.twoSum;

class Tests {

    @Test
    void test1() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = {1, 2};
        assertTrue(Arrays.equals(expectedResult, twoSum(numbers, target)));
    }

    @Test
    void test2() {
        int[] numbers = {0, 1};
        int target = 1;
        int[] expectedResult = {1, 2};
        assertTrue(Arrays.equals(expectedResult, twoSum(numbers, target)));
    }

    @Test
    void test3() {
        int[] numbers = {0, 1, 3, 3};
        int target = 6;
        int[] expectedResult = {3, 4};
        assertTrue(Arrays.equals(expectedResult, twoSum(numbers, target)));
    }

    @Test
    void test4() {
        int[] numbers = {0, 1, 3, 4, 9, 12, 20};
        int target = 16;
        int[] expectedResult = {4, 6};
        assertTrue(Arrays.equals(expectedResult, twoSum(numbers, target)));
    }

    @Test
    void test5() {
        int[] numbers = {-2, -1, 0, 1, 3, 5};
        int target = 2;
        int[] expectedResult = {2, 5};
        assertTrue(Arrays.equals(expectedResult, twoSum(numbers, target)));
    }
}