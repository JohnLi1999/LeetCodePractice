package medium._0198_House_Robber.notes;

public class Sample_DP {
    /*  https://leetcode.com/problems/house-robber/
        Time complexity: O(n)
            Assume that n is the number of houses, the time complexity is O(n).
        Space complexity: O(1)
     */
    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
