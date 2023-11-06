class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int currMax = 0;
        for(int candy : candies) currMax = Math.max(candy,currMax);

        List<Boolean> ans = new ArrayList<>();
        for(int candy : candies)
        {
            if(candy+extraCandies>=currMax) ans.add(true);
            else ans.add(false);
        }

        return ans;
    }
}