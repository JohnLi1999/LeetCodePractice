package medium._0338_Counting_Bits;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static medium._0338_Counting_Bits.Solution.countBits;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        int input = 2;
        int[] expectedResult = {0, 1, 1};
        assertTrue(Arrays.equals(expectedResult, countBits(input)));
    }

    @Test
    void test2() {
        int input = 5;
        int[] expectedResult = {0, 1, 1, 2, 1, 2};
        assertTrue(Arrays.equals(expectedResult, countBits(input)));
    }
}