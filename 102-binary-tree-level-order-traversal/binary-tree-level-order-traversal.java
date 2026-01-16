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
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>>  ans = new ArrayList<>();
       Queue<TreeNode> qu = new LinkedList<>();
       if(root==null)return ans;
       qu.add(root);
       while(!qu.isEmpty()){
        int size =qu.size();
        List<Integer> li =new ArrayList<>();
        for(int i=0;i<size;i++){
           TreeNode temp =qu.poll();
           if(temp.left !=null)qu.add(temp.left);
           if(temp.right !=null) qu.add(temp.right);
           li.add(temp.val);
        }
        ans.add(li);
       }
       return ans;
    }
    
}