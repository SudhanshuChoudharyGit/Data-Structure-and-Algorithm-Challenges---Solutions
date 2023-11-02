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
        Stack<Integer> twinVal = new Stack<>();
        while(fast!=null)
        {
            twinVal.push(slow.val);
            slow = slow.next;
            if(fast.next!=null) fast = fast.next.next;
            else fast = fast.next;
        }
        int maxSum = 0;
        while(slow!=null)
        {
            int twin = twinVal.peek();
            maxSum = Math.max(maxSum,slow.val+twin);
            twinVal.pop();
            slow = slow.next;
        }
        return maxSum;
    }

}