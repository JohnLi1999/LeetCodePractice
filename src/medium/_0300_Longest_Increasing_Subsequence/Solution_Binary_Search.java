package medium._0300_Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.List;

public class Solution_Binary_Search {
    /*  Time complexity: O(n*log(n))
            Binary search takes log(n) time and it is called n times.
        Space complexity: O(n)
            The size of the sequence can be up to n.
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> LIS = new ArrayList<>();

        for (int num : nums) {
            int index = binarySearch(LIS, num);

            if (index == LIS.size()) {
                LIS.add(num);
            } else {
                LIS.set(index, num);
            }
        }

        return LIS.size();
    }

    private int binarySearch(List<Integer> list, int num) {
        if (list.size() == 0) {
            return 0;
        }

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (num <= list.get(middle)) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return low;
    }
}
