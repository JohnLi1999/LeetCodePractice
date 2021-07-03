package easy._0111_Minimum_Depth_of_Binary_Tree.round_2;

import utils.tree_node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.arrayToTree(new Integer[] {3,9,20,null,null,15,7});
        System.out.println(s.minDepth(root));
        System.out.println(s.minDepth_LevelTraversal(root));
    }

    /*  Be careful of the case that only of the left subtree or the right subtree is empty
        Time complexity: O(n)
        Space complexity: O(n) for the worst, O(log(n)) if the tree is balanced
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /*  The iterative solution. Use level traversal and return the first met leaf node
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int minDepth_LevelTraversal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            depth++;

            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }
}
