package hard._0010_Regular_Expression_Matching;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    
    @Nested
    class DP {
        Solution_DP solution_dp = new Solution_DP();

        @Test
        void test1() {
            String s = "aa";
            String p = "a";
            assertFalse(solution_dp.isMatch(s, p));
        }

        @Test
        void test2() {
            String s = "aa";
            String p = "a*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test3() {
            String s = "ab";
            String p = ".*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test4() {
            String s = "aab";
            String p = "c*a*b*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test5() {
            String s = "mississippi";
            String p = "mis*is*p*.";
            assertFalse(solution_dp.isMatch(s, p));
        }

        @Test
        void test6() {
            String s = "mississippi";
            String p = "mis*is*ip*.";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test7() {
            String s = "ab";
            String p = ".*c";
            assertFalse(solution_dp.isMatch(s, p));
        }

        @Test
        void test8() {
            String s = "abxzczbbba";
            String p = "a.*c.*z.*a";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test9() {
            String s = "aaa";
            String p = "a*a";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test10() {
            String s = "aaaa";
            String p = "a*a*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test11() {
            String s = "a";
            String p = "a*a";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test12() {
            String s = "ab";
            String p = "a*a*a*a*b*b*b";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test13() {
            String s = "aaa";
            String p = "ab*a*c*a";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test14() {
            String s = "aaaa";
            String p = "a*b*a*c*a*b*a";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test15() {
            String s = "aaa";
            String p = "ab*a*c*ab*a*a";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test16() {
            String s = "a";
            String p = "ab*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test17() {
            String s = "ab";
            String p = ".*..";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test18() {
            String s = "ab";
            String p = ".*..c*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test19() {
            String s = "";
            String p = "c*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test20() {
            String s = "";
            String p = "c*c*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test21() {
            String s = "abcd";
            String p = "d*";
            assertFalse(solution_dp.isMatch(s, p));
        }

        @Test
        void test22() {
            String s = "aaa";
            String p = "aaaa";
            assertFalse(solution_dp.isMatch(s, p));
        }

        @Test
        void test23() {
            String s = "ba";
            String p = ".*.";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test24() {
            String s = "abcaaaaaaabaabcabac";
            String p = ".*ab.a.*a*a*.*b*b*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test25() {
            String s = "abcaaaaaaabaabcabac";
            String p = ".*ab.a.*";
            assertTrue(solution_dp.isMatch(s, p));
        }


        @Test
        void test26() {
            String s = "abcaaaaaaabaabcabac";
            String p = "b*a*.*x*ab.a.*a*a*.*b*b*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test27() {
            String s = "cbaacacaaccbaabcb";
            String p = "c*b*b*.*ac*.*bc*a*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test28() {
            String s = "cbaacacaaccbaabcb";
            String p = ".*a.*bc*a*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test29() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test30() {
            String s = "a";
            String p = ".*..a*";
            assertFalse(solution_dp.isMatch(s, p));
        }

        @Test
        void test31() {
            String s = "abbaaaabaabbcba";
            String p = "a*.*ba.*c*..a*.a*.";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test32() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*....";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test33() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*..a*.a*.";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test34() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*....";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test35() {
            String s = "bbbacbaacacaaaba";
            String p = "b*c*b*.a.*a*.*.*b*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test36() {
            String s = "bbbacbaacacaaaba";
            String p = "b*c*b*.a.*";
            assertTrue(solution_dp.isMatch(s, p));
        }

        @Test
        void test37() {
            String s = "aab";
            String p = "b.*";
            assertFalse(solution_dp.isMatch(s, p));
        }
    }

    @Nested
    class Memoization {
        Solution_Memoization solution_memoization = new Solution_Memoization();

        @Test
        void test1() {
            String s = "aa";
            String p = "a";
            assertFalse(solution_memoization.isMatch(s, p));
        }

        @Test
        void test2() {
            String s = "aa";
            String p = "a*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test3() {
            String s = "ab";
            String p = ".*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test4() {
            String s = "aab";
            String p = "c*a*b*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test5() {
            String s = "mississippi";
            String p = "mis*is*p*.";
            assertFalse(solution_memoization.isMatch(s, p));
        }

        @Test
        void test6() {
            String s = "mississippi";
            String p = "mis*is*ip*.";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test7() {
            String s = "ab";
            String p = ".*c";
            assertFalse(solution_memoization.isMatch(s, p));
        }

        @Test
        void test8() {
            String s = "abxzczbbba";
            String p = "a.*c.*z.*a";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test9() {
            String s = "aaa";
            String p = "a*a";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test10() {
            String s = "aaaa";
            String p = "a*a*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test11() {
            String s = "a";
            String p = "a*a";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test12() {
            String s = "ab";
            String p = "a*a*a*a*b*b*b";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test13() {
            String s = "aaa";
            String p = "ab*a*c*a";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test14() {
            String s = "aaaa";
            String p = "a*b*a*c*a*b*a";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test15() {
            String s = "aaa";
            String p = "ab*a*c*ab*a*a";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test16() {
            String s = "a";
            String p = "ab*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test17() {
            String s = "ab";
            String p = ".*..";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test18() {
            String s = "ab";
            String p = ".*..c*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test19() {
            String s = "";
            String p = "c*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test20() {
            String s = "";
            String p = "c*c*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test21() {
            String s = "abcd";
            String p = "d*";
            assertFalse(solution_memoization.isMatch(s, p));
        }

        @Test
        void test22() {
            String s = "aaa";
            String p = "aaaa";
            assertFalse(solution_memoization.isMatch(s, p));
        }

        @Test
        void test23() {
            String s = "ba";
            String p = ".*.";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test24() {
            String s = "abcaaaaaaabaabcabac";
            String p = ".*ab.a.*a*a*.*b*b*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test25() {
            String s = "abcaaaaaaabaabcabac";
            String p = ".*ab.a.*";
            assertTrue(solution_memoization.isMatch(s, p));
        }


        @Test
        void test26() {
            String s = "abcaaaaaaabaabcabac";
            String p = "b*a*.*x*ab.a.*a*a*.*b*b*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test27() {
            String s = "cbaacacaaccbaabcb";
            String p = "c*b*b*.*ac*.*bc*a*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test28() {
            String s = "cbaacacaaccbaabcb";
            String p = ".*a.*bc*a*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test29() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test30() {
            String s = "a";
            String p = ".*..a*";
            assertFalse(solution_memoization.isMatch(s, p));
        }

        @Test
        void test31() {
            String s = "abbaaaabaabbcba";
            String p = "a*.*ba.*c*..a*.a*.";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test32() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*....";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test33() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*..a*.a*.";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test34() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*....";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test35() {
            String s = "bbbacbaacacaaaba";
            String p = "b*c*b*.a.*a*.*.*b*";
            assertTrue(solution_memoization.isMatch(s, p));
        }

        @Test
        void test36() {
            String s = "bbbacbaacacaaaba";
            String p = "b*c*b*.a.*";
            assertTrue(solution_memoization.isMatch(s, p));
        }
    }

    @Nested
    class Recursion {
        Solution_Recursion solution_recursion = new Solution_Recursion();

        @Test
        void test1() {
            String s = "aa";
            String p = "a";
            assertFalse(solution_recursion.isMatch(s, p));
        }

        @Test
        void test2() {
            String s = "aa";
            String p = "a*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test3() {
            String s = "ab";
            String p = ".*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test4() {
            String s = "aab";
            String p = "c*a*b*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test5() {
            String s = "mississippi";
            String p = "mis*is*p*.";
            assertFalse(solution_recursion.isMatch(s, p));
        }

        @Test
        void test6() {
            String s = "mississippi";
            String p = "mis*is*ip*.";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test7() {
            String s = "ab";
            String p = ".*c";
            assertFalse(solution_recursion.isMatch(s, p));
        }

        @Test
        void test8() {
            String s = "abxzczbbba";
            String p = "a.*c.*z.*a";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test9() {
            String s = "aaa";
            String p = "a*a";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test10() {
            String s = "aaaa";
            String p = "a*a*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test11() {
            String s = "a";
            String p = "a*a";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test12() {
            String s = "ab";
            String p = "a*a*a*a*b*b*b";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test13() {
            String s = "aaa";
            String p = "ab*a*c*a";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test14() {
            String s = "aaaa";
            String p = "a*b*a*c*a*b*a";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test15() {
            String s = "aaa";
            String p = "ab*a*c*ab*a*a";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test16() {
            String s = "a";
            String p = "ab*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test17() {
            String s = "ab";
            String p = ".*..";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test18() {
            String s = "ab";
            String p = ".*..c*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test19() {
            String s = "";
            String p = "c*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test20() {
            String s = "";
            String p = "c*c*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test21() {
            String s = "abcd";
            String p = "d*";
            assertFalse(solution_recursion.isMatch(s, p));
        }

        @Test
        void test22() {
            String s = "aaa";
            String p = "aaaa";
            assertFalse(solution_recursion.isMatch(s, p));
        }

        @Test
        void test23() {
            String s = "ba";
            String p = ".*.";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test24() {
            String s = "abcaaaaaaabaabcabac";
            String p = ".*ab.a.*a*a*.*b*b*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test25() {
            String s = "abcaaaaaaabaabcabac";
            String p = ".*ab.a.*";
            assertTrue(solution_recursion.isMatch(s, p));
        }


        @Test
        void test26() {
            String s = "abcaaaaaaabaabcabac";
            String p = "b*a*.*x*ab.a.*a*a*.*b*b*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test27() {
            String s = "cbaacacaaccbaabcb";
            String p = "c*b*b*.*ac*.*bc*a*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test28() {
            String s = "cbaacacaaccbaabcb";
            String p = ".*a.*bc*a*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test29() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test30() {
            String s = "a";
            String p = ".*..a*";
            assertFalse(solution_recursion.isMatch(s, p));
        }

        @Test
        void test31() {
            String s = "abbaaaabaabbcba";
            String p = "a*.*ba.*c*..a*.a*.";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test32() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*....";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test33() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*..a*.a*.";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test34() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*....";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test35() {
            String s = "bbbacbaacacaaaba";
            String p = "b*c*b*.a.*a*.*.*b*";
            assertTrue(solution_recursion.isMatch(s, p));
        }

        @Test
        void test36() {
            String s = "bbbacbaacacaaaba";
            String p = "b*c*b*.a.*";
            assertTrue(solution_recursion.isMatch(s, p));
        }
    }

    @Nested
    class My_Way {
        Solution_My_Way_Super_Slow_and_Complicated solution_my_way = new Solution_My_Way_Super_Slow_and_Complicated();

        @Test
        void test1() {
            String s = "aa";
            String p = "a";
            assertFalse(solution_my_way.isMatch(s, p));
        }

        @Test
        void test2() {
            String s = "aa";
            String p = "a*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test3() {
            String s = "ab";
            String p = ".*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test4() {
            String s = "aab";
            String p = "c*a*b*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test5() {
            String s = "mississippi";
            String p = "mis*is*p*.";
            assertFalse(solution_my_way.isMatch(s, p));
        }

        @Test
        void test6() {
            String s = "mississippi";
            String p = "mis*is*ip*.";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test7() {
            String s = "ab";
            String p = ".*c";
            assertFalse(solution_my_way.isMatch(s, p));
        }

        @Test
        void test8() {
            String s = "abxzczbbba";
            String p = "a.*c.*z.*a";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test9() {
            String s = "aaa";
            String p = "a*a";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test10() {
            String s = "aaaa";
            String p = "a*a*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test11() {
            String s = "a";
            String p = "a*a";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test12() {
            String s = "ab";
            String p = "a*a*a*a*b*b*b";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test13() {
            String s = "aaa";
            String p = "ab*a*c*a";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test14() {
            String s = "aaaa";
            String p = "a*b*a*c*a*b*a";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test15() {
            String s = "aaa";
            String p = "ab*a*c*ab*a*a";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test16() {
            String s = "a";
            String p = "ab*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test17() {
            String s = "ab";
            String p = ".*..";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test18() {
            String s = "ab";
            String p = ".*..c*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test19() {
            String s = "";
            String p = "c*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test20() {
            String s = "";
            String p = "c*c*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test21() {
            String s = "abcd";
            String p = "d*";
            assertFalse(solution_my_way.isMatch(s, p));
        }

        @Test
        void test22() {
            String s = "aaa";
            String p = "aaaa";
            assertFalse(solution_my_way.isMatch(s, p));
        }

        @Test
        void test23() {
            String s = "ba";
            String p = ".*.";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test24() {
            String s = "abcaaaaaaabaabcabac";
            String p = ".*ab.a.*a*a*.*b*b*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test25() {
            String s = "abcaaaaaaabaabcabac";
            String p = ".*ab.a.*";
            assertTrue(solution_my_way.isMatch(s, p));
        }


        @Test
        void test26() {
            String s = "abcaaaaaaabaabcabac";
            String p = "b*a*.*x*ab.a.*a*a*.*b*b*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test27() {
            String s = "cbaacacaaccbaabcb";
            String p = "c*b*b*.*ac*.*bc*a*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test28() {
            String s = "cbaacacaaccbaabcb";
            String p = ".*a.*bc*a*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test29() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test30() {
            String s = "a";
            String p = ".*..a*";
            assertFalse(solution_my_way.isMatch(s, p));
        }

        @Test
        void test31() {
            String s = "abbaaaabaabbcba";
            String p = "a*.*ba.*c*..a*.a*.";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test32() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*....";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test33() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*..a*.a*.";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test34() {
            String s = "abbaaaabaabbcba";
            String p = ".*ba.*....";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test35() {
            String s = "bbbacbaacacaaaba";
            String p = "b*c*b*.a.*a*.*.*b*";
            assertTrue(solution_my_way.isMatch(s, p));
        }

        @Test
        void test36() {
            String s = "bbbacbaacacaaaba";
            String p = "b*c*b*.a.*";
            assertTrue(solution_my_way.isMatch(s, p));
        }
    }
}