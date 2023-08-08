class Solution {
public:

// int numDecodings(string s) {
//     int n=s.length();
//     int dp[n+1];
//     dp[0]=1;
//     dp[1]=(s[0]=='0'?0:1);
//     for(int i=2;i<=n;i++)
//     {
//         if(s[i-1]!='0')
//         {
//             if(s[i-2]!='0' && stoi(s.substr(i-2,2))<=26)
//             {
//                 dp[i]=dp[i-1]+dp[i-2];
//             }
//             else dp[i]=dp[i-1];
//         }
//         else 
//         {
//             if(stoi(s.substr(i-2,2))>0 && stoi(s.substr(i-2,2))<=26) dp[i]=dp[i-2];
//             else dp[i]=0;
//         }
//     }
//     return dp[n];
// }



/*


    int fun(int i,string s,vector<int>& dp)
    {
        if(i>=s.length()) return 1;
        if(dp[i]!=-1) return dp[i];
        int ans=0;
        int op1= s[i]-'0';
        int op2=0;
        if(i<s.length()-1) op2=op1*10+s[i+1] - '0';
        if(op1>0) ans+=fun(i+1,s,dp);
        if(op1>0 && op2>0 && op2<=26) ans+=fun(i+2,s,dp);
        dp[i]=ans;
        return dp[i];
    }

    int numDecodings(string s) {
        vector<int> dp(101,-1);
        return fun(0,s,dp);
    }
*/


// backtracking

    int backtrack(string s,int start_index,vector<int>& memo)
    {
        if(start_index==s.length()) return 1;
        if(memo[start_index]!=-1) return memo[start_index];
        int ans=0;
        int num1 = stoi(s.substr(start_index,1));
        if(num1>0 && num1<27) ans+=backtrack(s,start_index+1,memo);
        if(num1>0 && start_index+1<s.length())
        {
            int num2 = stoi(s.substr(start_index,2));
            if(num2<27) ans+=backtrack(s,start_index+2,memo);
        }
        memo[start_index]=ans;
        return ans;
    }

    int numDecodings(string s) {
        vector<int> memo(s.length(),-1);
        return backtrack(s,0,memo);
    }

};