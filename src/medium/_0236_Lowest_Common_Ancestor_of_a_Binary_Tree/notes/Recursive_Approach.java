package medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree.notes;

import utils.tree_node.TreeNode;

/*  Time Complexity: O(N)
        where N is the number of nodes in the binary tree.
        In the worst case we might be visiting all the nodes of the binary tree.
    Space Complexity: O(N)
        This is because the maximum amount of space utilized by the recursion stack
        would be N since the height of a skewed binary tree could be N.
 */
public class Recursive_Approach {
    private TreeNode ans;

    public Recursive_Approach() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}