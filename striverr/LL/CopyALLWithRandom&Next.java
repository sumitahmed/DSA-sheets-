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
        Node temp = head;
        Map<Node, Node> mpp = new HashMap<>();

        //step 1: creation of dummy node
        while(temp!=null){
            Node newNode = new Node(temp.val);
            mpp.put(temp, newNode);
            temp=temp.next;
        }

        //step 2: making sure next and rndm ptrs are pointing to the correct nodes
        temp = head;
        while(temp!=null){
            Node copyNode = mpp.get(temp);
            copyNode.next = mpp.get(temp.next);
            copyNode.random = mpp.get(temp.random);
            temp = temp.next;
        }
        return mpp.get(head);
    }
}