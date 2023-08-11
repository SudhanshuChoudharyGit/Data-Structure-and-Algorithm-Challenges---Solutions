class Solution {
public:

    // vector<string> adjacentWords(unordered_set<string>& wordSet, string curr)
    // {
    //     vector<string> ans;
    //     for(auto word : wordSet)
    //     {
    //         int diff=0;
    //         for(int i=0;i<curr.length();i++)
    //         {
    //             if(curr[i]!=word[i]) diff++;
    //         }
    //         if(diff==1) ans.push_back(word);
    //     }
    //     return ans;
    // }

    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        if(beginWord==endWord) return 0;
        unordered_set<string> wordSet;
        for(string word : wordList) wordSet.insert(word);
        if(wordSet.count(endWord)==0) return 0;
        queue<string> q;
        q.push(beginWord);
        if(wordSet.count(beginWord)!=0) wordSet.erase(beginWord);
        int step=1;
        while(!q.empty())
        {
            int stepSize = q.size();
            while(stepSize--)
            {
                string curr = q.front();
                q.pop();
                if(curr == endWord) return step;
                for(int i=0;i<curr.length();i++)
                {
                    char ogchar= curr[i];
                    for(int j=0;j<26;j++)
                    {
                        if(('a'+j)!=ogchar)
                        {
                            string newWord = curr;
                            newWord[i]='a'+j;
                            if(wordSet.count(newWord)!=0)
                            {
                                q.push(newWord);
                                wordSet.erase(newWord);
                            }
                        }
                    }
                }
                // for(auto word : adjacentWords(wordSet,curr))
                // {
                //     wordSet.erase(word);
                //     q.push(word);
                // } 
            }
            step++;
        }
        return 0;
    }
};