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
        int maxval[]= new int [1];
        maxval[0]=Integer.MIN_VALUE;
        maxpath(root ,maxval);
        return maxval[0];
    }
    public int maxpath(TreeNode node , int maxval[]){
        if(node ==null)return 0;
        int left = Math.max(0, maxpath(node.left , maxval));
        int right = Math.max(0 , maxpath(node.right ,maxval));
        maxval[0]= Math.max(maxval[0] ,left + right + node.val);

        return Math.max(left ,right)+node.val;
    }
}