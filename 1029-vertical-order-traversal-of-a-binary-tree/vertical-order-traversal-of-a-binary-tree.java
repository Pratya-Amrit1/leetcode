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

    static class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

      
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(node.val);

            if (node.left != null) {
                q.add(new Pair(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();

            for (List<Integer> values : rows.values()) {
                Collections.sort(values); 
                colList.addAll(values);
            }

            result.add(colList);
        }

        return result;
    }
}
