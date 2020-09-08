package hard._0315_Count_of_Smaller_Numbers_After_Self;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Nested
    class Segment_Tree {
        Solution_Segment_Tree solution = new Solution_Segment_Tree();

        @Test
        void test1() {
            int[] nums = new int[] {5,2,6,1};
            int[] expectedResult = new int[] {2,1,1,0};
            assertArrayEquals(
                    expectedResult,
                    solution.countSmaller(nums).stream().mapToInt(i -> i).toArray()
            );
        }

        @Test
        void test2() {
            int[] nums = new int[] {};
            int[] expectedResult = new int[] {};
            assertArrayEquals(
                    expectedResult,
                    solution.countSmaller(nums).stream().mapToInt(i -> i).toArray()
            );
        }
    }

    @Nested
    class Brute_Force {
        Solution_Brute_Force solution = new Solution_Brute_Force();

        @Test
        void test1() {
            int[] nums = new int[] {5,2,6,1};
            int[] expectedResult = new int[] {2,1,1,0};
            assertArrayEquals(
                    expectedResult,
                    solution.countSmaller(nums).stream().mapToInt(i -> i).toArray()
            );
        }

        @Test
        void test2() {
            int[] nums = new int[] {};
            int[] expectedResult = new int[] {};
            assertArrayEquals(
                    expectedResult,
                    solution.countSmaller(nums).stream().mapToInt(i -> i).toArray()
            );
        }
    }
}