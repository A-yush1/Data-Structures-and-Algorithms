class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            list.add(grid[i][j]);
        }

        Collections.sort(list);
        int median = list.get((n * m) / 2);

        int res = 0;
        for(int num : list)
        {
            if(num % x != median % x)
            return -1;

            res += Math.abs(num - median) / x;
        }

        return res;
    }
}