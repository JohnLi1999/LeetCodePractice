package medium._0250_Count_Univalue_Subtrees;

import utils.tree_node.TreeNode;

/*  https://leetcode.com/problems/count-univalue-subtrees/
    Time complexity: O(N)
        We need O(1) time for each node in the tree with O(N) total nodes
        So the complexity is O(N)
    Space complexity: O(H)
        With H being the height of the tree.
 */
public class Solution_PostOrderTraversal {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        postOrderTraverse(root);
        return count;
    }

    public boolean postOrderTraverse(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftResult = postOrderTraverse(root.left);
        boolean rightResult = postOrderTraverse(root.right);

        if (leftResult && rightResult) {
            if (	(root.left == null && root.right == null) ||
                    (root.left == null && root.right != null && root.val == root.right.val) ||
                    (root.left != null && root.right == null && root.val == root.left.val) ||
                    (root.left != null && root.right != null && root.val == root.left.val && root.left.val == root.right.val) ) {
                count++;
                return true;
            }
        }

        return false;
    }
}
