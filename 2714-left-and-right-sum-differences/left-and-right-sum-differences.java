class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int x : nums) totalSum += x;

        int[] answer = new int[n];
        int leftSum = 0;
        int rightSum = totalSum;
        for(int i=0;i<n;i++)
        {
            rightSum -= nums[i];
            answer[i] = Math.abs(leftSum-rightSum);
            leftSum += nums[i];
        }

        return answer;
    }
}