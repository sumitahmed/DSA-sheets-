/**
 * LeetCode 21. Merge Two Sorted Lists
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * 
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * 
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class merge2SortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // If either list is initially null, return the other list
        if(list1==null) return list2;
        if(list2==null) return list1;

        // Ensure list1 always points to the list with the smaller initial value.
        // This makes list1 the main list we append to, and we'll eventually return its head.
        if(list1.val >list2.val){
            ListNode temp= list1;
            list1= list2;
            list2=temp;
        }

        // Store the head of the merged list to return later
        ListNode res = list1;
        
        while(list1!=null && list2!=null){
            ListNode temp=null;
            
            // Advance list1 until its value is greater than list2's current value.
            // temp keeps track of the last node in list1 that was <= list2.val
            while(list1!=null && list1.val<=list2.val){
                temp=list1;
                list1=list1.next;
            }
            
            // Link the last valid node from list1 to the current node of list2
            // this to make it point to last node eg list2
            temp.next =list2;

            // Swap list1 and list2 so list1 again points to the list with the smaller current value
            // swap list1, and list2 to complete traversal
            temp = list1;
            list1=list2;
            list2 = temp;
        }

        // Return the saved head of the merged list
        return res;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        merge2SortedLL solution = new merge2SortedLL();

        // Test Case 1: list1 = [1,2,4], list2 = [1,3,4]
        ListNode list1_1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2_1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("Test Case 1 Lists:");
        printList(list1_1);
        printList(list2_1);
        ListNode merged1 = solution.mergeTwoLists(list1_1, list2_1);
        System.out.println("Merged:");
        printList(merged1);
        System.out.println();

        // Test Case 2: list1 = [], list2 = []
        ListNode list1_2 = null;
        ListNode list2_2 = null;
        System.out.println("Test Case 2 Lists (empty):");
        ListNode merged2 = solution.mergeTwoLists(list1_2, list2_2);
        System.out.println("Merged:");
        printList(merged2);
        System.out.println();

        // Test Case 3: list1 = [], list2 = [0]
        ListNode list1_3 = null;
        ListNode list2_3 = new ListNode(0);
        System.out.println("Test Case 3 Lists:");
        printList(list1_3);
        printList(list2_3);
        ListNode merged3 = solution.mergeTwoLists(list1_3, list2_3);
        System.out.println("Merged:");
        printList(merged3);
    }
}