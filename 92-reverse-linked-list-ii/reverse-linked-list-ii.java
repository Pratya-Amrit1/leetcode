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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode previousNode = null;
        ListNode currentNode = head;

        while (left > 1) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            left--;
            right--;
        }

        
        ListNode startNode = previousNode; 
        ListNode endNode = currentNode;    
        
       
        ListNode prev = null;
        while (right > 0) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
            right--;
        }
        if (startNode != null) {
            startNode.next = prev;
        } else {
            head = prev; 
        }
        endNode.next = currentNode;

        return head;
    }
}