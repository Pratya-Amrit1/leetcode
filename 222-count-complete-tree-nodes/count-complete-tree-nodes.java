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
        return count(root);
    }

    public int count(TreeNode n){
        if(n == null) return 0;
        return count(n.left) + count(n.right) + 1;
    }
}
// class Solution {
//     public int countNodes(TreeNode root) {
//         if(root ==null)return 0;
//         int left =gethleft(root);
//         int right =gethright(root);
//         if(left == right)return ((2<<(left))-1);
//         else return countNodes(root.left)+countNodes(root.right)+1;
//     }
//     public int gethleft(TreeNode root){
//         int count=0;
//         while(root.left !=null){
//             count++;
//             root=root.left;
//         }
//         return count;
//     }
//     public int gethright(TreeNode root){
//         int count=0;
//         while(root.right !=null){
//             count++;
//             root=root.right;
//         }
//         return count;
//     }
// }