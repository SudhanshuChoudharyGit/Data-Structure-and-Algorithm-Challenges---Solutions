class Solution {
    public int[] leftRightDifference(int[] nums) {
    int n = nums.length; //4
    int[] answer = new int[n]; //4 array = 0

    int leftSum = 0;
    for(int i=0;i<n;i++)
    {
        answer[i] = leftSum; //[0,10,14,22]
        leftSum += nums[i];
    }
    
    int rightSum = 0;
    for(int i=n-1;i>=0;i--)
    {
        answer[i] = Math.abs(answer[i]-rightSum); //[,11,22]
        rightSum += nums[i];
    }

    return answer;

    }
}