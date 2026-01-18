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
    public ListNode reverseKGroup(ListNode head, int k) {
    
        ListNode temp=head;
        ListNode nextnode=new ListNode(0);
        ListNode prevnode=new ListNode(0);
        while(temp !=null){
            ListNode knode=findk(temp,k);
            if(knode ==null){
                prevnode.next=temp;
                break;
            }
            nextnode =knode.next;
            knode.next=null;
            reversell(temp);
            if(temp==head){
                head=knode;
            }
            else{
                prevnode.next=knode;
            }
            prevnode =temp;
            temp=nextnode;
        }
        return head;
    }
    public ListNode reversell(ListNode head){
        ListNode prev =null;
       ListNode curr =head;
       while(curr !=null){
        ListNode temp =curr.next;
        curr.next =prev;
        prev=curr;
        curr=temp;
       }
       return prev;
    }
    public ListNode findk(ListNode head ,int k){
        k -=1;
        ListNode temp=head;
        while(k !=0){
            if(temp==null)return null;
            temp=temp.next;
            k--;
        }
        return temp;
    }
}