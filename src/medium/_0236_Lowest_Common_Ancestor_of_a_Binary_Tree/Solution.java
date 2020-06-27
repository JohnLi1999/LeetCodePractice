package medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import utils.tree_node.TreeNode;

public class Solution {
    /*  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        Time Complexity: O(N)
            where N is the number of nodes in the binary tree.
            In the worst case we might be visiting all the nodes of the binary tree.
        Space Complexity: O(N)
            This is because the maximum amount of space utilized by the recursion stack
            would be N since the height of a skewed binary tree could be N.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left_lca = lowestCommonAncestor(root.left, p, q);
        TreeNode right_lca = lowestCommonAncestor(root.right, p, q);

        if (left_lca != null && right_lca != null) {
            return root;
        }

        return (left_lca != null) ? left_lca : right_lca;
    }
}
