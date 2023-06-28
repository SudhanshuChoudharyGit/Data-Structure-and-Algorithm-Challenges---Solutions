    class Trie {
        public:
        bool isWord;
        Trie* children[26];

        Trie() {
            isWord=false;
            for(int i=0;i<26;i++) children[i]=NULL;
        }


    void addWord(string s) {
        Trie* temp = this;
        for(char c : s)
        {
            if(temp->children[c-'a']==NULL) temp->children[c-'a']=new Trie();
            temp=temp->children[c-'a'];
        }
        temp->isWord=true;
    }

    bool wordExist(string s) {
        Trie* temp = this;
        for(char c: s)
        {
            if(temp->children[c-'a']==NULL) return false;
            temp=temp->children[c-'a'];
        }
        return temp->isWord;
    }

    bool isPrefix(string s) {
        Trie* temp = this;
        for(char c: s)
        {
            if(temp->children[c-'a']==NULL) return false;
            temp=temp->children[c-'a'];
        }
        return true;
    }

    };


class Solution {
public:

    void fun(string& s,Trie* trie,int index,int n,string curr,string str,vector<string>& ans) {
        if(index>=n) return;
        curr+=s[index];
        if(trie->isPrefix(curr))
        {
            fun(s,trie,index+1,n,curr,str,ans);
        }
        else return;
        if(trie->wordExist(curr))
        {
            str+=curr;
            if(index==n-1)
            {
                ans.push_back(str);
                return;
            }
            str+=" ";
            curr="";
            fun(s,trie,index+1,n,curr,str,ans);
        }
    }

    vector<string> wordBreak(string s, vector<string>& wordDict) {
        vector<string> ans;
        Trie* trie=new Trie();
        for(string word : wordDict)
        {
            trie->addWord(word);
        }
        string curr="";
        string str="";
        fun(s,trie,0,s.length(),curr,str,ans);
        return ans;
    }
};