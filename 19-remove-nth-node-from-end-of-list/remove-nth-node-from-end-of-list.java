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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyPointer = new ListNode(0);
        ListNode slow = dummyPointer;
        ListNode fast = dummyPointer;

        dummyPointer.next = head;
        fast = fast.next;

        while(n-->0) fast = fast.next;

        while(fast!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyPointer.next;
    }
}