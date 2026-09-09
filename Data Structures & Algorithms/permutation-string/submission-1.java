class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int i = 0;
        int j = 0;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int n = s2.length();
        int k = s1.length();

        for(int x = 0; x < s1.length(); x++){
            count1[s1.charAt(x) - 'a']++;
        }
        while(j < n){
            count2[s2.charAt(j) - 'a']++;
            if((j-i+1) > k){
                while((j-i+1) > k){
                    count2[s2.charAt(i) - 'a']--;
                    i++;
                }
            }

            if((j-i+1) == k){
                if(Arrays.equals(count1, count2)){
                    return true;
                }
            }
            
            j++;
        }
        return false;
    }
}
