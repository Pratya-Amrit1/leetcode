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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail=head;
        int len =1;
        if(head ==null || k==0)return head;
        while(tail.next !=null){
            tail=tail.next;
            len++;
        }
        if(k % len == 0) return head;
        k=k%len;
        tail.next =head;
        ListNode newlast =findlast(head,len-k);
        head =newlast.next;
        newlast.next=null;
        return head;
    }
    public ListNode findlast(ListNode head ,int k){
        int cnt =1;
        while(head !=null){
            if(cnt==k)return head;
            head=head.next;
            cnt++;
        }
        return head;
    }
}