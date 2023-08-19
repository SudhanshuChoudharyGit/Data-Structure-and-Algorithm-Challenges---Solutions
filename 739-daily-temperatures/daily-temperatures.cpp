class Solution {
public:

    //using extra array which stores the nearest bigger element
    //intution: while going from right to left
    //if the next element of the current element (j=i+1) is bigger than current(i), then that is the answer
    //if that is not the case then we need to look for the nearest bigger than j index element untill that
    //becomes greater than the current index value
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> ans(n,0);
        vector<int> nb(n,0);
        for(int i=n-1;i>=0;i--)
        {
            int j = i+1;
            while(j<n && temperatures[i]>=temperatures[j]) j = nb[j];
            nb[i]=j;
            ans[i] = nb[i]==n ? 0 : nb[i]-i;
        }
        return ans;
    }

    //monotonic stack
    //which houses non increasing values from the right
    // vector<int> dailyTemperatures(vector<int>& temperatures) {
    //     stack<pair<int,int>> ms;
    //     int n = temperatures.size();
    //     vector<int> ans(n,0);
    //     for(int i=n-1;i>=0;i--)
    //     {
    //         int currtemp = temperatures[i];

    //         //compare and popout smaller or equal tempratures unless found greater or emptied stack
    //         while(!ms.empty() && ms.top().first<=currtemp) ms.pop();

    //         //the len ans is the distance between the current and greater temp index
    //         if(ms.empty()) ans[i]=0;
    //         else ans[i]=ms.top().second-i;

    //         //push the current temp with index
    //         ms.push({currtemp,i});   
    //     }
    //     return ans;
    // }
};