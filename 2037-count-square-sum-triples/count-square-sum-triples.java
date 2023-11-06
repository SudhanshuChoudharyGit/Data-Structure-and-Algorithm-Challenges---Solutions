class Solution {
    public int countTriples(int n) {
        int count=0;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(j==i) continue;
                double sum = Math.sqrt(i*i + j*j);
                int intSum = (int)sum;
                if((double)intSum==sum && intSum<=n) count++;
            }
        }
        return count;
    }
}