package easy._0069_sqrt_x;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static easy._0069_sqrt_x.Solution.mySqrt;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Nested
    class Integer_Sqrt {
        @Test
        void test1() {
            int input = 0;
            assertEquals(0, mySqrt(input));
        }

        @Test
        void test2() {
            int input = 1;
            assertEquals(1, mySqrt(input));
        }

        @Test
        void test3() {
            int input = 2;
            assertEquals(1, mySqrt(input));
        }

        @Test
        void test4() {
            int input = 3;
            assertEquals(1, mySqrt(input));
        }

        @Test
        void test5() {
            int input = 4;
            assertEquals(2, mySqrt(input));
        }

        @Test
        void test6() {
            int input = 8;
            assertEquals(2, mySqrt(input));
        }

        @Test
        void test7() {
            int input = 16;
            assertEquals(4, mySqrt(input));
        }

        @Test
        void test8() {
            int input = 2147395599;
            assertEquals(46339, mySqrt(input));
        }
    }

    @Nested
    class Double_Sqrt {
        @Test
        void test1() {
            int input = 4;
            assertEquals(2.0, mySqrt(input, 0.00001));
        }

        @Test
        void test2() {
            int input = 2;
            assertEquals(
                    "1.41421",
                    String.format("%.5f", mySqrt(input, 0.00001))
            );
        }

        @Test
        void test3() {
            int input = 3;
            assertEquals(
                    "1.73205",
                    String.format("%.5f", mySqrt(input, 0.00001))
            );
        }

        @Test
        void test() {
            int input = 0;
            assertEquals(
                    "0.00000",
                    String.format("%.5f", mySqrt(input, 0.00001))
            );
        }

        @Test
        void test6() {
            int input = 1;
            assertEquals(
                    "1.00000",
                    String.format("%.5f", mySqrt(input, 0.00001))
            );
        }

        @Test
        void test7() {
            int input = 2147395599;
            assertEquals(
                    "46339.99999",
                    String.format("%.5f", mySqrt(input, 0.00001))
            );
        }
    }
}