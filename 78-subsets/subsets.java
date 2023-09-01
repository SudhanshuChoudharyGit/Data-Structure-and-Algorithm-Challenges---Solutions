class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs= new ArrayList<>();
        int n = nums.length;
        int count_bitmask = (int)Math.pow(2,n);

        for(int bitmask = 0; bitmask<count_bitmask; bitmask++)
        {
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                if((bitmask & 1<<i) != 0) sub.add(nums[i]);
            }
            subs.add(sub);
        }
        return subs;
    }
}