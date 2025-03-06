class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        int gridSum = 0;
        int gridSqSum = 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                gridSum += grid[i][j];
                gridSqSum += grid[i][j] * grid[i][j];
            }
        }

        long actualSum = (N * (N + 1)) / 2;
        long actualSqSum = ((long)N * (N + 1) * (2 * N + 1)) / 6;

        // actualSum - gridSum = b - a --- (i)
        // actualSqSum - gridSqSum = (b + a) * (b -a) --- (ii)

        // (ii) / (i)
        // sqSumDiff / sumDiff = (b + a) --- (iii)

        // (iii) - (i)
        // ( sqSumDiff / sumDiff ) - sumDiff = 2 * a
        // a = ( ( sqSumDiff / sumDiff) - sumDiff ) / 2

        // b = sumDiff + a

        int sumDiff = (int)(actualSum - gridSum);
        int sqSumDiff = (int)(actualSqSum - gridSqSum);

        int a = ((sqSumDiff / sumDiff) - sumDiff) / 2;
        int b = sumDiff + a;

        int res[] = {a, b};
        return res;

    }
}