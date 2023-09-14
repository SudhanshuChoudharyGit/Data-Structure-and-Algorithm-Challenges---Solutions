class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> freq= new HashMap<>();
        for(var str : cpdomains)
        {
            String[] numAndDomain = str.split(" ");
            int num = Integer.parseInt(numAndDomain[0]);
            String[] strings = numAndDomain[1].split("\\.");
            String entry = "";
            for(int i=strings.length-1;i>=0;i--)
            {
                entry = strings[i] + entry;
                if(freq.containsKey(entry)) freq.put(entry,freq.get(entry)+num);
                else freq.put(entry,num);
                entry = "." + entry;   
            }
        }
        List<String> ans = new ArrayList<>();
        for(var entry : freq.entrySet())
        {
            String addStr = "";
            addStr += entry.getValue();
            addStr += " ";
            addStr += entry.getKey();
            ans.add(addStr);
        }
        return ans;
    }
}