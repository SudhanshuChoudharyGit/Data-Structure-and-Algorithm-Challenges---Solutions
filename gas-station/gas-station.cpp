class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int ans;
        int s=0;
        for(int i=0;i<gas.size();i++)
        {
            s+=(gas[i]-cost[i]);
        }
        if(s<0) return -1;
        int i=0;
        while(i<gas.size())
        {
            int sum=0;
            int index=i;
            if(gas[i]>=cost[i])
            {
                sum+=(gas[i]-cost[i]);
                while(sum>=0)
                {
                    i++;
                    if(i>=gas.size()) return index;
                    sum+=(gas[i]-cost[i]);
                }
            }
            i++;
        }
        return -1;
    }
};