class Pair{
    int length;
    int prev;

    Pair(){
        length=1;
        prev=-1;
    }

    Pair(int first,int second){
        this.length=first;
        this.prev=second;
    }
}

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        Pair[] dp = new Pair[nums.length];

        int maxindex = 0;
        int maxlength = 1;

        for(int i=0;i<nums.length;i++)
        {
            dp[i] = new Pair();
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0)
                {
                    if(dp[j].length+1>dp[i].length)
                    {
                        dp[i].length = dp[j].length+1;
                        dp[i].prev = j;
                    }
                }
            }
            if(maxlength<dp[i].length)
            {
                maxlength = dp[i].length;
                maxindex = i;
            }
        }


        List<Integer> ans = new ArrayList<Integer>();

        while(maxindex!=-1)
        {
            ans.add(nums[maxindex]);
            maxindex = dp[maxindex].prev;
        }
        

        return ans;

    }
}