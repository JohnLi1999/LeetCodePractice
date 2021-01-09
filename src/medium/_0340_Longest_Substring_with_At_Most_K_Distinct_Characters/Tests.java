package medium._0340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Way solution_my_way = new Solution_My_Way();
    Solution_LinkedHashMap solution_linkedHashMap = new Solution_LinkedHashMap();
    Solution_Count_Map solution_count_map = new Solution_Count_Map();
    Solution_Count_Array solution_count_array = new Solution_Count_Array();

    @Test
    void test1() {
        String s = "eceba";
        int k = 2;
        assertEquals(3, solution_my_way.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(3, solution_linkedHashMap.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(3, solution_count_map.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(3, solution_count_array.lengthOfLongestSubstringKDistinct(s, k));
    }

    @Test
    void test2() {
        String s = "aa";
        int k = 1;
        assertEquals(2, solution_my_way.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(2, solution_linkedHashMap.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(2, solution_count_map.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(2, solution_count_array.lengthOfLongestSubstringKDistinct(s, k));
    }

    @Test
    void test3() {
        String s = "a";
        int k = 2;
        assertEquals(1, solution_my_way.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(1, solution_linkedHashMap.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(1, solution_count_map.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(1, solution_count_array.lengthOfLongestSubstringKDistinct(s, k));
    }

    @Test
    void test4() {
        String s = "abaccc";
        int k = 2;
        assertEquals(4, solution_my_way.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(4, solution_linkedHashMap.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(4, solution_count_map.lengthOfLongestSubstringKDistinct(s, k));
        assertEquals(4, solution_count_array.lengthOfLongestSubstringKDistinct(s, k));
    }
}