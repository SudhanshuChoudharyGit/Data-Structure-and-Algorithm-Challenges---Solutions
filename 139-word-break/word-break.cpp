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
    // bool isPrefix(string source,string target) {
    //     int i=0;
    //     for(char c : source)
    //     {
    //         if(c!=target[i]) return false;
    //         i++;
    //     }
    //     return true;
    // }

    // bool backtrack(string s,vector<string>& wordDict,string curr,unordered_map<string,bool>& mp) {
    //     if(curr == s) return true;
    //     for(auto word : wordDict)
    //     {
    //         if(!isPrefix(curr+word,s)) continue;
    //         if(mp.find(curr+word)!=mp.end())
    //         {
    //             if(mp[curr+word]) return true;
    //         }
    //         else {
    //             if(backtrack(s,wordDict,curr+word,mp))
    //             {
    //                 mp[curr+word]=true;
    //                 return true;
    //             }
    //             else mp[curr+word]=false;
    //         }   
    //     }
    //     return false;
    // }

    // bool wordBreak(string s, vector<string>& wordDict) {
    //     string curr="";
    //     unordered_map<string,bool> mp;
    //     return backtrack(s,wordDict,curr,mp);
    // }

// Approach - backtrack with memoization but instead of building number we will be reducing numner as soon as prefix is found

    // bool backtrack(string s,vector<string>& wordDict,int start_index,vector<int>& memo) {
    //     if(start_index == s.length()) return true;
    //     if(memo[start_index]!=-1) return (memo[start_index]==1);
    //     for(string word : wordDict)
    //     {
    //         if(word==s.substr(start_index,word.length()))
    //         {
    //             if(backtrack(s,wordDict,start_index+word.length(),memo))
    //             {
    //                 memo[start_index]=1;
    //                 return true;
    //             }
    //         }
    //     }
    //     memo[start_index]=0;
    //     return false;
    // }


    // bool wordBreak(string s, vector<string>& wordDict) {
    //     vector<int> memo(s.length(),-1);
    //     return backtrack(s,wordDict,0,memo);
    // }


// Approach : dp derived from backtrack with memo

    bool wordBreak(string s, vector<string>& wordDict) {
        vector<bool> dp(s.length()+1,false);
        dp[0]=true;
        unordered_set<string> st(wordDict.begin(),wordDict.end());
        for(int i=1;i<=s.length();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j])
                {
                    if(st.find(s.substr(j,i-j))!=st.end())
                    {
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

};