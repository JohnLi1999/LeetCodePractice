package hard._0239_Sliding_Window_Maximum.notes;

public class Use_Hammer {
    /*  Time complexity: O(Nk)
            Where N is number of elements in the array.
        Space complexity: O(N−k+1)
            For an output array.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }
}
