import java.util.*;

class Solution {

    public int firstEqualorGreater(Vector<Integer> v,int target){
        int l=0;
        int r= v.size()-1;

        int ansind=0;

        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(v.get(m)>=target)
            {
                ansind = m;
                r=m-1;
            }
            else l=m+1;
        }

        return ansind;
    }

    //binary search
    public int lengthOfLIS(int[] nums) {
        Vector<Integer> v = new Vector<Integer>();

        v.add(nums[0]);

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>v.get(v.size()-1)) v.add(nums[i]);
            else
            {
                int index = firstEqualorGreater(v,nums[i]);
                v.set(index,nums[i]);
            }
        }

        return v.size();
    }

    //dp
    /*
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp= new int[n];

        Arrays.fill(dp,1);

        int ans = 1;

        for(int i=1;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[j]<nums[i]) dp[i]=Math.max(dp[i],dp[j]+1);
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    */
}