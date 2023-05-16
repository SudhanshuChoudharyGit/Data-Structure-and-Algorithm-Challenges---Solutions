class Trie {
public:
    class Node{
    public:
        bool isWord;
        Node* children[26];

        Node() {
            isWord=false;
            for(int i=0;i<26;i++) children[i]=NULL;
        }
    };

    Node* root;

    Trie() {
        root = new Node();
    }
    
    void insert(string word) {
        Node* temp=root;
        for(char c : word)
        {
            if(temp->children[c-'a']==NULL) temp->children[c-'a']=new Node();
            temp=temp->children[c-'a'];
        }
        temp->isWord=true;
    }
    
    bool search(string word) {
        Node* temp=root;
        for(char c : word)
        {
            if(temp->children[c-'a']==NULL) return false;
            temp=temp->children[c-'a'];
        }
        return (temp->isWord);
    }
    
    bool startsWith(string prefix) {
        Node* temp=root;
        for(char c : prefix)
        {
            if(temp->children[c-'a']==NULL) return false;
            temp=temp->children[c-'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */