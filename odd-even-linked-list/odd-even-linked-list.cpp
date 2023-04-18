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
    ListNode* oddEvenList(ListNode* head) {
        if(head==NULL || head->next==NULL || head->next->next==NULL) return head;
        ListNode* eTemp=head;
        ListNode* oTemp=head->next;
        ListNode* oStart=oTemp;
        while(eTemp->next!=NULL && eTemp->next->next!=NULL)
        {
            eTemp->next=eTemp->next->next;
            eTemp=eTemp->next;
            if(oTemp->next->next!=NULL)
            {
                oTemp->next=oTemp->next->next;
                oTemp=oTemp->next;
            }
            else oTemp->next=NULL;
        }
        eTemp->next=oStart;
        return head;
        
    }
};