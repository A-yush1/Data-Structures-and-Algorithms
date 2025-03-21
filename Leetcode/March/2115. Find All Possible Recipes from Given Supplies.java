class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Set<String> st = new HashSet<>();
        List<String> res = new ArrayList<>();

        for(String str : supplies)
        st.add(str);

        while(true)
        {
            int sz = st.size();
            for(int i=0; i<ingredients.size(); i++)
            {
                boolean flag = true;
                for(String ing : ingredients.get(i))
                {
                    if(!st.contains(ing))
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag == true)
                {
                    if(recipes[i] != " ")
                    {
                    st.add(recipes[i]);
                    res.add(recipes[i]);
                    recipes[i] = " ";
                    }
                }
            }

            if(sz == st.size())
            break;

        }

        return res;
    }
}