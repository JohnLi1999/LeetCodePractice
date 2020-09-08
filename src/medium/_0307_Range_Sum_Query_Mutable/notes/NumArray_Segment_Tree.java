package medium._0307_Range_Sum_Query_Mutable.notes;

public class NumArray_Segment_Tree {
    int[] tree;
    int n;

    public NumArray_Segment_Tree(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    /*  Time complexity: O(n)
            we calculate the sum of one node during each iteration of the for loop.
            There are approximately 2n nodes in a segment tree.
            This could be proved in the following way:
            Segmented tree for array with n elements has n leaves (the array elements itself).
            The number of nodes in each level is half the number in the level below.
            So if we sum the number by level we will get:
            n + n/2 + n/4 + n/8 + ... + 1 ≈ 2n
        Space complexity : O(n)O(n).
            We used 2n extra space to store the segment tree.
     */
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    /*  Time complexity: O(log(n))
            There are a few tree nodes with range that include ith array element, one on each level.
            There are log(n) levels.
        Space complexity: O(1)
     */
    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    /*  Time complexity: O(log(n))
            On each iteration of the algorithm we move one level up,
            either to the parent of the current node or to the next sibling of parent to
            the left or right direction till the two boundaries meet.
            In the worst-case scenario this happens at the root after log(n) iterations of the algorithm
        Space complexity: O(1)
     */
    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}
