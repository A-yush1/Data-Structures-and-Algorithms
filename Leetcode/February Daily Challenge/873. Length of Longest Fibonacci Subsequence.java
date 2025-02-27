class Solution {

    public int solve(int j, int k, int arr[], Map<Integer, Integer> mp)
    {
        int target = arr[k] - arr[j];

        if(mp.containsKey(target) && mp.get(target) < j)
        {
            int i = mp.get(target);
            return solve(i, j, arr, mp) + 1;
        }

        return 2;
    }
    public int lenLongestFibSubseq(int[] arr) {

        int n = arr.length;
        int res = 0;

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++)
        mp.put(arr[i], i);

        for(int j=1; j<n; j++)
        {
            for(int k=j+1; k<n; k++)
            {
                int len = solve(j, k, arr, mp);
                if(len >= 3)
                res = Math.max(res, len);
            }
        }
        
        return res;
    }
}