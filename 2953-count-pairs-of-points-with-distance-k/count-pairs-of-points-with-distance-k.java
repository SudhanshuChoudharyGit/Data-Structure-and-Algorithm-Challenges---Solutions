class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        // y2 = y1^(k-val)
        // x2 = x1^val
        // 0 <= val <= k 
        
        // map x -> { y -> freq,y-> freq , }
        int count = 0;
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(var coord : coordinates)
        {
            int x1 = coord.get(0);
            int y1 = coord.get(1);
            for(int val = 0; val<=k; val++)
            {
                int x2 = val^x1;
                int y2 = (k-val)^y1;
                if(map.containsKey(x2) && map.get(x2).containsKey(y2)) 
                count += map.get(x2).get(y2);
            }
            HashMap<Integer,Integer> entries = map.getOrDefault(x1,new HashMap<>());
            entries.put(y1,entries.getOrDefault(y1,0)+1);
            map.put(x1,entries);
        }
        return count;
    }
}