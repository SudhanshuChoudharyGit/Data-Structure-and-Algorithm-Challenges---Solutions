class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //graph
        // busstop -> {busroutes}
        // making graph for non zero indexed 1 to V nodes graph
        // using hashmap
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0;i<routes.length;i++)
        {
            for(int j=0;j<routes[i].length;j++)
            {
                int busstop = routes[i][j];
                ArrayList<Integer> busroutes = graph.getOrDefault(busstop,new ArrayList<>());
                busroutes.add(i);
                graph.put(busstop,busroutes);
            }
        }

        // add source busstop 
        HashSet<Integer> busstopvis = new HashSet<>();
        HashSet<Integer> busroutesvis = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(source);
        busstopvis.add(source);
        int level = 0;

        // check what busroutes it can reach in BFS
        // visit all busstops on all the busroutes it is connected to in that step
        // **two while loop BFS**
        // if destination -> return level;
        while(q.size()>0)
        {
            int size = q.size();
            while(size-- >0)
            {
                int node = q.removeFirst();
                if(node == target) return level;
                for(int busroute : graph.get(node))
                {
                    if(busroutesvis.contains(busroute)) continue;
                    for(int busstops : routes[busroute])
                    {
                        if(busstopvis.contains(busstops)) continue;
                        busstopvis.add(busstops);
                        q.addLast(busstops);
                    }
                    busroutesvis.add(busroute);
                }
            }
            level++;
        }
        return -1;

    }
}