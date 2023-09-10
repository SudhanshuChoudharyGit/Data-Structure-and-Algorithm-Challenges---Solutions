class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currgas = 0;
        int start = 0;
        int i=0;
        while(start<n)
        {
            currgas += gas[i%n];
            int currcost = cost[i%n];
            i++;
            if(currgas>=currcost)
            {
                if(start==(i%n)) return start;
                currgas -= currcost;    
            }
            else
            {
                start = i;
                currgas = 0;
            }
        }
        return -1;
    }
}