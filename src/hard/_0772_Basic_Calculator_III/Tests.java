package hard._0772_Basic_Calculator_III;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Tests {

    @Nested
    class Using_Queue_Stack_Recursion {
        Solution_Queue_Stack_Recursion solution_queue_stack_recursion = new Solution_Queue_Stack_Recursion();

        @Test
        void test1() {
            String s = "1 + 1";
            assertEquals(2, solution_queue_stack_recursion.calculate(s));
        }

        @Test
        void test2() {
            String s = " 6-4 / 2 ";
            assertEquals(4, solution_queue_stack_recursion.calculate(s));
        }

        @Test
        void test3() {
            String s = "2*(5+5*2)/3+(6/2+8)";
            assertEquals(21, solution_queue_stack_recursion.calculate(s));
        }

        @Test
        void test4() {
            String s = "(2+6* 3+5- (3*14/7+2)*5)+3";
            assertEquals(-12, solution_queue_stack_recursion.calculate(s));
        }

        @Test
        void test5() {
            String s = "0";
            assertEquals(0, solution_queue_stack_recursion.calculate(s));
        }

        @Test
        void test6() {
            String s = "1*2-3/4+5*6-7*8+9/10";
            assertEquals(-24, solution_queue_stack_recursion.calculate(s));
        }

        @Test
        void test7() {
            String s = "0-2147483648";
            assertEquals(-2147483648, solution_queue_stack_recursion.calculate(s));
        }

        @Test
        void test8() {
            String s = "2-(5-6)";
            assertEquals(3, solution_queue_stack_recursion.calculate(s));
        }

        @Test
        void test9() {
            String s = "1-(2+3-(4+(5-(1-(2+4-(5+6))))))";
            assertEquals(-1, solution_queue_stack_recursion.calculate(s));
        }
    }

    @Nested
    class My_Way {
        Solution_My_Way_Super_Slow solution_my_way_super_slow = new Solution_My_Way_Super_Slow();

        @Test
        void test1() {
            String s = "1 + 1";
            assertEquals(2, solution_my_way_super_slow.calculate(s));
        }

        @Test
        void test2() {
            String s = " 6-4 / 2 ";
            assertEquals(4, solution_my_way_super_slow.calculate(s));
        }

        @Test
        void test3() {
            String s = "2*(5+5*2)/3+(6/2+8)";
            assertEquals(21, solution_my_way_super_slow.calculate(s));
        }

        @Test
        void test4() {
            String s = "(2+6* 3+5- (3*14/7+2)*5)+3";
            assertEquals(-12, solution_my_way_super_slow.calculate(s));
        }

        @Test
        void test5() {
            String s = "0";
            assertEquals(0, solution_my_way_super_slow.calculate(s));
        }

        @Test
        void test6() {
            String s = "1*2-3/4+5*6-7*8+9/10";
            assertEquals(-24, solution_my_way_super_slow.calculate(s));
        }

        @Test
        void test7() {
            String s = "0-2147483648";
            assertEquals(-2147483648, solution_my_way_super_slow.calculate(s));
        }

        @Test
        void test8() {
            String s = "2-(5-6)";
            assertEquals(3, solution_my_way_super_slow.calculate(s));
        }

        @Test
        void test9() {
            String s = "1-(2+3-(4+(5-(1-(2+4-(5+6))))))";
            assertEquals(-1, solution_my_way_super_slow.calculate(s));
        }
    }
}