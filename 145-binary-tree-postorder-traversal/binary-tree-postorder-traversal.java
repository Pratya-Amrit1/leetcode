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
    void postorder(TreeNode root,List<Integer> li){
        if(root==null)return;
        postorder(root.left,li);
        postorder(root.right,li);
        li.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        // List<Integer> li = new ArrayList<>();
        // postorder(root,li);
        // return li;

        List<Integer> li = new ArrayList<>();
        if(root==null)return li;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            root=s.pop();
            li.add(root.val);
            if(root.left!=null){
                s.push(root.left);
            }
            if(root.right !=null){
                s.push(root.right);
            }
        }
        Collections.reverse(li);
        return li;
    }
}