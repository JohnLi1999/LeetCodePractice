package easy._0069_sqrt_x.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.mySqrt(1));
        System.out.println(s.mySqrt(4));
        System.out.println(s.mySqrt(8));
        System.out.println(s.mySqrt(2147395599));
        System.out.println(s.mySqrt(5));
    }

    /*  Time complexity: O(log(n))
        Space complexity: O(1)
     */
    public int mySqrt(int x) {
        if (x * x == x) {
            return x;
        }

        int low = 0;
        int high = x;
        int middle;

        while (low <= high) {
            middle = low + (high - low) / 2;

            long product = (long) middle * middle;

            if (product < x) {
                low = middle + 1;
            } else if (product > x) {
                high = middle - 1;
            } else {
                return middle;
            }
        }

        /*  Now low > high
            => high * high <= x < low * low
            => So return high
         */
        return high;
    }

    public int mySqrt_FirstTry(int x) {
        if (x * x == x) {
            return x;
        }

        int low = 0;
        int high = x;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            double p1 = (double) middle * middle;
            double p2 = (double) (middle + 1) * (middle + 1);

            if (p1 == x || (p1 < x && p2 > x)) {
                return middle;
            } else if (p2 == x) {
                return middle + 1;
            } else if (p1 > x) {
                high = middle;
            } else if (p2 < x)  {
                low = middle + 1;
            }
        }

        return -1;
    }
}
