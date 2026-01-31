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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length !=postorder.length)return null;
        Map<Integer ,Integer> mpp =new HashMap<>();
        for(int i=0;i<inorder.length ;i++){
            mpp.put(inorder[i],i);
        }
        return builttree(inorder ,0 ,inorder.length-1 , postorder , 0 , postorder.length-1 ,mpp);
    }
    public TreeNode builttree(int[] inorder , int is , int ie , int[] postorder , int ps ,int pe ,Map<Integer ,Integer> mpp){
        if(ps>pe || is >ie )return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inroot = mpp.get(root.val);
        int numsleft = inroot -is;
        root.left = builttree(inorder ,is ,inroot-1, postorder ,ps , ps+numsleft-1,mpp);
        root.right = builttree(inorder, inroot+1, ie, postorder, ps+numsleft, pe-1, mpp);
        return root;
    }
}