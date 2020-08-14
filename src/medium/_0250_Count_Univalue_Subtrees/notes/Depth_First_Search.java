package medium._0250_Count_Univalue_Subtrees.notes;

import utils.tree_node.TreeNode;

/*  Time complexity: O(n)
        Due to the algorithm's depth-first nature,
        the is_uni status of each node is computed from bottom up.
        When given the is_uni status of its children, computing the is_uni status of a node occurs in O(1)
        This gives us O(1) time for each node in the tree with O(N) total nodes for a time complexity of O(N)
    Space complexity: O(H)
        With H being the height of the tree.
        Each recursive call of is_uni requires stack space.
        Since we fully process is_uni(node.left) before calling is_uni(node.right),
        the recursive stack is bound by the longest path from
        the root to a leaf - in other words the height of the tree.
 */
public class Depth_First_Search {
    int count = 0;

    boolean is_uni(TreeNode node) {

        //base case - if the node has no children this is a univalue subtree
        if (node.left == null && node.right == null) {

            // found a univalue subtree - increment
            count++;
            return true;
        }

        boolean is_unival = true;

        // check if all of the node's children are univalue subtrees and if they have the same value
        // also recursively call is_uni for children
        if (node.left != null) {
            is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
        }

        if (node.right != null) {
            is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
        }

        // return if a univalue tree exists here and increment if it does
        if (!is_unival) return false;
        count++;
        return true;
    }

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        is_uni(root);
        return count;
    }
}