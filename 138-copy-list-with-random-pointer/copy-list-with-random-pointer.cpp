/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/


class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(!head) return head;
        Node* prev = NULL;
        Node* curr=head;
        while(curr!=NULL)
        {
            Node* newNode = new Node(curr->val);
            prev=curr;
            curr=curr->next;
            prev->next=newNode;
            newNode->next=curr;
        }
        Node* temp=head;
        while(temp!=NULL)
        {
            Node* ran = NULL;
            if(temp->random) ran= temp->random->next;
            temp=temp->next;
            temp->random=ran;
            temp=temp->next;
        }
        prev=head;
        curr=head->next;
        Node* newHead=curr;
        while(prev!=NULL)
        {
            prev->next=prev->next->next;
            prev=prev->next;
            if(curr->next)
            {
                curr->next=curr->next->next;
                curr=curr->next;
            }
        }
        return newHead;
    }
};