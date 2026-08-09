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
        List<Integer>li=new ArrayList<>();
        rightside(root,li,0);
        return li;
    }
    void rightside(TreeNode node ,List<Integer> li, int depth){
        if(node==null)return;
        if(depth==li.size()){
            li.add(node.val);
        }
        rightside(node.right,li,depth+1);
        rightside(node.left,li,depth+1);

    }
}