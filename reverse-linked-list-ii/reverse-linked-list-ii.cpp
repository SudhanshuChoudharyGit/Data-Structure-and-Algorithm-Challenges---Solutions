/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:

    ListNode* reverseLL(ListNode* head)
    {
        ListNode* prev=NULL;
        ListNode* curr=head;
        ListNode* nxt=curr->next;
        while(nxt!=NULL)
        {
            curr->next=prev;
            prev=curr;
            curr=nxt;
            nxt=nxt->next;
        }
        curr->next=prev;
        return curr;
    }

    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if(head->next==NULL) return head;
        ListNode* temp=head;
        ListNode* front;
        ListNode* back;
        ListNode* start;
        ListNode* end;
        if(left==1)
        {
            front=NULL;
            start=temp;
        }
        else
        {
            int x = left-2;
            while(x--)
            {
                temp=temp->next;
            }
            front=temp;
            start=temp->next;
            temp=temp->next;
        }
        int y = right-left;
        while(y--)
        {
            temp=temp->next;
        }
        end=temp;
        back=temp->next;
        end->next=NULL;
        end=start;
        start=reverseLL(start);
        if(front) front->next=start;
        else head=start;
        if(back) end->next=back;
        return head;
    }
};