class WordDictionary {
public:
    class Node {
    public:
        bool isWord;
        Node* children[26];

        Node(){
            isWord=false;
            for(int i=0;i<26;i++) children[i]=NULL;
        }
    };

    Node* root;

    WordDictionary() {
        root= new Node();
    }
    
    void addWord(string word) {
        Node* temp=root;
        for(char c : word)
        {
            if(temp->children[c-'a']==NULL) temp->children[c-'a']=new Node();
            temp=temp->children[c-'a'];
        }
        temp->isWord=true;
    }

    bool addSearch(Node* node,string word)
    {
        Node* temp=node;
        for(int i=0;i<word.length();i++)
        {
            if(word[i]=='.')
            {
                for(int j=0;j<26;j++)
                {
                    if(temp->children[j] && addSearch(temp->children[j],word.substr(i+1))) return true;
                }
                return false;
            }
            else
            {
                if(temp->children[word[i]-'a']==NULL) return false;
                temp=temp->children[word[i]-'a'];
            }
        }
        return temp->isWord;
    }
    
    bool search(string word) {
        Node* temp=root;
        for(int i=0;i<word.length();i++)
        {
            if(word[i]=='.')
            {
                for(int j=0;j<26;j++)
                {
                    if(temp->children[j] && addSearch(temp->children[j],word.substr(i+1))) return true;
                }
                return false;
            }
            else
            {
                if(temp->children[word[i]-'a']==NULL) return false;
                temp=temp->children[word[i]-'a'];
            }
        }
        return temp->isWord;
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */