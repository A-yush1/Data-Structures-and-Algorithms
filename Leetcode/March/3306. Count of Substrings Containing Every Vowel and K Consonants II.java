class Solution {
    long  solve(String word, int k)
    {
        int n = word.length();
        long num = 0;
        int i = 0;
        int j = 0;

        Map<Character, Integer> mp = new HashMap<>();
        int consonantCnt = 0;

        while(j < n)
        {
            char ch = word.charAt(j);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            else
            consonantCnt++;

            while(mp.size() == 5 && consonantCnt >= k)
            {
                num += n - j;
                ch = word.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                {
                    mp.put(ch, mp.get(ch) - 1);
                    if(mp.get(ch) == 0)
                    mp.remove(ch);
                    
                }
                else
                {
                    consonantCnt--;
                }
                i++;
            }
            j++;
        }

        return num;
    }
    public long countOfSubstrings(String word, int k) {
        
        long num1 = solve(word, k);
        long num2 = solve(word, k + 1);

        return num1 - num2;
    }
}