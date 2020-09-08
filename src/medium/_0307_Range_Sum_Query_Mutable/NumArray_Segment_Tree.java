package medium._0307_Range_Sum_Query_Mutable;

public class NumArray_Segment_Tree {
    private SegmentTreeNode root;
    private int[] nums;

    /*  https://leetcode.com/problems/range-sum-query-mutable/
        Time complexity: O(n)
        Space complexity: O(n)
            We used N extra space to store the segment tree.
     */
    public NumArray_Segment_Tree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        this.nums = nums;
        root = buildTree(0, nums.length - 1);
    }

    /*  https://leetcode.com/problems/range-sum-query-mutable/
        Time complexity: O(log(n)).
        Space complexity : O(1).
     */
    public void update(int i, int val) {
        int diff = nums[i] - val;
        nums[i] = val;

        if (root != null) {
            update(root, i, diff);
        }
    }

    /*  https://leetcode.com/problems/range-sum-query-mutable/
        Time complexity: O(log(n)).
        Space complexity : O(1).
     */
    public int sumRange(int i, int j) {
        if (root != null) {
            return getSumInRange(root, i, j);
        }
        return 0;
    }

    /*  Time Complexity: O(N)
            Need to traverse all the elements in the array
     */
    private SegmentTreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end);

        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(start, mid);
            node.right = buildTree(mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }

        return node;
    }

    /*  Time Complexity: O(log(N))  */
    private int getSumInRange(SegmentTreeNode root, int start, int end) {
        if (root == null || start > root.end || end < root.start) {
            return 0;
        }
        if (start <= root.start && end >= root.end) {
            return root.sum;
        }

        int leftSum = getSumInRange(root.left, start, end);
        int rightSum = getSumInRange(root.right, start, end);
        return leftSum + rightSum;
    }

    /*  Time Complexity: O(log(N))  */
    private void update(SegmentTreeNode root, int pos, int diff) {
        if (root == null || pos < root.start || pos > root.end) {
            return;
        }

        if (pos >= root.start && pos <= root.end) {
            root.sum -= diff;
        }

        update(root.left, pos, diff);
        update(root.right, pos, diff);
    }
}

class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
