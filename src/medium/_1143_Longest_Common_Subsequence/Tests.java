package medium._1143_Longest_Common_Subsequence;

import medium._1143_Longest_Common_Subsequence.notes.Dynamic_Programming;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Dynamic_Programming solutionDynamicProgramming = new Solution_Dynamic_Programming();

    @Test
    void test1() {
        String text1 = "abcde";
        String text2 = "ace";
        assertEquals(3, solutionDynamicProgramming.longestCommonSubsequence(text1, text2));
    }

    @Test
    void test2() {
        String text1 = "abc";
        String text2 = "abc";
        assertEquals(3, solutionDynamicProgramming.longestCommonSubsequence(text1, text2));
    }

    @Test
    void test3() {
        String text1 = "abc";
        String text2 = "def";
        assertEquals(0, solutionDynamicProgramming.longestCommonSubsequence(text1, text2));
    }

    @Test
    void test4() {
        String text1 = "abace";
        String text2 = "aabece";
        assertEquals(4, solutionDynamicProgramming.longestCommonSubsequence(text1, text2));
    }

    @Test
    void test5() {
        String text1 = "pmjghexybyrgzczy";
        String text2 = "hafcdqbgncrcbihkd";
        assertEquals(4, solutionDynamicProgramming.longestCommonSubsequence(text1, text2));
    }
}