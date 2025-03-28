class Solution {

    int dRow[] = { 0, 1, 0, -1 };
    int dCol[] = { 1, 0, -1, 0 };

    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int q = queries.length;
       int sortedQ[][] = new int[q][2];

       for(int i=0; i<q; i++)
       {
            sortedQ[i][0] = queries[i];
            sortedQ[i][1] = i;
       }

       Arrays.sort(sortedQ, (arr1, arr2) -> arr1[0] - arr2[0]);

       int n = grid.length;
       int m = grid[0].length;

       boolean visited[][] = new boolean[n][m];

       PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[0] - arr2[0]);
       pq.add(new int[] {grid[0][0], 0, 0});
       visited[0][0] = true;

       int cnt = 0;
       int res[] = new int[q];

       for(int i=0; i<q; i++)
       {
            int query = sortedQ[i][0];
            int queryIdx = sortedQ[i][1];

            while(!pq.isEmpty() && query > pq.peek()[0])
            {
                cnt++;
                int curr[] = pq.poll();
                int currRow = curr[1];
                int currCol = curr[2];

                for(int d=0; d<4; d++)
                {
                    int nextRow = currRow + dRow[d];
                    int nextCol = currCol + dCol[d];

                    if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol]){
                        visited[nextRow][nextCol] = true;
                        pq.add(new int[] {grid[nextRow][nextCol], nextRow, nextCol});
                        
                    }
                }
            }

            res[queryIdx] = cnt;
       }

       return res;
}
}