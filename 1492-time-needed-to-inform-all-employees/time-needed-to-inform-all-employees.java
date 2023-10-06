class Solution {

    public int dfs(int id,Map<Integer,ArrayList<Integer>> mp,int[] informTime){

        int time = 0;

        for(int sub : mp.getOrDefault(id,new ArrayList<>()))
        {
            time = Math.max(time,dfs(sub,mp,informTime));
        }

        return time + informTime[id];
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(i==headID) continue;
            ArrayList<Integer> sub = mp.getOrDefault(manager[i],new ArrayList<>());
            sub.add(i);
            mp.put(manager[i],sub);
        }

        return dfs(headID,mp,informTime);
    }
}