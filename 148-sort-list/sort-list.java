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

    public ListNode merge(ListNode head,ListNode mid)
    {
        ListNode temp = new ListNode(0);
        ListNode ptr = temp;
        while(head!=null && mid!=null)
        {
            if(head.val<=mid.val)
            {
                ptr.next=head;
                head=head.next;
            }
            else
            {
                ptr.next=mid;
                mid=mid.next;
            }
            ptr=ptr.next;
        }
        if(head!=null) ptr.next=head;
        if(mid!=null) ptr.next=mid;
        return temp.next;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next=null;
        head = sortList(head);
        mid = sortList(mid);
        return merge(head,mid);
    }
}