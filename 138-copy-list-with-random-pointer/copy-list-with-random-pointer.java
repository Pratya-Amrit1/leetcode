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

    public Node copynodelist(Node head){
        Node temp =head;
        while(temp !=null){
            Node copynode =new Node(temp.val);
            copynode.next=temp.next;
            temp.next=copynode;
            temp=temp.next.next;
        }
        return head;
    }
    public static Node connran(Node head){
        Node temp=head;
        while(temp !=null){
                Node copynode = temp.next;
            if(temp.random !=null){
                copynode.random =temp.random.next;
            }else{
                copynode.random =null;
            }
                temp=temp.next.next;

        }
        return head;
    }
    public static Node connext(Node head){
        Node temp =head;
        Node dummyn = new Node(-1);
        Node res =dummyn;
        while(temp !=null){
            res.next =temp.next;
            temp.next =temp.next.next;
            res =res.next;
            temp=temp.next;
        }
        return dummyn.next;
    }
    public Node copyRandomList(Node head) {
        copynodelist(head);
        connran(head);
        return connext(head);
        

    //   Node temp=head;
    //   HashMap<Node,Node>mpp= new HashMap<>();
    //   while(temp !=null){
    //     Node newnode = new Node(temp.val);
    //     mpp.put(temp,newnode);
    //     temp=temp.next;
    //   }
    //   temp=head;
    //   while(temp !=null){
    //      Node copynode= mpp.get(temp);
    //     copynode.next = mpp.get(temp.next);
    //     copynode.random =mpp.get(temp.random);
    //     temp=temp.next;
    //   }
    //   return mpp.get(head);
    }
}