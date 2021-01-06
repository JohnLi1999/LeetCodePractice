package hard._0044_Wildcard_Matching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Recursion_My_Way solution_recursion_my_way = new Solution_Recursion_My_Way();
    Solution_Memoization_My_Way solution_memoization_my_way = new Solution_Memoization_My_Way();
    Solution_DP_My_Way solution_dp_my_way = new Solution_DP_My_Way();

    @Test
    void test1() {
        String s = "aa";
        String p = "a";
        assertFalse(solution_recursion_my_way.isMatch(s, p));
        assertFalse(solution_memoization_my_way.isMatch(s, p));
        assertFalse(solution_dp_my_way.isMatch(s, p));
    }

    @Test
    void test2() {
        String s = "aa";
        String p = "*";
        assertTrue(solution_recursion_my_way.isMatch(s, p));
        assertTrue(solution_memoization_my_way.isMatch(s, p));
        assertTrue(solution_dp_my_way.isMatch(s, p));
    }

    @Test
    void test3() {
        String s = "cb";
        String p = "?a";
        assertFalse(solution_recursion_my_way.isMatch(s, p));
        assertFalse(solution_memoization_my_way.isMatch(s, p));
        assertFalse(solution_dp_my_way.isMatch(s, p));
    }

    @Test
    void test4() {
        String s = "adceb";
        String p = "*a*b";
        assertTrue(solution_recursion_my_way.isMatch(s, p));
        assertTrue(solution_memoization_my_way.isMatch(s, p));
        assertTrue(solution_dp_my_way.isMatch(s, p));
    }

    @Test
    void test5() {
        String s = "acdcb";
        String p = "a*c?b";
        assertFalse(solution_recursion_my_way.isMatch(s, p));
        assertFalse(solution_memoization_my_way.isMatch(s, p));
        assertFalse(solution_dp_my_way.isMatch(s, p));
    }

    @Test
    void test6() {
        String s = "acdcb";
        String p = "a*c?b*";
        assertFalse(solution_recursion_my_way.isMatch(s, p));
        assertFalse(solution_memoization_my_way.isMatch(s, p));
        assertFalse(solution_dp_my_way.isMatch(s, p));
    }
}