package hard._0239_Sliding_Window_Maximum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static hard._0239_Sliding_Window_Maximum.Solution.maxSlidingWindow;

class Tests {

    @Test
    void test1() {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 1;
        int[] expectedResult = {1, 3, -1, -3, 5, 3, 6, 7};
        assertTrue(Arrays.equals(expectedResult, maxSlidingWindow(input, k)));
    }

    @Test
    void test2() {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 2;
        int[] expectedResult = {3, 3, -1, 5, 5, 6, 7};
        assertTrue(Arrays.equals(expectedResult, maxSlidingWindow(input, k)));
    }

    @Test
    void test3() {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expectedResult = {3, 3, 5, 5, 6, 7};
        assertTrue(Arrays.equals(expectedResult, maxSlidingWindow(input, k)));
    }

    @Test
    void test4() {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 4;
        int[] expectedResult = {3, 5, 5, 6, 7};
        assertTrue(Arrays.equals(expectedResult, maxSlidingWindow(input, k)));
    }

    @Test
    void test5() {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 5;
        int[] expectedResult = {5, 5, 6, 7};
        assertTrue(Arrays.equals(expectedResult, maxSlidingWindow(input, k)));
    }

    @Test
    void test6() {
        int[] input = {7, 2, 4};
        int k = 2;
        int[] expectedResult = {7, 4};
        assertTrue(Arrays.equals(expectedResult, maxSlidingWindow(input, k)));
    }
}