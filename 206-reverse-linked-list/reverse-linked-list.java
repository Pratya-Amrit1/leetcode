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
        //recursive approach
        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        ListNode front =head.next;
        front.next=head;
        head.next=null;
        return newHead;
    //      if(head == null){
    //     return null;
    //   } 
    //   else{
    //     ListNode prev= null;
    //     ListNode curr = head;

    //     while(curr != null){
    //         ListNode nextTemp =curr.next;
    //         curr.next= prev;
    //         prev=curr;
    //         curr= nextTemp;

    //     }
    //     head=prev;
    //     return head;

    //   }
    }
}