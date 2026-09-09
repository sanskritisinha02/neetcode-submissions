class Solution {
    public int characterReplacement(String s, int k) {

        int i = 0;
        int j = 0;
        int ans = 0;
        int maxFreq = 0;
        int n = s.length();

        Map<Character, Integer> map = new HashMap<> ();

        while(j < n){

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(j)));

            if((j-i+1) - maxFreq > k){

                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}
