/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class NodeValue {
    int min, max, sum;
    boolean isBST;

    NodeValue(int min, int max, int sum, boolean isBST) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.isBST = isBST;
    }
};
class Solution {

    int maxSum = 0;

    private NodeValue helper(TreeNode root) {

        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        if (left.isBST && right.isBST &&
            left.max < root.val && root.val < right.min) {

            int currSum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, currSum);

            return new NodeValue(
                Math.min(root.val, left.min),
                Math.max(root.val, right.max),
                currSum,
                true
            );
        }

        return new NodeValue(0, 0, 0, false);
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
}
