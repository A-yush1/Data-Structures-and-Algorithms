class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int n = s.length();
        int mp[] = new int[26];
        Arrays.fill(mp, -1);

        for(int i=0; i<n; i++)
        {
            mp[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> res = new ArrayList<>();
        int i = 0;

        while(i < n)
        {
            int end = mp[s.charAt(i) - 'a'];

            int j = i;
            while(j < end)
            {
                end = Math.max(end, mp[s.charAt(j) - 'a']);
                j++;
            }

            int len = (j - i + 1);
            res.add(len);

            i = end + 1;
        }

        return res;
    }
}