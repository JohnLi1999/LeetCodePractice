package medium._0102_Binary_Tree_Level_Order_Traversal;

import utils.tree_node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*  https://leetcode.com/problems/binary-tree-level-order-traversal/
        Time complexity: O(N)
            Since each node is processed exactly once.
        Space complexity: O(N)
            To keep the output structure which contains N node values.
     */
    public static List<List<Integer>> levelOrder_Recursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Traverse the tree in pre-order
        DFS(root, 0, result);

        return result;
    }

    private static void DFS(TreeNode root, int level, List<List<Integer>> result) {
        // Return when reach the end of a branch
        if (root == null) {
            return;
        }

        // If the result does not have a list for the level, create a new list for it
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }

        // Add the node value to the correct level
        result.get(level).add(root.val);

        // Traverse the left and right subtrees
        DFS(root.left, level + 1, result);
        DFS(root.right, level + 1, result);
    }

    /*  Time complexity: O(N)
            Since each node is processed exactly once.
        Space complexity: O(N)
            To keep the output structure which contains N node values.
     */
    public static List<List<Integer>> levelOrder_Iterative(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // Add root element into the queue
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Current size of the queue is the length of the current level
            int level_length = queue.size();
            // Initialize a list for the level
            List<Integer> list = new ArrayList<>();

            // Loop all the elements in the CURRENT level
            for (int i = 0; i < level_length; i++) {
                // Poll out elements in the current level from queue and add them into the list
                TreeNode node = queue.poll();
                list.add(node.val);

                // Add elements (if exists) in the NEXT level into the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Add the list of the current level into result
            result.add(list);
        }

        return result;
    }
}
