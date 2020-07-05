package easy._0111_Minimum_Depth_of_Binary_Tree;

import utils.tree_node.TreeNode;

public class Solution {
    /*  https://leetcode.com/problems/minimum-depth-of-binary-tree/
        Time complexity: O(N)
            We visit each node exactly once, thus the time complexity is O(N),
            where N is the number of nodes.
        Space complexity: O(N) worst, O(log(N)) best
            In the worst case, the tree is completely unbalanced,
            e.g. each node has only one child node, the recursion call would occur N times
            (the height of the tree),  therefore the storage to keep the call stack would be O(N).
            But in the best case (the tree is completely balanced),
            the height of the tree would be log(N).
            Therefore, the space complexity in this case would be O(log(N)).
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        /*  We need to reach the leaf in the tree
            So, if a node only have left branch or right branch
            We need to return the minimum depth in that existing branch
         */
        if (root.left == null) {
            return 1 + minDepth(root.right); // return minDepth in right subtree
        }
        if (root.right == null) {
            return 1 + minDepth(root.left); // return minDepth in left subtree
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
