class Solution {
    public int numIdenticalPairs(int[] nums) {
        // int n = nums.length;
        // int ans = 0;
        // for(int i=0;i<n-1;i++)
        // {
        //     for(int j=i+1;j<n;j++)
        //     {
        //         if(nums[i]==nums[j]) ans++;
        //     }
        // }
        // return ans;
        int ans = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int x : nums)
        {
            if(mp.containsKey(x)) ans+=mp.get(x);
            mp.putIfAbsent(x,0);
            mp.put(x,mp.get(x)+1);
        }
        return ans;
    }
}