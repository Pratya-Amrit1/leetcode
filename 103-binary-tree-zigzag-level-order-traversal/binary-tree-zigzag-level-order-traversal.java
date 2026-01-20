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
import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // List<List<Integer>> res = new ArrayList<>();
        // if(root == null)return res;

        // Queue<TreeNode> node = new LinkedList<>();
        // node.offer(root);
        // boolean ltor=true;
        // while(!node.isEmpty()){
        //     int size = node.size();
        //     List<Integer> row = new ArrayList<>(Collections.nCopies(size ,0));
        //     for(int i =0 ;i<size;i++){
        //         TreeNode nice = node.poll();
        //         int index = ltor ?i : size -1 -i;
        //         row.set(index ,nice.val);
        //         if(nice.left !=null){
        //             node.offer(nice.left);
        //         }
        //         if(nice.right !=null){
        //             node.offer(nice.right);
        //         }
        //     }
        //     res.add(row);
        //     ltor = !ltor;
        // }
        // return res;




        // deque use karna se  positon switch karna ki need hi nhi hai
         List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(new ArrayList<>(level));
            leftToRight = !leftToRight;
        }

        return result;
    }
}