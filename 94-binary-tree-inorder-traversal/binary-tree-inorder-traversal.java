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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    while(root != null || !stack.isEmpty()) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        ans.add(root.val);
        root = root.right;
    }

    return ans;
    }
    public void inorder(TreeNode root ,List<Integer> l1){
        if(root !=null){
            inorder(root.left ,l1);
            l1.add(root.val);
            inorder(root.right ,l1);
        }
    }
}