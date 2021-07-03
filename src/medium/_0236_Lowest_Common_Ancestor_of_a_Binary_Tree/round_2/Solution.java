package medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree.round_2;

import utils.tree_node.TreeNode;

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNode.arrayToTree(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(5);
        TreeNode result = s.lowestCommonAncestor(root, p, q);

        System.out.println(result.val);
    }

    /*  Core idea:
            find the first node that node p and q are located in its different subtrees/
            Or one of them is the node itself
        Time complexity: O(N) in worst case
        Space complexity: O(N) in worst case
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftCommonAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonAncestor = lowestCommonAncestor(root.right, p, q);

        if (leftCommonAncestor == null && rightCommonAncestor == null) {
            return null;
        } else if (leftCommonAncestor != null && rightCommonAncestor != null) {
            return root;
        } else return Objects.requireNonNullElse(leftCommonAncestor, rightCommonAncestor);
    }
}
