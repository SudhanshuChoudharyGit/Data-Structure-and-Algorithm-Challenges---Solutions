class Pair{
    String node;
    double wt;

    public Pair(String node, double wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {

    public boolean dfs(HashMap<String,ArrayList<Pair>> graph, String i,String target,HashMap<String,Double> dis){
        if(i.equals(target)) return true;

        for(Pair p : graph.get(i))
        {
            String node = p.node;
            double wt = p.wt;
            if(dis.containsKey(node)) continue;
            dis.put(node,dis.get(i)*wt);
            if(dfs(graph,node,target,dis)) return true;
        }
        return false;    
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,ArrayList<Pair>> graph = new HashMap<>();
        for(int i=0;i<values.length;i++)
        {
            List<String> eq = equations.get(i);
            String first = eq.get(0);
            String second = eq.get(1);
            double factor = values[i];
            ArrayList<Pair> firstedges = graph.getOrDefault(first,new ArrayList<Pair>());
            firstedges.add(new Pair(second,(double)factor));
            graph.put(first,firstedges);
            ArrayList<Pair> secondedges = graph.getOrDefault(second,new ArrayList<Pair>());
            secondedges.add(new Pair(first,(double)1/factor));
            graph.put(second,secondedges);
        }
        int n = queries.size();
        double[] ans = new double[n];
        for(int i=0;i<n;i++)
        {
            List<String> query = queries.get(i);
            String source = query.get(0);
            String target = query.get(1);
            HashMap<String,Double> dis = new HashMap<>();
            if(!graph.containsKey(source)) ans[i] = -1.0;
            else if(source.equals(target)) ans[i] = 1.0;
            else{
            dis.put(source,(double)1.0);
            if(dfs(graph,source,target,dis)) ans[i]=dis.get(target);
            else ans[i] = -1.0;
            }
        }
        return ans;
    }
}