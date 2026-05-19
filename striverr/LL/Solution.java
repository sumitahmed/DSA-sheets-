package LL;

public /**
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
        if (head == null || head.next == null || k == 0) return head;
        ListNode tail = head;
        int len=1;

        while(tail.next!=null){
            len++;
            tail=tail.next;
        }

        if(k%len ==0) return head; //same

        k=k%len;
        tail.next=head;

        ////step-2/////
        // Traverse to new tail position
        int stepsToNewTail = len - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // New head is next of newTail
        head = newTail.next;
        newTail.next=null;

        return head;
    }
} {
    
}
