package easy._0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import utils.tree_node.TreeNode;

public class Solution {
    /*  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
        Time Complexity: O(N)
            Where N is the number of nodes in the BST.
            In the worst case we might be visiting all the nodes of the BST.
        Space Complexity: O(N)
            This is because the maximum amount of space utilized by
            the recursion stack would be N since the height of a skewed BST could be N.
     */
    public static TreeNode lowestCommonAncestor_Recursive(TreeNode root, TreeNode p, TreeNode q) {
        /*  According to the property of a Binary Search Tree, the Lowest Common Ancestor (LCA)
            will be between TreeNode p and q. This means
            p.val <= LCA.val <= q.val OR q.val <= LCA.val <= p.val
         */

        if (root.val > p.val && root.val > q.val) {
            /*  If root.val is larger than the values of p and q,
                that means the LCA is in the left subtree, so we
                keep traversing the left subtree
             */
            return lowestCommonAncestor_Recursive(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            /*  If root.val is smaller than the values of p and q,
                that means the LCA is in the right subtree, so we
                keep traversing the right subtree
             */
            return lowestCommonAncestor_Recursive(root.right, p, q);
        } else {
            // Otherwise, it means we have found the LCA
            return root;
        }
    }

    /*  Time Complexity: O(N)
            Where N is the number of nodes in the BST.
            In the worst case we might be visiting all the nodes of the BST.
        Space Complexity: O(1)
     */
    public static TreeNode lowestCommonAncestor_Iterative(TreeNode root, TreeNode p, TreeNode q) {
        // Same logic as the recursive way, and with less space used
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
