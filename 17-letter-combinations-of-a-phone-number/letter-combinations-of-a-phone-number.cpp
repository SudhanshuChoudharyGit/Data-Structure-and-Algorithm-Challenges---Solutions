class Solution {
public:


    void backtrack(string& digits,unordered_map<int,string>& mp,vector<string>& ans,string str,int i)
    {
        if(str.length()==digits.length())
        {
            ans.push_back(str);
            return;
        }
        for(char c : mp[digits[i]-'0'])
        {
            str+=c;
            backtrack(digits,mp,ans,str,i+1);
            str=str.substr(0,str.length()-1);
        }
    }

    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        if(digits.length()==0) return ans;
        string str="";
        unordered_map<int,string> mp;
        mp[2]="abc";
        mp[3]="def";
        mp[4]="ghi";
        mp[5]="jkl";
        mp[6]="mno";
        mp[7]="pqrs";
        mp[8]="tuv";
        mp[9]="wxyz";
        backtrack(digits,mp,ans,str,0);
        return ans;
    }
};