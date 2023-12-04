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
        //dummy node
        ListNode dummyNode = new ListNode(0);
        ListNode slow = dummyNode;
        ListNode fast = head;

        dummyNode.next = head;

        while(n-- >0)
        {
            fast = fast.next;
        }

        while(fast!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyNode.next;














        /*
        ListNode head = new ListNode(0);
        ListNode nextPointer = new ListNode(1);
        ListNode anotherPointer = new ListNode(2);
        head.next = nextPointer;
        nextPointer.next = anotherPointer;

        //delete 
        head.next = anotherPointer;

        //traverse
        ListNode temp = head;
        int n = 2;
        while(n-- >0)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        
        //length
        ListNode temp2 = head;
        int length =0;
        while(temp2!=null)
        {
            temp2 = temp2.next;
            length++;
        }

        int newN = legnth-n-1;

        ListNode temp = head;
        int n = 2;
        while(n-- >0)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        */

        


    }
}