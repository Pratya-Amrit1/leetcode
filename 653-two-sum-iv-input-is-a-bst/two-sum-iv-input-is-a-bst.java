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
 public class BSTiterator {
    private Stack<TreeNode> stack = new Stack<>();
    boolean reverse =true;
    public  BSTiterator(TreeNode root , boolean isReverse){
        reverse = isReverse;
        pushall(root);
    }
    public boolean hasnext(){
        return !stack.isEmpty();
    }
    public int next() {
        TreeNode tmp = stack.pop();
        if(reverse==false){
        pushall(tmp.right);}
        else pushall(tmp.left);
        return tmp.val;
    }
    public void pushall(TreeNode node){
        while(node !=null){
            stack.push(node);
            if(reverse ==true){
                node=node.right;
            }
            else{
                node=node.left;
            }
        }
    }}
    class Solution{
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return false;
        BSTiterator l = new BSTiterator(root,false);
        BSTiterator r = new BSTiterator(root ,true);
        int i= l.next();
        int j= r.next();
        while(i<j){
            if(i+j==k)return true;
            else if(i+j<k)i=l.next();
            else j =r.next();
        }   
        return false;
         }
    }
