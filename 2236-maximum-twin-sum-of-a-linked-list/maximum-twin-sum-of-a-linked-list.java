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

    public ListNode reverseLinkedList(ListNode node){
        ListNode prev= null;
        ListNode curr = node;
        ListNode nxt = node.next;
        while(nxt!=null)
        {
            curr.next = prev;
            prev= curr;
            curr=nxt;
            nxt= nxt.next;
        }
        curr.next = prev;
        return curr;
    }

    //reverse LL solution
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revList = reverseLinkedList(slow.next);
        int maxSum = 0;
        ListNode temp1 = head;
        ListNode temp2 = revList;
        while(temp1!=null && temp2!=null)
        {
            maxSum = Math.max(maxSum,temp1.val+temp2.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return maxSum;
    }



    //stack solution
    /*
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
    */

}