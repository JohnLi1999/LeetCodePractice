package easy._0028_Implement_strStr_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Way solution_my_way = new Solution_My_Way();
    Solution_KMP solution_kmp = new Solution_KMP();

    @Test
    void test1() {
        String haystack = "hello";
        String needle = "ll";
        assertEquals(2, solution_my_way.strStr(haystack, needle));
        assertEquals(2, solution_kmp.strStr(haystack, needle));
    }

    @Test
    void test2() {
        String haystack = "aaaaa";
        String needle = "bba";
        assertEquals(-1, solution_my_way.strStr(haystack, needle));
        assertEquals(-1, solution_kmp.strStr(haystack, needle));
    }

    @Test
    void test3() {
        String haystack = "aa";
        String needle = "";
        assertEquals(0, solution_my_way.strStr(haystack, needle));
        assertEquals(0, solution_kmp.strStr(haystack, needle));
    }

    @Test
    void test4() {
        String haystack = "";
        String needle = "";
        assertEquals(0, solution_my_way.strStr(haystack, needle));
        assertEquals(0, solution_kmp.strStr(haystack, needle));
    }
}