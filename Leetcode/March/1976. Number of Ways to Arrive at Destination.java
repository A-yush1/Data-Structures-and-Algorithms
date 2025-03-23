class Solution {

    final int MOD = 1000000007;
    class Pair{
        int node;
        long time;

        Pair(int node, long time)
        {
            this.node = node;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++)
        adj.add(new ArrayList<>());

        for(int i=0; i<roads.length; i++)
        {
            int u = roads[i][0];
            int v = roads[i][1];
            int time = roads[i][2];

            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u,time)); 
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.time));
        pq.offer(new Pair(0, 0));

        long result[] = new long[n];
        Arrays.fill(result, Long.MAX_VALUE);
        result[0] = 0;

        int countPath[] = new int[n];
        countPath[0] = 1;

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int currNode = curr.node;
            long currTime = curr.time;

            for(Pair ngbr : adj.get(currNode))
            {
                if(currTime + ngbr.time < result[ngbr.node])
                {
                    result[ngbr.node] = currTime + ngbr.time;
                    pq.offer(new Pair(ngbr.node, result[ngbr.node]));
                    
                    countPath[ngbr.node] = countPath[currNode];

                }
                else if(currTime + ngbr.time == result[ngbr.node])
                {
                    countPath[ngbr.node] = (countPath[ngbr.node] + countPath[currNode]) % MOD;
                }
            }
        }

        return countPath[n-1];
    }
}