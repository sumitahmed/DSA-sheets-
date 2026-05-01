class Solution {
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
}