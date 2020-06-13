package medium._0015_3Sum;

import org.junit.jupiter.api.Test;

import java.util.List;;

import static medium._0015_3Sum.Solution.threeSum;

public class Tests {

    @Test
    public void test1() {
        int[] arr = {-2, 0, -5, -2, 0, -3, 1, -4, 0, -2, 4};
        List<List<Integer>> list = threeSum(arr);

        System.out.println(list);
        // expected: [[-5, 1, 4], [-4, 0, 4], [-2, -2, 4], [0, 0, 0]]
    }
}