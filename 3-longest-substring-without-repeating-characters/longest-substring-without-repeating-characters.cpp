class Solution {
public:

    //sliding window / two pointers
    int lengthOfLongestSubstring(string s) {
        int len=0;
        if(s.length()==0) return len;
        int i=0;
        int j=0;
        vector<int> freq(256,0);
        while(j<s.length())
        {
            freq[s[j]]++;
            while(freq[s[j]]>1)
            {
                freq[s[i]]--;
                i++;
            }
            len=max(len,j-i+1);
            j++;
        }
        return len;
    }






























// int lengthOfLongestSubstring(string s) {

//     //using set
//     int n=s.length();
//     if(n==0 || n==1) return n;
//     set<char> currchars;
//     int maxlen=0;
//     int left=0;
//     for(int right=0;right<n;right++)
//     {
//         while(currchars.count(s[right])!=0)
//         {
//             currchars.erase(s[left]);
//             left++;
//         }
//         currchars.insert(s[right]);
//         int currlen=currchars.size();
//         maxlen=max(maxlen,currlen);
//     }
//     return maxlen;

// }


/*
    int lengthOfLongestSubstring(string s) {
        //using index vector
        vector<int> v(128,-1);

        int curr_len=0;
        int max_len=0;
        int l=0;

        for(int i=0;i<s.length();i++)
        {
            if(v[s[i]]==-1) 
            {
                curr_len+=1;
            }
            else
            {
                int x=max(l,v[s[i]]);
                curr_len=i-x;
                l=x;
            }
            v[s[i]]=i;
            max_len=max(max_len,curr_len);
        }
        return max_len;
    }
*/
};