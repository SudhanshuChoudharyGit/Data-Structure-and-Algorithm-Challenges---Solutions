class Solution {

    public class UnionFind<T>{
        private HashMap<T,T> id = new HashMap<>();

        public T find(T x){
            T y = id.getOrDefault(x,x);
            if(y!=x)
            {
                y = find(y);
                id.put(x,y);
            }
            return y;
        }

        public void union(T x,T y){
            id.put(find(x),find(y));
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //Union find disjoint sets of account indexes
        UnionFind<Integer> uf= new UnionFind<>();

        //emails -> account index
        HashMap<String,Integer> accountIndex = new HashMap<>();

        for(int i=0;i<accounts.size();i++)
        {
            List<String> account = accounts.get(i);
            int ind = i;
            for(int j=1;j<account.size();j++)
            {
                String email = account.get(j);
                if(accountIndex.containsKey(email)) uf.union(ind,accountIndex.get(email));
                accountIndex.put(email,ind);
            }
        }


        //leader account index -> emails
        HashMap<Integer,ArrayList<String>> leaderToEmail = new HashMap<>();

        for(var pair : accountIndex.entrySet())
        {
            int ind = pair.getValue();
            String email = pair.getKey();
            int leaderInd = uf.find(ind);
            if(!leaderToEmail.containsKey(leaderInd)) leaderToEmail.put(leaderInd,new ArrayList<String>());
            leaderToEmail.get(leaderInd).add(email);
        }


        //convert account index to name for account 
        List<List<String>> ans = new ArrayList<>();
        for(var pair : leaderToEmail.entrySet())
        {
            int ind = pair.getKey();
            String name = accounts.get(ind).get(0);
            List<String> emails = pair.getValue();
            Collections.sort(emails);
            List<String> entry = new ArrayList<>();
            entry.add(name);
            entry.addAll(emails);
            ans.add(entry);
        }

        return ans;
    }
}