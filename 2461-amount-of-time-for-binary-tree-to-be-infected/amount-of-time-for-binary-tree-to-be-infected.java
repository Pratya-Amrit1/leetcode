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
    public TreeNode markParentsAndFindInfected(TreeNode root, int start, Map<TreeNode, TreeNode> parent_track) {
        TreeNode infected = new TreeNode();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.val == start) {
                infected = node;
            }

            if (node.left != null) {
                q.offer(node.left);
                parent_track.put(node.left, node);
            }

            if (node.right != null) {
                q.offer(node.right);
                parent_track.put(node.right, node);
            }
        }
        return infected;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        TreeNode infected = markParentsAndFindInfected(root, start, parent_track);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(infected);

        Map<TreeNode, Boolean> vis = new HashMap<>();
        vis.put(infected, true);

        int min = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                if (node.left != null && vis.get(node.left) == null) {
                    q.offer(node.left);
                    vis.put(node.left, true);
                }

                if (node.right != null && vis.get(node.right) == null) {
                    q.offer(node.right);
                    vis.put(node.right, true);
                }

                if (parent_track.get(node) != null && vis.get(parent_track.get(node)) == null) {
                    q.offer(parent_track.get(node));
                    vis.put(parent_track.get(node), true);
                }
            }

            min++;
        }

        return min - 1;
    }
}