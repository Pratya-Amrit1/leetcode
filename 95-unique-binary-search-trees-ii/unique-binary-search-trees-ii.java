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
    public List<TreeNode> generateTrees(int n) {
        var res = new ArrayDeque<TreeNode>();
        res.add(new TreeNode(1));
        for (int i = 2; i < n + 1; ++i) {
            int size = res.size();
            var node = new TreeNode(i);
            for (int j = 0; j < size; ++j) {
                var root = res.poll();
                node.left = root;
                res.add(clone(node));
                var cur = root;
                while (cur != null) {
                    node.left = cur.right;
                    cur.right = node;
                    res.add(clone(root));
                    cur = cur.right = node.left; //backtrack & got to next
                }
            }
        }
        var r = new ArrayList<TreeNode>();
        int size = res.size();
        for (int i = 0; i < size; ++i) r.add(res.poll());
        return r;
    }
    private TreeNode clone(TreeNode root) {
        if (root == null) return null;
        var res = new TreeNode(root.val);
        res.left = clone(root.left);
        res.right = clone(root.right);
        return res;
    }
}