/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode temp =head;
        Stack<ListNode> s =new Stack<>();
        while( temp !=null){
            s.push(temp);
            temp = temp.next;
        }
        temp=head;
        int maxsum =0;
        while(! s.isEmpty()){
            int sum =temp.val + s.pop().val;
            temp= temp.next;
            maxsum =Math.max(maxsum,sum);
        } 
        return maxsum;
    }
}