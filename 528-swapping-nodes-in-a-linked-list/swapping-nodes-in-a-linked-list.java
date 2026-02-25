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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null)return null;
        ListNode temp1 =head;
        ListNode temp2= head;
        int post=k-1;
        int cnt=1;
        while(temp1.next!=null){
            temp1=temp1.next;
            cnt++;
        }
        temp1=head;
        while(post>0){
            temp1=temp1.next;
            post--;
        }
        int back=cnt-k;
        while(back>0){
            temp2=temp2.next;
            back--;
        }
        int value =temp1.val;
        temp1.val=temp2.val;
        temp2.val=value;
        return head;
    }
}