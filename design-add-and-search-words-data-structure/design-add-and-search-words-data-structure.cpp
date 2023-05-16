class WordDictionary {
public:
    bool isWord;
    WordDictionary* children[26];

    WordDictionary() {
        isWord=false;
        memset(children, 0, sizeof(children));
    }
    
    void addWord(string word) {
        WordDictionary* temp=this;
        for(char c : word)
        {
            if(temp->children[c-'a']==NULL) temp->children[c-'a']=new WordDictionary();
            temp=temp->children[c-'a'];
        }
        temp->isWord=true;
    }

    bool search(string word) {
        WordDictionary* temp=this;
        for(int i=0;i<word.length();i++)
        {
            if(word[i]=='.')
            {
                for(int j=0;j<26;j++)
                {
                    if(temp->children[j] && temp->children[j]->search(word.substr(i+1))) return true;
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