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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        int cnt=0;
     while(!q.isEmpty()){
        List<Integer> li= new ArrayList<>();
        int size=q.size();
        for(int i=0;i<size;i++){
        TreeNode node= q.poll();
        if(node.left !=null)q.offer(node.left);
        if(node.right!=null)q.offer(node.right);
        li.add(node.val);
        }
        cnt+= opsonsort(li);
     }
     return cnt;
    }
    public int opsonsort(List<Integer> arr){
        int n = arr.size();
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pairs.add(new int[]{arr.get(i), i});
        }
        pairs.sort((a, b) -> a[0] - b[0]);

        boolean[] visited = new boolean[n];

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || pairs.get(i)[1] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = pairs.get(j)[1];

                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}