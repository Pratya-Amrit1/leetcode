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
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int left=getleft(root.left);
        int right=getright(root.right);

        if(left==right){
            return ((2<<(left))-1);
        }
        else{
        return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    int getleft(TreeNode root){
        int cnt=0;
        if(root==null)return cnt;
        while(root!=null){
            cnt++;
            root=root.left;
        }
        return cnt;
    }
    int getright(TreeNode root){
        int cnt=0;
        if(root==null)return cnt;
        while(root!=null){
            cnt++;
            root=root.right;
        }
        return cnt;
    }
}