package medium._0091_Decode_Ways;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Nested
    class DP_Bottom_Up {
        Solution_DP_Bottom_Up solution = new Solution_DP_Bottom_Up();

        @Test
        void test1() {
            String s = "12";
            assertEquals(2, solution.numDecodings(s));
        }

        @Test
        void test2() {
            String s = "226";
            assertEquals(3, solution.numDecodings(s));
        }

        @Test
        void test3() {
            String s = "206";
            assertEquals(1, solution.numDecodings(s));
        }

        @Test
        void test4() {
            String s = "017";
            assertEquals(0, solution.numDecodings(s));
        }

        @Test
        void test5() {
            String s = "0";
            assertEquals(0, solution.numDecodings(s));
        }

        @Test
        void test6() {
            String s = "2236";
            assertEquals(3, solution.numDecodings(s));
        }

        @Test
        void test7() {
            String s = "22006";
            assertEquals(0, solution.numDecodings(s));
        }
    }

    @Nested
    class DP_Memoization {

        Solution_DP_Memoization solution = new Solution_DP_Memoization();

        @Test
        void test1() {
            String s = "12";
            assertEquals(2, solution.numDecodings(s));
        }

        @Test
        void test2() {
            String s = "226";
            assertEquals(3, solution.numDecodings(s));
        }

        @Test
        void test3() {
            String s = "206";
            assertEquals(1, solution.numDecodings(s));
        }

        @Test
        void test4() {
            String s = "017";
            assertEquals(0, solution.numDecodings(s));
        }

        @Test
        void test5() {
            String s = "0";
            assertEquals(0, solution.numDecodings(s));
        }

        @Test
        void test6() {
            String s = "2236";
            assertEquals(3, solution.numDecodings(s));
        }

        @Test
        void test7() {
            String s = "22006";
            assertEquals(0, solution.numDecodings(s));
        }
    }

    @Nested
    class Pure_Recursion {

        Solution_Pure_Recursion solution = new Solution_Pure_Recursion();

        @Test
        void test1() {
            String s = "12";
            assertEquals(2, solution.numDecodings(s));
        }

        @Test
        void test2() {
            String s = "226";
            assertEquals(3, solution.numDecodings(s));
        }

        @Test
        void test3() {
            String s = "206";
            assertEquals(1, solution.numDecodings(s));
        }

        @Test
        void test4() {
            String s = "017";
            assertEquals(0, solution.numDecodings(s));
        }

        @Test
        void test5() {
            String s = "0";
            assertEquals(0, solution.numDecodings(s));
        }

        @Test
        void test6() {
            String s = "2236";
            assertEquals(3, solution.numDecodings(s));
        }

        @Test
        void test7() {
            String s = "22006";
            assertEquals(0, solution.numDecodings(s));
        }
    }
}