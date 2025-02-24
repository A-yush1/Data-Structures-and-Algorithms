class Solution {

    void dfsForAlice(int currNode, int time, int currIncome, int maxIncome[], int amount[], boolean visited
    [], Map<Integer, Integer> bobTimeMap, Map<Integer, List<Integer>> adj)
    {
        visited[currNode] = true;

        if(!bobTimeMap.containsKey(currNode) || time < bobTimeMap.get(currNode))
        currIncome += amount[currNode];
        else if(time == bobTimeMap.get(currNode))
        currIncome += amount[currNode] / 2;

        if(adj.getOrDefault(currNode, new ArrayList<>()).size() == 1 && currNode != 0)
        maxIncome[0] = Math.max(maxIncome[0], currIncome);

        for(int ngbr : adj.getOrDefault(currNode, new ArrayList<>()))
        {
            if(!visited[ngbr])
            dfsForAlice(ngbr, time + 1, currIncome, maxIncome, amount, visited, bobTimeMap, adj);
        }
    }
    boolean dfsForBob(int currNode, int time, boolean visited[], Map<Integer, Integer> bobTimeMap, 
    Map<Integer, 
    List<Integer>> adj)
    {
        visited[currNode] = true;
        bobTimeMap.put(currNode, time);

        if(currNode == 0)
        return true;

        for(int ngbr : adj.getOrDefault(currNode, new ArrayList<>()))
        {
            if(!visited[ngbr])
            {
                if(dfsForBob(ngbr, time + 1, visited, bobTimeMap, adj) == true)
                return true;
            }

        }

        bobTimeMap.remove(currNode);
        return false;
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int edge[] : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }


        Map<Integer, Integer> bobTimeMap = new HashMap<>();
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);

        dfsForBob(bob, 0, visited, bobTimeMap, adj);

        int currIncome = 0;
        int maxIncome[] = new int[1];
        maxIncome[0] = Integer.MIN_VALUE;

        Arrays.fill(visited, false);

        dfsForAlice(0, 0, 0, maxIncome, amount, visited, bobTimeMap, adj);

        return maxIncome[0];

    }
}