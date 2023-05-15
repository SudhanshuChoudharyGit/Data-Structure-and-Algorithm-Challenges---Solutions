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

struct MyCompare{
    bool operator() (const ListNode* a,const ListNode* b)
        {
            return (a->val>b->val);
        }
};


class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {


        
        //priority queue (without need of using pair)
        ListNode* ans=new ListNode(0);
        ListNode* temp=ans;

        priority_queue<ListNode*,vector<ListNode*>,MyCompare> pq;
        for(int i=0;i<lists.size();i++)
        {
            if(lists[i]) pq.push(lists[i]);
        }
        while(!pq.empty())
        {
            ListNode* node =pq.top();
            pq.pop();
            temp->next=node;
            temp=temp->next;
            node=node->next;
            if(node) pq.push(node);
        }
        return ans->next;
    }
};