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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightview(root  , res ,0);
        return res;
    }
    public void rightview(TreeNode root , List<Integer> res , int currdepth){
        if(root ==null){
            return ;
        }
        if(currdepth == res.size()) res.add(root.val);
        rightview(root.right, res ,currdepth+1);
        rightview(root.left , res , currdepth+1);
    }
}