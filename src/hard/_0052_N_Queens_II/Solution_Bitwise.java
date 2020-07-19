package hard._0052_N_Queens_II;

/*  Time complexity: O(N!)
    Space complexity: O(N)
 */
public class Solution_Bitwise {
    private int count = 0;

    public int totalNQueens(int n) {
        /*  We use bitwise operations to get the result
            1. Let's take n = 4 as an example
            2. We start with 0 for all cols, diagonal, and anti-diagonals
               This means cols          = 0b0000
                          diagonal      = 0b0000
                          anti-diagonal = 0b0000
            3. Bit-0 represents the cell is allowed, and
               Bit-1 represents the cell is not allowed (will be attacked)
         */
        backtrack(n, 0, 0, 0, 0);

        // Return the counter after backtracking
        return count;
    }

    private void backtrack(int n, int row, int cols, int diagonals, int anti_diagonals) {
        /*  Base case for the recursion:
            When we have placed n queens, we increase the counter and return  */
        if (row >= n) {
            count++;
            return;
        }

        /*  We divide the next line of code into three steps.
            1. cols | diagonals | anti_diagonals
                This step uses bitwise-OR operator to get all the allowed the not allowed columns.
                e.g. cols          = 0b1000
                     diagonal      = 0b0100
                 |   anti-diagonal = 0b0000
               -------------------------------
                            result = 0b1100
                The example means now the first two columns is not allowed anymore, and
                the last two columns are available in the next row.
            2. ~ (cols | diagonals | anti_diagonals)
                We use the result from the last step 0b1100.
                So, ~ result = 0b0011.
                We reverse the bits so that bit-1 is the place that is allowed in the next row.
                Reason we add this reverse logic here is that
                we can apply bitwise operations to easily get the rightmost bit-1
                and turn off the rightmost bit-1 (1 -> 0)
            3. (1 << n) - 1
                This part is a mask to prevent us to use unnecessary bit-1.
                Type int in Java has 32 bits, so the result 0b0011 is actually like this:
                0b11111111111111111111111111110011.
                Only last four bits are useful to us, so we apply this mask (1 << n) - 1, n = 4.
                    result       = 0b11111111111111111111111111110011
                    (1 << n) - 1 = 0b00000000000000000000000000001111
                    -------------------------------------------------- &
                       free_cols = 0b00000000000000000000000000000011
         */
        int free_cols = (~ (cols | diagonals | anti_diagonals)) & ((1 << n) - 1);

        /*  As long as free_cols is larger than 0, it means we still have free columns
            So we keep searching until there is no free columns  */
        while (free_cols > 0) {
            /*  x & (-x) is the bitwise operation to get the rightmost bit-1
                In this step, we use it to get the next free column  */
            int next_free_col = free_cols & (-free_cols);

            // Backtrack for the next row
            backtrack(
                    n,
                    row + 1,
                    cols | next_free_col, // Mark next_free_col as not allowed in cols
                    /*  Mark next_free_col as not allowed in diagonals.
                        Shift one bit to the right since it matches the direction for the diagonal  */
                    (diagonals | next_free_col) >> 1,
                    /*  Mark next_free_col as not allowed in anti-diagonals.
                        Shift one bit to the left since it matches the direction for the anti-diagonal  */
                    (anti_diagonals | next_free_col) << 1
            );

            /*  Here we return back from the last recursion.
                So we need to turn off the rightmost bit-1 to indicate that
                we have searched that columns already, and that is not a free column anymore */
            free_cols &= (free_cols - 1);
        }
    }
}
