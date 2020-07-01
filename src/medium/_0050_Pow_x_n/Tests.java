package medium._0050_Pow_x_n;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static medium._0050_Pow_x_n.Solution.myPow_Recursive;
import static medium._0050_Pow_x_n.notes.Iterative_Method.myPow;

class Tests {

    @Nested
    class Recursive {
        @Test
        void test1() {
            double input = 2.0;
            int pow = 10;
            double expectResult = 1024.0;
            assertEquals(expectResult, myPow_Recursive(input, pow));
        }

        @Test
        void test2() {
            double input = 2.0;
            int pow = -2;
            double expectResult = 0.25;
            assertEquals(expectResult, myPow_Recursive(input, pow));
        }

        @Test
        void test3() {
            double input = 1.0;
            int pow = 2147483647;
            double expectResult = 1.0;
            assertEquals(expectResult, myPow_Recursive(input, pow));
        }
    }

    @Nested
    class Iterative {
        @Test
        void test1() {
            double input = 2.0;
            int pow = 10;
            double expectResult = 1024.0;
            assertEquals(expectResult, myPow(input, pow));
        }

        @Test
        void test2() {
            double input = 2.0;
            int pow = -2;
            double expectResult = 0.25;
            assertEquals(expectResult, myPow(input, pow));
        }

        @Test
        void test3() {
            double input = 1.0;
            int pow = 2147483647;
            double expectResult = 1.0;
            assertEquals(expectResult, myPow(input, pow));
        }
    }
}