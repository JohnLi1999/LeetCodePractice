package utils.tree_node;

import java.util.Deque;
import java.util.LinkedList;

/** * Definition for a binary tree node. */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Helper methods
    public static TreeNode arrayToTree(Integer[] arr) {
        return formTree(arr, 0);
    }

    private static TreeNode formTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[index]);
        root.left = formTree(arr, 2 * index + 1);
        root.right = formTree(arr, 2 * index + 2);

        return root;
    }

    public static void preOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public static void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        System.out.print(root.val + " ");
        inOrderTraverse(root.right);
    }

    public static void postOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.val + " ");
    }

    public static void levelOrderTraverse(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode removed = queue.poll();
            if (removed.left != null) {
                queue.add(removed.left);
            }
            if (removed.right != null) {
                queue.add(removed.right);
            }
            System.out.print(removed.val + " ");
        }
    }
}
