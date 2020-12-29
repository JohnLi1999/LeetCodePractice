package medium._0003_Longest_Substring_Without_Repeating_Characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Way solutionMyWay = new Solution_My_Way();
    Solution_Better solution_better = new Solution_Better();

    @Test
    void test1() {
        String s = "devedfecg";
        assertEquals(5, solutionMyWay.lengthOfLongestSubstring(s));
        assertEquals(5, solution_better.lengthOfLongestSubstring(s));
    }

    @Test
    void test2() {
        String s = "dvdf";
        assertEquals(3, solutionMyWay.lengthOfLongestSubstring(s));
        assertEquals(3, solution_better.lengthOfLongestSubstring(s));
    }

    @Test
    void test3() {
        String s = "pwwkew";
        assertEquals(3, solutionMyWay.lengthOfLongestSubstring(s));
        assertEquals(3, solution_better.lengthOfLongestSubstring(s));
    }

    @Test
    void test4() {
        String s = "abcabcbb";
        assertEquals(3, solutionMyWay.lengthOfLongestSubstring(s));
        assertEquals(3, solution_better.lengthOfLongestSubstring(s));
    }

    @Test
    void test5() {
        String s = "bbbbb";
        assertEquals(1, solutionMyWay.lengthOfLongestSubstring(s));
        assertEquals(1, solution_better.lengthOfLongestSubstring(s));
    }
}