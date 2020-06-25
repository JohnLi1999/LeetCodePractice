package medium._0098_Validate_Binary_Search_Tree;

import utils.tree_node.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /*  https://leetcode.com/problems/validate-binary-search-tree/
        Time complexity: O(N)
            Since we visit each node exactly once.
        Space complexity: O(N)
            Since we keep up to the entire tree.
     */
    public static boolean isValidBST_Recursion(TreeNode root) {
        // Set initial lower and upper boundary to null for the root node
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode root, Integer lower, Integer upper) {
        // Return true when getting to the end of the tree
        if (root == null) {
            return true;
        }

        /*  Return false if the value of the node is
            smaller or equal to the lower boundary OR
            larger or equal to the upper boundary
         */
        if (lower != null && root.val <= lower ||
            upper != null && root.val >= upper) {
            return false;
        }

        /*  Apply the same check recursively for left and right subtrees
            1. When moving form root to its left child, we need to set upper boundary to root.val
               and keep the lower boundary as before
            2. When moving from root to its right child, we need to set lower boundary to root.val
               and keep the upper boundary as before
         */
        return validate(root.left, lower, root.val) && validate(root.right, root.val, upper);
    }

    /*  Time complexity: O(N)
            In the worst case when the tree is BST or the "bad" element is a rightmost leaf.
        Space complexity: O(N)
            Since we keep up to the entire tree.
     */
    public static boolean isValidBST_InOrderTraverse(TreeNode root) {
        Integer[] result = new Integer[] {null, 1};
        inOrderTraverse(root, result);
        return result[1] == 1;
    }

    private static void inOrderTraverse(TreeNode root, Integer[] result) {
        if (root == null || result[1] == 0) {
            return;
        }
        inOrderTraverse(root.left, result);
        if (result[0] == null || root.val > result[0]) {
            result[0] = root.val;
        } else {
            result[1] = 0;
        }
        inOrderTraverse(root.right, result);
    }

    /*  Time complexity: O(N)
         In the worst case when the tree is BST or the "bad" element is a rightmost leaf.
     Space complexity: O(N)
         To keep stack.
  */
    public static boolean isValidBST_InOrderTraverse_Iterative(TreeNode root) {
        // Use a stack to save tree nodes
        Deque<TreeNode> stack = new ArrayDeque<>();
        // Track the values in an in-order traversal
        Integer prev = null;

        while (root != null || !stack.isEmpty()) {
            // Keep saving left subtrees until reach the end
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Get the last node from the the stack
            root = stack.pop();
            // Return false if the current value is smaller or equal to the previous value in the traversal
            if (prev != null && root.val <= prev) {
                return false;
            }

            // Update previous value and start check right subtrees
            prev = root.val;
            root = root.right;
        }

        return true;
    }
}
