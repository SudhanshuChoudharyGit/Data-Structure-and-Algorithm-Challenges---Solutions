class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for(int i=1;i<=numRows;i++)
        {
            ArrayList<Integer> entry = new ArrayList<>(i);
            for(int ind=0;ind<i;ind++)
            {
                if(ind==0 || ind==i-1) entry.add(1);
                else
                {
                    entry.add(ans.get(i-2).get(ind-1)+ans.get(i-2).get(ind));
                }
            }
            ans.add(entry);
        }
        return ans;
    }
}