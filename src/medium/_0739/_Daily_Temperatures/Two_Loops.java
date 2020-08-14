package medium._0739._Daily_Temperatures;

/*  https://leetcode.com/problems/daily-temperatures/
    Time Complexity: O(N^2)
        Where N is the length of T.
        Since we used two nested loops
    Space Complexity: O(N).
        We need to O(N) space for the result array
 */
public class Two_Loops {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }
}
