/**
 * LeetCode 206. Reverse Linked List
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * Example 3:
 * Input: head = []
 * Output: []
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class reverseLL {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode front = null;

        while(temp!=null){
            front = temp.next;
            temp.next= prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        reverseLL solution = new reverseLL();

        // Test Case 1: [1,2,3,4,5]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Test Case 1 Original List:");
        printList(head1);
        ListNode reversed1 = solution.reverseList(head1);
        System.out.println("Reversed List:");
        printList(reversed1);

        System.out.println();

        // Test Case 2: [1,2]
        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println("Test Case 2 Original List:");
        printList(head2);
        ListNode reversed2 = solution.reverseList(head2);
        System.out.println("Reversed List:");
        printList(reversed2);

        System.out.println();

        // Test Case 3: []
        ListNode head3 = null;
        System.out.println("Test Case 3 Original List:");
        printList(head3);
        ListNode reversed3 = solution.reverseList(head3);
        System.out.println("Reversed List:");
        printList(reversed3);
    }
}