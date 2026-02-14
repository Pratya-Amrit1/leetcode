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
class Solution {

    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // If previous node exists and BST property is violated
        if (prev != null && root.val < prev.val) {

            // First violation
            if (first == null) {
                first = prev;
                middle = root;
            }
            // Second violation
            else {
                last = root;
            }
        }

        // Update previous node
        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {

        first = middle = last = null;
        prev = null;

        inorder(root);

        // Case 1: Non-adjacent nodes swapped
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // Case 2: Adjacent nodes swapped
        else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}
