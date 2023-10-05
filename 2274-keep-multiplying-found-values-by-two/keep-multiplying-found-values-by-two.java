class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for(int x : nums)
        {
            if(x>original) return original;
            if(x == original) original*=2;
        }
        return original;
    }
}