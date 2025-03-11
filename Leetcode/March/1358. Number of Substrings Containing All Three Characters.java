class Solution {
    public int numberOfSubstrings(String s) {
        
        int n = s.length();
        int i = 0;
        int j = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int num = 0;
        while(j < n)
        {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            while(i <= j && mp.size() == 3)
            {
                num += n - j;
                ch = s.charAt(i);
                mp.put(ch, mp.get(ch) - 1);
                if(mp.get(ch) == 0)
                mp.remove(ch);

                i++;
            }

            j++;
        }

        return num;

    }
}