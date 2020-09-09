package medium._0247_Strobogrammatic_Number_II;

import java.util.LinkedList;
import java.util.List;

/*  https://leetcode.com/problems/strobogrammatic-number-ii/
    Time Complexity: O(n^2)
        We have to add  the current string list in each recursive call
    Space Complexity: O(n^2)
        We have to store all previous generated strings
 */
public class Solution {
    private int N;

    public List<String> findStrobogrammatic(int n) {
        N = n;
        return find(n);
    }

    private List<String> find(int n) {
        if (n < 0) {
            return new LinkedList<>();
        }

        if (n == 0) {
            return List.of("");
        }

        if (n == 1) {
            return List.of("0", "1", "8");
        }

        List<String> list = find(n - 2);
        List<String> newList = new LinkedList<>();
        for (String s : list) {
            if (n != N) {
                newList.add("0" + s + "0");
            }
            newList.add("1" + s + "1");
            newList.add("6" + s + "9");
            newList.add("8" + s + "8");
            newList.add("9" + s + "6");
        }

        return newList;
    }
}
