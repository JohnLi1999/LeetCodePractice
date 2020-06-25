package utils.tree_node;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Nested
    class Traverse {
        /*       4
               /   \
              2     6
             / \   / \
            1   3 5   7    */
        TreeNode third_left_left = new TreeNode(1);
        TreeNode third_left_right = new TreeNode(3);
        TreeNode third_right_left = new TreeNode(5);
        TreeNode third_right_right = new TreeNode(7);
        TreeNode second_left = new TreeNode(2, third_left_left, third_left_right);
        TreeNode second_right = new TreeNode(6, third_right_left, third_right_right);
        TreeNode root = new TreeNode(4, second_left, second_right);

        @Test
        void testPreOrder() {
            TreeNode.preOrderTraverse(root); // 4 2 1 3 6 5 7
        }

        @Test
        void testInOrder() {
            TreeNode.inOrderTraverse(root); // 1 2 3 4 5 6 7
        }

        @Test
        void testPostOrder() {
            TreeNode.postOrderTraverse(root); // 1 3 2 5 7 6 4
        }

        @Test
        void testLevelOrder() {
            TreeNode.levelOrderTraverse(root); // 4 2 6 1 3 5 7
        }
    }

    @Nested
    class CreateTree {

        @Test
        void testArrayToTree1() {
            Integer[] arr = {4, 2, 6, 1, 3, 5, 7};
            TreeNode root = TreeNode.arrayToTree(arr);
            TreeNode.preOrderTraverse(root); // 4 2 1 3 6 5 7
            TreeNode.inOrderTraverse(root); // 1 2 3 4 5 6 7
            TreeNode.postOrderTraverse(root); // 1 3 2 5 7 6 4
            TreeNode.levelOrderTraverse(root); // 4 2 6 1 3 5 7
        }

        @Test
        void testArrayToTree2() {
            Integer[] arr = {5, 1, 4, null, null, 3, 6};
            TreeNode root = TreeNode.arrayToTree(arr);
            TreeNode.preOrderTraverse(root); // 5 1 4 3 6
            TreeNode.inOrderTraverse(root); // 1 5 3 4 6
            TreeNode.postOrderTraverse(root); // 1 3 6 4 5
            TreeNode.levelOrderTraverse(root); // 5 1 4 3 6
        }

        @Test
        void testArrayToTree3() {
            Integer[] arr = {2, 1, 3};
            TreeNode root = TreeNode.arrayToTree(arr);
            TreeNode.preOrderTraverse(root); // 2 1 3
            TreeNode.inOrderTraverse(root); // 1 2 3
            TreeNode.postOrderTraverse(root); // 1 3 2
            TreeNode.levelOrderTraverse(root); // 2 1 3
        }
    }
}