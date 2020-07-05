package easy._0104_Maximum_Depth_of_Binary_Tree;

import org.junit.jupiter.api.Test;
import utils.tree_node.TreeNode;

import static easy._0104_Maximum_Depth_of_Binary_Tree.Solution.maxDepth_Recursive;
import static easy._0104_Maximum_Depth_of_Binary_Tree.Solution.maxDepth_Iterative;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        TreeNode root = TreeNode.arrayToTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        assertEquals(3, maxDepth_Recursive(root));
    }

    @Test
    void test2() {
        TreeNode root = TreeNode.arrayToTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        assertEquals(3, maxDepth_Iterative(root));
    }
}