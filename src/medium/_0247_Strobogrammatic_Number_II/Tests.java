package medium._0247_Strobogrammatic_Number_II;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution solution = new Solution();

    @Test
    void test1() {
        int n = -1;
        List<String> result = List.of();
        assertArrayEquals(
                result.stream().mapToInt(Integer::parseInt).toArray(),
                solution.findStrobogrammatic(n).stream().mapToInt(Integer::parseInt).toArray());
    }

    @Test
    void test2() {
        int n = 1;
        List<String> result = List.of("0", "1", "8");
        assertArrayEquals(
                result.stream().mapToInt(Integer::parseInt).toArray(),
                solution.findStrobogrammatic(n).stream().mapToInt(Integer::parseInt).toArray());
    }

    @Test
    void test3() {
        int n = 2;
        List<String> result = List.of("11", "69", "88", "96");
        assertArrayEquals(
                result.stream().mapToInt(Integer::parseInt).toArray(),
                solution.findStrobogrammatic(n).stream().mapToInt(Integer::parseInt).toArray());
    }

    @Test
    void test4() {
        int n = 3;
        List<String> result = List.of(
                "101", "609", "808", "906",
                "111", "619", "818", "916",
                "181", "689", "888", "986"
        );

        assertArrayEquals(
                result.stream().mapToInt(Integer::parseInt).toArray(),
                solution.findStrobogrammatic(n).stream().mapToInt(Integer::parseInt).toArray());
    }

    @Test
    void test5() {
        int n = 4;
        List<String> result = List.of(
                "1001", "6009", "8008", "9006",
                "1111", "6119", "8118", "9116",
                "1691", "6699", "8698", "9696",
                "1881", "6889", "8888", "9886",
                "1961", "6969", "8968", "9966"
        );

        assertArrayEquals(
                result.stream().mapToInt(Integer::parseInt).toArray(),
                solution.findStrobogrammatic(n).stream().mapToInt(Integer::parseInt).toArray());
    }
}