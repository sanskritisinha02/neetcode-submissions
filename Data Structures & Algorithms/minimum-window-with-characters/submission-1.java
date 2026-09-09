class Solution {
    public String minWindow(String s, String t) {

        int i = 0;
        int j = 0;
        int count = 0;
        int n = s.length();
        
        Map<Character, Integer> map_s = new HashMap<> ();
        Map<Character, Integer> map_t = new HashMap<> ();

        int min_len = Integer.MAX_VALUE;
        int start = 0;

        for(int x = 0; x < t.length(); x++){
            map_t.put(t.charAt(x), map_t.getOrDefault(t.charAt(x), 0) + 1);
        }

        while(j < n){

            map_s.put(s.charAt(j), map_s.getOrDefault(s.charAt(j), 0) + 1);

            if(map_t.containsKey(s.charAt(j)) && map_s.get(s.charAt(j)).equals(map_t.get(s.charAt(j)))){
                count++;
            }

            while(count == map_t.size()){
                if((j-i+1) < min_len){
                    min_len = j-i+1;
                    start = i;
                }
                    map_s.put(s.charAt(i), map_s.get(s.charAt(i)) - 1);
                    if(map_t.containsKey(s.charAt(i)) && map_s.get(s.charAt(i)) < map_t.get(s.charAt(i))){
                        count--;
                    }
                i++;
            }

            j++;
            
        }

        if(min_len == Integer.MAX_VALUE){
            return "";
        }
        
        return s.substring(start, start + min_len);
        
    }
}
