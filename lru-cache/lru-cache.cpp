class Node {
    public:
        int key;
        int value;
        Node* prev;
        Node* next;

        Node()
        {
            this->prev=NULL;
            this->next=NULL;
        }

        Node(int key,int value)
        {
            this->key=key;
            this->value=value;
            this->prev=NULL;
            this->next=NULL;
        }
};

class LRUCache {
public:
    int capacity;
    unordered_map<int,Node*> mp;
    Node* left;
    Node* right;
    
    

    LRUCache(int capacity) {
        this->capacity=capacity;
        left= new Node(0,0);
        right= new Node(0,0);
        left->next=right;
        left->prev=NULL;
        right->next=NULL;
        right->prev=left;
    }

    void remove(Node* node)
    {
        Node* prv = node->prev;
        Node* nxt = node->next;
        prv->next=nxt;
        nxt->prev=prv;
    }

    //inserts on right most
    void insert(Node* node)
    {
        Node* prv=right->prev;
        Node* nxt=right;
        prv->next=node;
        nxt->prev=node;
        node->next=nxt;
        node->prev=prv;
    }
    
    int get(int key) {
        if(mp.find(key)==mp.end()) return -1;
        this->remove(mp[key]);
        this->insert(mp[key]);
        return mp[key]->value;
    }
    
    void put(int key, int value) {
        if(mp.find(key)!=mp.end())  this->remove(mp[key]);
        Node* node= new Node(key,value);
        mp[key]=node;
        this->insert(node);

        //capacity passed
        if(mp.size()>this->capacity)
        {
            Node* rem = left->next;
            mp.erase(rem->key);
            this->remove(rem);
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */