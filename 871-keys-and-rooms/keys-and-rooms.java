class Solution {

    public int dfs(List<List<Integer>> rooms,int curr,boolean[] vis){
        vis[curr] = true;
        int count = 1;
        for(int x : rooms.get(curr))
        {
            if(vis[x]==false) count += dfs(rooms,x,vis);
        }
        return count;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        return dfs(rooms,0,vis)==n;
    }
}