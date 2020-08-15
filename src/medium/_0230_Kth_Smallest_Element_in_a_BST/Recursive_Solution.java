package medium._0230_Kth_Smallest_Element_in_a_BST;

import utils.tree_node.TreeNode;

/*  https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    Time complexity: O(N)
        To build a traversal.
    Space complexity: O(H)
        Where H is the height of the Binary Search Tree
        The recursive stack can go up to H in the inorder traversal.
 */
public class Recursive_Solution {
    int count = 0;
    int value = 0;
    boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return value;
    }

    public void inOrderTraversal(TreeNode root, int k) {
        if (found) {
            return;
        }

        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, k);

        count++;
        if (count == k) {
            value = root.val;
            found = true;
            return;
        }

        inOrderTraversal(root.right, k);
    }
}
