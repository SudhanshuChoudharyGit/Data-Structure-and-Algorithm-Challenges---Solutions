class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int sum = 0 - nums[i];
            int l = i+1;
            int r = n-1;
            while(l<r)
            {
                if(nums[l]+nums[r]==sum)
                {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r])));
                    int val = nums[l];
                    while(l<r && nums[l] == val) l++;
                    r--;
                }
                else if(nums[l]+nums[r]<sum) l++;
                else r--;
            }
        }
        return ans;
    }
}