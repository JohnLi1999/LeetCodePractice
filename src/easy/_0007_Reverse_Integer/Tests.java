package easy._0007_Reverse_Integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0007_Reverse_Integer.Solution.reverse;

class Tests {

    @Test
    void test1() {
        int input = 123;
        int expectedResult = 321;
        assertEquals(expectedResult, reverse(input));
    }

    @Test
    void test2() {
        int input = -123;
        int expectedResult = -321;
        assertEquals(expectedResult, reverse(input));
    }

    @Test
    void test3() {
        int input = 120;
        int expectedResult = 21;
        assertEquals(expectedResult, reverse(input));
    }

    @Test
    void test4() {
        int input = -120;
        int expectedResult = -21;
        assertEquals(expectedResult, reverse(input));
    }

    @Test
    void test5() {
        int input = 2147483647; // Integer.MAX_VALUE
        int expectedResult = 0;
        assertEquals(expectedResult, reverse(input));
    }

    @Test
    void test6() {
        int input = 1463847412;
        int expectedResult = 2147483641;
        assertEquals(expectedResult, reverse(input));
    }

    @Test
    void test7() {
        int input = -1463847412;
        int expectedResult = -2147483641;
        assertEquals(expectedResult, reverse(input));
    }
}