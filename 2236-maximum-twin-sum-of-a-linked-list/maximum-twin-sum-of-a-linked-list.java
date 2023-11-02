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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Integer> twinVal = new Stack<>();
        slow = slow.next;
        while(slow!=null)
        {
            twinVal.push(slow.val);
            slow = slow.next;
        }
        int maxSum = 0;
        ListNode temp = head;
        while(!twinVal.isEmpty())
        {
            int twin = twinVal.peek();
            maxSum = Math.max(maxSum,temp.val+twin);
            twinVal.pop();
            temp = temp.next;
        }
        return maxSum;
    }

}