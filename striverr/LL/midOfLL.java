/**
 * LeetCode 876. Middle of the Linked List
 * 
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * 
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class midOfLL {
    public ListNode middleNode(ListNode head) {

        //normal

        // ListNode temp = head;
        // int c =0;
        // while(temp!=null){
        //     c++;
        //     temp=temp.next;
        // }
        // temp = head;
        // int mid = (c/2)+1;
        // while(temp!=null){
        //     mid=mid-1;
        //     if(mid==0){
        //         break;
        //     }

        //     temp=temp.next;
        // }
        // return temp;

        //tortoise and head approach

        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        midOfLL solution = new midOfLL();

        // Test Case 1: [1,2,3,4,5]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Test Case 1 Original List:");
        printList(head1);
        ListNode mid1 = solution.middleNode(head1);
        System.out.println("Middle Node Value: " + (mid1 != null ? mid1.val : "null"));

        System.out.println();

        // Test Case 2: [1,2,3,4,5,6]
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println("Test Case 2 Original List:");
        printList(head2);
        ListNode mid2 = solution.middleNode(head2);
        System.out.println("Middle Node Value: " + (mid2 != null ? mid2.val : "null"));
    }
}