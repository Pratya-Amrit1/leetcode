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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root.left == null && root.right==null) return true;
//         if(root.left == null  || root.right == null) return false;
//         if(root.left.val < root.val &&  root.val < root.right.val){
//             return true;
//         }
        
//         return false;
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
       return valid(root ,Long.MIN_VALUE ,Long.MAX_VALUE);
    }
    public boolean valid(TreeNode root ,Long left ,Long right){
        if(root ==null)return true;
        if(root.val>= right || root.val<=left)return false;
        return valid(root.left ,left ,(long)root.val) && valid(root.right ,(long)root.val , right);
    }
}