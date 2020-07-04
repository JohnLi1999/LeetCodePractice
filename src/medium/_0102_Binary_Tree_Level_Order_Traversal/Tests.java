package medium._0102_Binary_Tree_Level_Order_Traversal;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.tree_node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static medium._0102_Binary_Tree_Level_Order_Traversal.Solution.levelOrder_Recursive;
import static medium._0102_Binary_Tree_Level_Order_Traversal.Solution.levelOrder_Iterative;


class Tests {

    @Nested
    class Recursive {

        @Test
        void test1() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {3, 9, 20, null, null, 15, 7});
            List<List<Integer>> result = levelOrder_Recursive(root);
            result.forEach(list -> {
                System.out.print("[ ");
                list.forEach(val -> System.out.print(val + " "));
                System.out.println("]");
            });
        }

        @Test
        void test2() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {
                    7, 9, 3, 10, 11, 2 ,5, 8, 6, null, 4, 15, null, 21, 30
            });
            List<List<Integer>> result = levelOrder_Recursive(root);
            result.forEach(list -> {
                System.out.print("[ ");
                list.forEach(val -> System.out.print(val + " "));
                System.out.println("]");
            });
        }
    }

    @Nested
    class Iterative {

        @Test
        void test1() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {3, 9, 20, null, null, 15, 7});
            List<List<Integer>> result = levelOrder_Iterative(root);
            result.forEach(list -> {
                System.out.print("[ ");
                list.forEach(val -> System.out.print(val + " "));
                System.out.println("]");
            });
        }

        @Test
        void test2() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {
                    7, 9, 3, 10, 11, 2 ,5, 8, 6, null, 4, 15, null, 21, 30
            });
            List<List<Integer>> result = levelOrder_Iterative(root);
            result.forEach(list -> {
                System.out.print("[ ");
                list.forEach(val -> System.out.print(val + " "));
                System.out.println("]");
            });
        }
    }
}