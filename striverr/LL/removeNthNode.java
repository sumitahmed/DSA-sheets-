/**
 * LeetCode 19. Remove Nth Node From End of List
 * 
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * 
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 */

// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

public class removeNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize both fast and slow pointers to head
        ListNode fast = head;
        ListNode slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) fast = fast.next;

        // If fast is null, n equals list length → remove head node
        if (fast == null) return head.next;

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow is now just before the target node → skip it
        slow.next = slow.next.next;

        // Return the unchanged head
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        removeNthNode solution = new removeNthNode();

        // Test Case 1: head = [1,2,3,4,5], n = 2
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Test Case 1 List:");
        printList(head1);
        ListNode result1 = solution.removeNthFromEnd(head1, 2);
        System.out.println("After removing 2nd from end:");
        printList(result1);
        System.out.println();

        // Test Case 2: head = [1], n = 1
        ListNode head2 = new ListNode(1);
        System.out.println("Test Case 2 List:");
        printList(head2);
        ListNode result2 = solution.removeNthFromEnd(head2, 1);
        System.out.println("After removing 1st from end:");
        printList(result2);
        System.out.println();

        // Test Case 3: head = [1,2], n = 1
        ListNode head3 = new ListNode(1, new ListNode(2));
        System.out.println("Test Case 3 List:");
        printList(head3);
        ListNode result3 = solution.removeNthFromEnd(head3, 1);
        System.out.println("After removing 1st from end:");
        printList(result3);
    }
}