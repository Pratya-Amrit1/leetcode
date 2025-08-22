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
 //important
class Solution {
    public ListNode reverseList(ListNode head) {
      //recursively or iteratively
         if(head == null){
        return null;
      } 
      else{
        ListNode prev= null;
        ListNode curr = head;

        while(curr != null){
            ListNode nextTemp =curr.next;
            curr.next= prev;
            prev=curr;
            curr= nextTemp;

        }
        return prev;

      }
    }
}