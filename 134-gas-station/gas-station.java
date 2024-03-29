class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int surplus = 0;
        int totalsurplus = 0;
        int start =0;
        for(int i=0;i<n;i++)
        {
            totalsurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus<0)
            {
                surplus = 0;
                start = i+1;
            }
        }

        return totalsurplus<0 ? -1 : start;
    }
}