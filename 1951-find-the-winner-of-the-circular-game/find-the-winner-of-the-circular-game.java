class Solution {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++) list.add(i);

        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<k-1;j++)
            {
                list.add(list.poll());
            }
            list.poll();
        }
        return list.poll();
    }
}