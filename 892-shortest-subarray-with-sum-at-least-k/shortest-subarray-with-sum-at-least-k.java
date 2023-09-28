class Pair{
    long val;
    int ind;

    public Pair(long val,int ind){
        this.val = val;
        this.ind = ind;
    }
}

class Solution {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        int ans = Integer.MAX_VALUE;

        Deque<Pair> dq = new ArrayDeque<>();

        for(int i=0;i<n;i++)
        {
            prefixSum += nums[i];
            if(prefixSum>=k) ans = Math.min(ans,i + 1);
            while(dq.size()>0 && prefixSum - dq.getFirst().val>=k)
            {
                ans = Math.min(ans,i - dq.getFirst().ind);
                dq.removeFirst();
            }

            while(dq.size()>0 && dq.getLast().val>prefixSum) dq.removeLast();
            dq.addLast(new Pair(prefixSum,i));
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;

    }
}