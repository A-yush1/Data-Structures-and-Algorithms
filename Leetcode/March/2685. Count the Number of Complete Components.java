class Solution {
    void dfs(int node, boolean visited[], List<List<Integer>> adj, int par, int nodes[], int ed[])
    {
        visited[node] = true;
        nodes[0]++;

        for(int ngbr : adj.get(node))
        {
            
            ed[0]++;
            if(visited[ngbr] == false)
            dfs(ngbr, visited, adj, node, nodes, ed);
        }

    }
    public int countCompleteComponents(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++)
        adj.add(new ArrayList<>());

        for(int i=0; i<edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int connComp = 0;
        boolean visited[] = new boolean[n];
        for(int i=0; i<n; i++)
        {
            if(visited[i] == false)
            {
                
                int ed[] = new int[1];
                int nodes[] = new int[1];
                dfs(i, visited, adj, -1, nodes, ed);

                System.out.println(i + " " + ed[0] + " " + nodes[0]);
                if(ed[0] / 2 == (nodes[0] * (nodes[0] - 1)) / 2)
                connComp++; 
            }
        }

        return connComp;
    }
}