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
    public int maxPathSum(TreeNode root) {
        int[] maxval = new int[1];
        maxval[0]=Integer.MIN_VALUE;
        maxpath(root,maxval);
        return maxval[0];
    }
    int maxpath(TreeNode root , int[] maxval){
        if(root==null)return 0;
        int lh=Math.max(0,maxpath(root.left,maxval));
        int rh=Math.max(0,maxpath(root.right,maxval));
        maxval[0]=Math.max(maxval[0],lh+rh+root.val);
        return root.val+Math.max(lh,rh);
    }
}