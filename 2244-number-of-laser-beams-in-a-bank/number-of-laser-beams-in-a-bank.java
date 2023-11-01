class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int ans = 0;
        int prevCount = 0;
        for(int i=0;i<m;i++)
        {
            int currCount = 0;
            for(int j=0;j<n;j++) currCount += (bank[i].charAt(j)=='1')? 1 : 0;
            if(currCount!=0)
            {
                ans += prevCount * currCount;
                prevCount = currCount;
            }
        }
        return ans;
    }
}