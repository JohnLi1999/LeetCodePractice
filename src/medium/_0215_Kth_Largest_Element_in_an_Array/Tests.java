package medium._0215_Kth_Largest_Element_in_an_Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static medium._0215_Kth_Largest_Element_in_an_Array.Solution.findKthLargest_Sort;
import static medium._0215_Kth_Largest_Element_in_an_Array.Solution.findKthLargest_Heap;
import static medium._0215_Kth_Largest_Element_in_an_Array.Solution.findKthLargest_QuickSelect;

class Tests {

    @Test
    void test1() {
        int[] input = {99, 99};
        int k = 1;
        int expectedResult = 99;
        assertEquals(expectedResult, findKthLargest_QuickSelect(input, k));
    }

    @Test
    void test2() {
        int[] input = {1};
        int k = 1;
        int expectedResult = 1;
        assertEquals(expectedResult, findKthLargest_QuickSelect(input, k));
    }

    @Test
    void test3() {
        int[] input = {2, 1};
        int k = 2;
        int expectedResult = 1;
        assertEquals(expectedResult, findKthLargest_QuickSelect(input, k));
    }

    @Test
    void test4() {
        int[] input = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expectedResult = 5;
        assertEquals(expectedResult, findKthLargest_QuickSelect(input, k));
    }

    @Test
    void test5() {
        int[] input = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int expectedResult = 4;
        assertEquals(expectedResult, findKthLargest_QuickSelect(input, k));
    }

    @Test
    void test6() {
        int[] input = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expectedResult = 5;
        assertEquals(expectedResult, findKthLargest_Heap(input, k));
    }

    @Test
    void test7() {
        int[] input = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int expectedResult = 4;
        assertEquals(expectedResult, findKthLargest_Heap(input, k));
    }

    @Test
    void test8() {
        int[] input = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expectedResult = 5;
        assertEquals(expectedResult, findKthLargest_Sort(input, k));
    }

    @Test
    void test9() {
        int[] input = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int expectedResult = 4;
        assertEquals(expectedResult, findKthLargest_Sort(input, k));
    }
}