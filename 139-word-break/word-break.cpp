class Solution {
public:
    //approach 1: DP
    // bool wordBreak(string s, vector<string>& wordDict) {
    //     int n=s.length();
    //     int m=wordDict.size();
    //     vector<bool> dp(n+1,false);
    //     dp[0]=true;
    //     for(int i=1;i<=n;i++)
    //     {
    //         for(int j=0;j<m;j++)
    //         {
    //             string word=wordDict[j];
    //             int len=word.length();
    //             if(i>=len)
    //             {
    //                 if(s.substr(i-len,len)==word)
    //                 {
    //                     dp[i]=dp[i-len];
    //                     if(dp[i]==true) break;
    //                 }
    //             }
    //         }
    //     }
    //     return dp[n];
    // }


    //approach - backtracking
    // bool isPrefix(string source,string target) {
    //     int i=0;
    //     for(char c : source)
    //     {
    //         if(c!=target[i]) return false;
    //         i++;
    //     }
    //     return true;
    // }

    // bool backtrack(string s,vector<string>& wordDict,string curr) {
    //     if(curr == s) return true;
    //     for(auto word : wordDict)
    //     {
    //         if(!isPrefix(curr+word,s)) continue;
    //         if(backtrack(s,wordDict,curr+word)) return true;
    //     }
    //     return false;
    // }

    // bool wordBreak(string s, vector<string>& wordDict) {
    //     string curr="";
    //     return backtrack(s,wordDict,curr);
    // }



     //approach - backtracking - memoization
    bool isPrefix(string source,string target) {
        int i=0;
        for(char c : source)
        {
            if(c!=target[i]) return false;
            i++;
        }
        return true;
    }

    bool backtrack(string s,vector<string>& wordDict,string curr,unordered_map<string,bool>& mp) {
        if(curr == s) return true;
        for(auto word : wordDict)
        {
            if(!isPrefix(curr+word,s)) continue;
            if(mp.find(curr+word)!=mp.end())
            {
                if(mp[curr+word]) return true;
            }
            else {
                if(backtrack(s,wordDict,curr+word,mp))
                {
                    mp[curr+word]=true;
                    return true;
                }
                else mp[curr+word]=false;
            }   
        }
        return false;
    }

    bool wordBreak(string s, vector<string>& wordDict) {
        string curr="";
        unordered_map<string,bool> mp;
        return backtrack(s,wordDict,curr,mp);
    }


};