class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int aster : asteroids)
        {
            boolean ignore = false;
            while(dq.size()>0 && dq.getLast()>0 && aster<0)
            {
                if(dq.getLast()>Math.abs(aster))
                {
                    ignore = true;
                    break;
                }
                if(dq.getLast()==Math.abs(aster))
                {
                    ignore = true;
                    dq.removeLast();
                    break;
                }
                dq.removeLast();
            }
            if(!ignore) dq.addLast(aster);
        }
        int n = dq.size();
        int[] ans = new int[n];

        for(int i=0;i<n;i++) ans[i] = dq.removeFirst();
        return ans;
    }
}