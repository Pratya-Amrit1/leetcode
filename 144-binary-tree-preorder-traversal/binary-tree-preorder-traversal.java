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
    void preorder(TreeNode root, List<Integer> li){
        if(root==null)return;
        li.add(root.val);
        preorder(root.left,li);
        preorder(root.right,li);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> li = new ArrayList<>();
        // preorder(root,li);
        // return li;
        List<Integer> li = new ArrayList<>();
        if(root==null)return li;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            root=s.pop();
            li.add(root.val);
            if(root.right !=null){
                s.push(root.right);
            }
            if(root.left!=null){
                s.push(root.left);
            }
        }
        return li;
    }
}