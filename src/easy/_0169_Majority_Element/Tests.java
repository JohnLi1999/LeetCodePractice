package easy._0169_Majority_Element;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0169_Majority_Element.Solution.majorityElement_HashMap;
import static easy._0169_Majority_Element.Solution.majorityElement_MooreVoting;

class Tests {

    @Nested
    class HashMap {
        @Test
        void test1() {
            int[] input = {3, 2, 3};
            assertEquals(3, majorityElement_HashMap(input));
        }

        @Test
        void test2() {
            int[] input = {2, 2, 1, 1, 1, 2, 2};
            assertEquals(2, majorityElement_HashMap(input));
        }
    }

    @Nested
    class Moore_Voting_Algorithms {
        @Test
        void test1() {
            int[] input = {3, 2, 3};
            assertEquals(3, majorityElement_MooreVoting(input));
        }

        @Test
        void test2() {
            int[] input = {2, 2, 1, 1, 1, 2, 2};
            assertEquals(2, majorityElement_MooreVoting(input));
        }
    }
}