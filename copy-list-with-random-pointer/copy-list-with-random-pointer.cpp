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
        Node* newhead = new Node(0);
        unordered_map<Node*,Node*> mp;
        Node* prev = newhead;
        Node* temp1=head;
        while(temp1!=NULL)
        {
            Node* node = new Node(temp1->val);
            prev->next=node;
            prev=node;
            mp[temp1]=node;
            temp1=temp1->next;
        }
        newhead=newhead->next;
        temp1=head;
        while(temp1!=NULL)
        {
            mp[temp1]->random=mp[temp1->random];
            temp1=temp1->next;
        }
        return newhead;
    }
};