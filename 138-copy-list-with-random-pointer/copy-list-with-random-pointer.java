/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
      Node temp=head;
      HashMap<Node,Node>mpp= new HashMap<>();
      while(temp !=null){
        Node newnode = new Node(temp.val);
        mpp.put(temp,newnode);
        temp=temp.next;
      }
      temp=head;
      while(temp !=null){
         Node copynode= mpp.get(temp);
        copynode.next = mpp.get(temp.next);
        copynode.random =mpp.get(temp.random);
        temp=temp.next;
      }
      return mpp.get(head);
    }
}