/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void mark(TreeNode root ,Map<TreeNode , TreeNode>parent , TreeNode target ){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr =q.poll();
            if(curr.left !=null){
                parent.put(curr.left ,curr);
                q.offer(curr.left);
            }
            if(curr.right !=null){
                parent.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode ,TreeNode> map =new HashMap<>();
        mark(root,map ,root);
        Map<TreeNode ,Boolean> visited =new HashMap<>();
        Queue<TreeNode> q =new LinkedList<>();
        q.offer(target);
        visited.put(target ,true);
        int clevel=0;
        while(! q.isEmpty()){
            int size =q.size();
            if(clevel == k) break;
            clevel++;
            for(int i=0 ;i<size;i++){
                TreeNode curr= q.poll();
                if(curr.left !=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                 if(curr.right !=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(map.get(curr)!=null && visited.get(map.get(curr))==null){
                    q.offer(map.get(curr));
                    visited.put(map.get(curr),true);

                }

     }
        }
        List<Integer> result = new ArrayList<>();
        while(! q.isEmpty()){
            TreeNode curr = q.poll();
            result.add(curr.val);
        }
        return result;

    }
}