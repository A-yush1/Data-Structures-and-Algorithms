class Solution {
    class Pair{
        int node, weight;
        Pair(int node, int weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }
    void dfs(int node, int visited[], int group[], int groupNo, int andVal[], List<List<Pair>> adj)
    {
        visited[node] = 1;
        group[node] = groupNo;

        for(Pair p : adj.get(node))
        {
            andVal[0] &= p.weight;
            if(visited[p.node] == 0)
            {
                
                dfs(p.node, visited, group, groupNo, andVal, adj);
            }
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        

        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++)
        adj.add(new ArrayList<>());

        for(int i=0; i<edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));

        }

        int visited[] = new int[n];
        int group[] = new int[n];
        Map<Integer, Integer> mp = new HashMap<>();

        int groupNo = 1;

        for(int i=0; i<n; i++)
        {
            if(visited[i] == 0)
            {
                int andVal[] = new int[1];
                andVal[0] = Integer.MAX_VALUE;

                dfs(i, visited, group, groupNo, andVal, adj);
                mp.put(groupNo, andVal[0]);

                groupNo++;
            }
        }

        int q = query.length;
        int ans[] = new int[q];

        for(int i=0; i<q; i++)
        {
            int u = query[i][0];
            int v = query[i][1];

            if(u == v)
            {
                ans[i] = 0;
            }
            else if(group[u] != group[v])
            {
                ans[i] = -1;
            }
            else
            {
                ans[i] = mp.get(group[u]);
            }
        }

        return ans;
    }
}