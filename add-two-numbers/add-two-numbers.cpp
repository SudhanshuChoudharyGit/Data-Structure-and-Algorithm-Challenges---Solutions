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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* sumlist;
        ListNode* temp= new ListNode(0);
        sumlist=temp;
        int carry= 0;
        ListNode* temp1=l1;
        ListNode* temp2=l2;
        while(temp1!=NULL || temp2!=NULL)
        {
            int sum=0;
            if(temp1)
            {
                sum+=temp1->val;
                temp1=temp1->next;
            }
            if(temp2)
            {
                sum+=temp2->val;
                temp2=temp2->next;
            }
            sum+=carry;
            ListNode* curr= new ListNode(sum%10);
            temp->next=curr;
            temp=temp->next;
            carry=sum/10;
        }
        if(carry!=0)
        {
            ListNode* curr= new ListNode(carry);
            temp->next=curr;
        }
        return (sumlist->next);
    }
};