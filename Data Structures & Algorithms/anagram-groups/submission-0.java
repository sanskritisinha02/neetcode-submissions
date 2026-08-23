class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<> ();

        for(String s : strs){
            //act , pots
            char[] ch = s.toCharArray(); // [a,c,t] , [p,o,t,s]
            Arrays.sort(ch); //already sorted so [a,c,t] , [o,p,t,s]
            String key = new String(ch); //act //opts
            

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<> ()); // (act, [act])
                // (opts, [pots])
            }

            map.get(key).add(s); //for tops

        } 
        return new ArrayList <> (map.values());
    }
}
