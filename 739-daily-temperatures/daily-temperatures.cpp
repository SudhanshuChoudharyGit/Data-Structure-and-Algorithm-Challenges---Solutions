class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        //monotonic stack
        //which houses non increasing values from the right
        stack<pair<int,int>> ms;
        int n = temperatures.size();
        vector<int> ans(n,0);
        for(int i=n-1;i>=0;i--)
        {
            int currtemp = temperatures[i];

            //compare and popout smaller or equal tempratures unless found greater or emptied stack
            while(!ms.empty() && ms.top().first<=currtemp) ms.pop();

            //the len ans is the distance between the current and greater temp index
            if(ms.empty()) ans[i]=0;
            else ans[i]=ms.top().second-i;

            //push the current temp with index
            ms.push({currtemp,i});   
        }
        return ans;
    }
};