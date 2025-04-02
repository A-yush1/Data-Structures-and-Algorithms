class Solution {
    long solve(int idx, int questions[][], long dp[])
    {
        if(idx >= questions.length)
        return 0;

        if(dp[idx] != -1)
        return dp[idx];

        long notTake = solve(idx + 1, questions, dp);
        long take = questions[idx][0] + solve(idx + questions[idx][1] + 1, questions, dp);

        return dp[idx] =Math.max(notTake, take);
    }
    public long mostPoints(int[][] questions) {
        
        int n = questions.length;
        long dp[] = new long[n];
        Arrays.fill(dp, -1);
        return solve(0, questions, dp);
    }
}