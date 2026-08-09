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
 class Pair{
    TreeNode node;
    int ind;
    Pair(TreeNode node,int ind){
        this.node =node;
        this.ind=ind;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int mini=q.peek().ind;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                int curind= q.peek().ind-mini;
                TreeNode node =q.peek().node;
                q.poll();
                if(i==0)first=curind;
                if(i==size-1)last=curind;
                if(node.left!=null){
                    q.offer(new Pair(node.left,curind*2+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,curind*2+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}