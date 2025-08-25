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
    public ListNode mergesort(ListNode l1 , ListNode l2){
        ListNode newdum = new ListNode(-1) , tail = newdum;
        while(l1 !=null && l2 !=null){
            if(l1.val < l2.val){
                tail.next =l1;
                l1= l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return newdum.next;

    }
    public ListNode mergeKLists(ListNode[] lists) {
       ListNode res = null;
       for(ListNode list : lists){
        res = mergesort(res , list);
       }
       return res;
    }
}