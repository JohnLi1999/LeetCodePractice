package easy._0028_Implement_strStr_method.notes;

/*  https://leetcode.com/problems/implement-strstr/
    Time complexity: O((N−L)*L)
        Where N is a length of haystack and L is a length of needle.
        We compute a substring of length L in a loop, which is executed (N - L) times.
    Space complexity: O(1)
 */
public class Substring_Linear_Time_Slice {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}