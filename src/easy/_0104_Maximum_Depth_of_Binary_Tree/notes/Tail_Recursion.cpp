/*  Time complexity: O(N)
        Still we visit each node once and only once.
    Space complexity: O(2^{log_2_(N-1)}) = O(N/2) = O(N)
        i.e. the maximum number of nodes at the same level (
        the number of leaf nodes in a full binary tree),
        since we traverse the tree in the BFS manner.
 */
class Solution {

  private:
    // The queue that contains the next nodes to visit,
    //   along with the level/depth that each node is located.
    queue<pair<TreeNode*, int>> next_items;
    int max_depth = 0;

    /**
     * A tail recursion function to calculate the max depth
     *   of the binary tree.
     */
    int next_maxDepth() {

      if (next_items.size() == 0) {
        return max_depth;
      }

      auto next_item = next_items.front();
      next_items.pop();

      auto next_node = next_item.first;
      auto next_level = next_item.second + 1;

      max_depth = max(max_depth, next_level);

      // Add the nodes to visit in the following recursive calls.
      if (next_node->left != NULL) {
        next_items.push(make_pair(next_node->left, next_level));
      }
      if (next_node->right != NULL) {
        next_items.push(make_pair(next_node->right, next_level));
      }

      // The last action should be the ONLY recursive call
      //   in the tail-recursion function.
      return next_maxDepth();
    }

  public:
    int maxDepth(TreeNode* root) {
      if (root == NULL) return 0;

      // clear the previous queue.
      std::queue<pair<TreeNode*, int>> empty;
      std::swap(next_items, empty);
      max_depth = 0;

      // push the root node into the queue to kick off the next visit.
      next_items.push(make_pair(root, 0));

      return next_maxDepth();
    }
};